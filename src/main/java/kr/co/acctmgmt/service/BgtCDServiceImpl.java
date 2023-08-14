package kr.co.acctmgmt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.converter.BgtCDConverter;
import kr.co.acctmgmt.converter.BgtCDTermConverter;
import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.domain.BgtGr;
import kr.co.acctmgmt.dto.BgtCDDTO;
import kr.co.acctmgmt.dto.BgtCDTermDTO;
import kr.co.acctmgmt.mapper.BgtCDMapper;
import kr.co.acctmgmt.mapper.BgtICFMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BgtCDServiceImpl implements BgtCDService {

	private final BgtCDMapper mapper;
	private final BgtICFMapper bgtICFMapper;

	@Override
	public List<BgtCD> getBGTCDData(String coCd, String groupcd) {
		String bgtGrCd = groupcd;
		List<BgtCD> list;
		if (bgtGrCd.equals("전체")) {
			list = mapper.getBGTCDData(coCd, null);
		} else {
			list = mapper.getBGTCDData(coCd, bgtGrCd); // defN
		}
		System.out.println("*********Service  getBGTCDData***********.");
		System.out.println(list.get(0).toString());
		int cocd = Integer.parseInt(coCd); // <<< 여기가 문제일 확률이 있어
		System.out.println("cocd? : " + cocd);
		// String dataPath = "";

		/*
		 * [230731 수정 시작] ->수정사유 : 이전의 방식(DefLv을 가져와서 무조건적인 패스를 만드는 방식)이 비 생산적이라서 개선 .
		 * 1.dataPath는 이전에 사용한대로 '부모의 패스 데이터의 경로'로 사용한다. 즉 자기 바로 윗단계까지의 경로가 나와있음.
		 * 2.newdataPath는 실제로 사용되는 경로를 나타내야함. <<<<이거 아직안함 . 3.dataPath를 BCTCD 값으로 만들면서
		 * 다른곳에 장관항으로 만들 path도 만들어야한다.
		 */
		// Get parent DataPath //DataPath is { bgtCd, bgtCd, bgtCd,}
		for (int i = 0; i < list.size(); i++) {
			int cycle = 0;
			String TreeViewPath = "";
			// 1.부모의 경로
			String tempDataPath = list.get(i).getDataPath(); //
			System.out.println("체크체크");
			System.out.println(list.get(i).toString());
			// 수입수출여부
			// B002의 path는 수출이다 .
			System.out.println("몇번째 i 인가 :?" + i + "   이건 수입일까 수출일까 : ? " + list.get(i).getGrFg());
			if (list.get(i).getGrFg().equals("0")) {
				TreeViewPath = TreeViewPath + "수입,";
			} else if (list.get(i).getGrFg().equals("1")) {
				TreeViewPath = TreeViewPath + "수출,";
			}
			System.out.println("수입수출 적용됐는지 확인 : " + TreeViewPath);
			System.out.println("tempDataPaht?:" + tempDataPath);

			if (tempDataPath != null) {
				// 2.패스경로를 나눈다.->BgtCd값을 갖고있음 "B001,B002 ...."
				String[] tempList = tempDataPath.split(",");// --> 만약 B002다
				// 여기서 할건 부모의 정보로 장 관 항 세 목 정하기
				for (int p = 0; p < tempList.length; p++) { // B002의 .. B003의 ...
					System.out.println("tempList?" + tempList[p]);
					BgtCD initRow = mapper.getBgtCDDataForPath(tempList[p]); // -->B002의 정보
//					System.out.println("initRow?");
//					System.out.println(initRow.toString());
//					System.out.println("divFg는?:" + initRow.getDivFg());
					String divFgNm = initRow.getDivFg(); // Bgt_Cd Term에서 가져온 값.
					System.out.println("pathPiece :          ->" + divFgNm);
					BgtCD temp = new BgtCD();
					temp.setCoCd(cocd);
					temp.setDivFg(divFgNm);
					// -----
					divFgNm = mapper.getDataPath(temp);
					System.out.println("pathPiece 1차는 ?:" + divFgNm);
					if (initRow.getMultiCk() == 1) {
						for (int a = 0; a < initRow.getMultiNum(); a++) {
							divFgNm = divFgNm + " ";
						}
					}
					TreeViewPath = TreeViewPath + divFgNm + ",";
				} // int p for마무리

				BgtCD temp = new BgtCD();
				String a = list.get(i).getDivFg();
				temp.setCoCd(cocd);
				temp.setDivFg(a);
				String pathPiece2 = mapper.getDataPath(temp);// <<<defNm
				for (int z = 0; z < list.get(i).getMultiNum(); z++) {
					pathPiece2 = pathPiece2 + " ";
				}
				System.out.println("pathPiece2는?" + pathPiece2);
				TreeViewPath = TreeViewPath + pathPiece2 + ",";

				TreeViewPath = TreeViewPath.substring(0, TreeViewPath.length() - 1);
			} // null Check if문

			// null이다 ?
			else if (tempDataPath == null) {
				System.out.println("넌 널이야");
				String a = list.get(i).getDivFg();
				int cycle1 = list.get(i).getMultiNum();
				BgtCD temp = new BgtCD();
				temp.setCoCd(cocd);
				temp.setDivFg(a);
				String defNm = mapper.getDataPath(temp);
				if (list.get(i).getMultiCk() == 1) {
					for (int o = 0; o < cycle1; o++) {
						defNm = defNm + " ";
					}
				}
				TreeViewPath = TreeViewPath + defNm;
				System.out.println("널의 트리뷰:  " + TreeViewPath);
			}
			list.get(i).setDataPath(TreeViewPath);
			System.out.println();
			System.out.println();
		} // For i
		System.out.println("------");
		for (int q = 0; q < list.size(); q++) {
			System.out.println(list.get(q).getBgtCd() + ":" + list.get(q).getDataPath());
		}
		System.out.println("------");

		return list;
	}

	/*
	 * 새로운 bgtCd 만드는 코드
	 * 
	 */
	public String createNewBgtCd(String prevBgtCd, String divFg) {
		String nBgtCd = "";
		System.out.println("createNewBgtCd에서 prevBgtCd는 ? :" + prevBgtCd + "/divFg는 ?:" + divFg);
		int a = Integer.parseInt(prevBgtCd);
		int b = Integer.parseInt(divFg);
		b = b + 1;
		System.out.println("a는 ?:" + a);
		System.out.println("b는 ?:" + b);
		// 여기서 이전의 bgtCd의 값에서
		System.out.println("a값 ? : " + a);
		switch (b) {
		case 1:
			a = a + 10000000;
			break;
		case 2:
			a = a + 1000000;
			break;
		case 3:
			a = a + 100000;
			break;
		case 4:
			a = a + 10000;
			break;
		case 5:
			a = a + 1000;
			break;
		case 6:
			a = a + 100;
			break;
		case 7:
			a = a + 10;
			break;
		case 8:
			a = a + 1;
			break;
		default:
			break;
		}
		nBgtCd = Integer.toString(a);
		System.out.println("변경된 값은 ? : " + a);
		return nBgtCd;
	}

	/*
	 * dataPath 만들기ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ
	 * 
	 */
	public BgtCD convertTreeViewPathToDataPath(String dataPathNm, String bgtcd) {
		/*
		 * * 구할 값들 1. divFg o 2. grFg o 3. dataPath o 4. parentcd o 5. groupcd 6.
		 * multiNum o
		 */ // 장,관,항 ,목 , -> 11230000
		// 1000 0000,1100 0000, 1120 0000, 1123 0000,
		System.out.println("===convertTreeViewPathToDataPath===");
		System.out.println(dataPathNm);
		String grFg = "";
		String path = "";
		String parentCd = "";
		String[] list = dataPathNm.split(",");
		int divFg = list.length - 1; // 1.divFg
		if (list[0].equals("수입")) {
			grFg = "0";
		} else if (list[0].equals("수출")) {
			grFg = "1";
		} // 2.grFg

		StringBuilder dataPath = new StringBuilder();

		int baseValue = 10000000; // 기본 값
		int currentValue = 0; // 현재 값

		for (int i = 1; i < list.length; i++) {
			// 공백 수 세기
			int count = 0;
			for (char c : list[i].toCharArray()) {
				if (c == ' ') {
					count++;
				}
			}

			int multiplier = count + 1; // 공백 수 + 1
			int addValue = baseValue / (int) Math.pow(10, i - 1) * multiplier; // 추가될 값

			currentValue += addValue;
			if (i < list.length - 1) { // 마지막 iteration을 제외하고 dataPath에 추가
				dataPath.append(currentValue);
				dataPath.append(",");
			}
			path = dataPath.toString(); // 3.path
			if (i == list.length - 2) { // loop의 마지막에서 두 번째 iteration에서 parentCd 할당
				parentCd = String.valueOf(currentValue);
			}
		}
		System.out.println("convertTreeViewPathToDataPath메소드에서 path는? :" + path + "parenctCd는 ?:" + parentCd);
		int multiNum = Character.getNumericValue(bgtcd.charAt(divFg - 1)) - 1;
		BgtCD tempData = new BgtCD();
		tempData.setDivFg(Integer.toString(divFg));
		tempData.setGrFg(grFg);
		tempData.setDataPath(path);
		tempData.setParentCd(parentCd);
		tempData.setMultiNum(multiNum);

		return tempData;
	}// convertTreeViewPathToDataPath

	public String convertDataPathToTreeViewPath(String dataPath, String coCd, String divFg, String grFg, int mNum) {
		System.out.println("Start===============================================================================");
		String TreeViewPath = "";
		/*
		 * 1. 부모의 패스 2. 내 bgtCd 3. divFg 4. 수입수출여부
		 */
		int coCdInt = Integer.parseInt(coCd);
		if (grFg.equals("0")) {
			TreeViewPath = TreeViewPath + "수입,";
		} else if (grFg.equals("1")) {
			TreeViewPath = TreeViewPath + "수출,";
		}

		System.out.println("1.수입수출 적용 된 Treeviewpath : " + TreeViewPath);
		String[] list = dataPath.split(",");
		System.out.println("dataPath: " + dataPath); // 10000000,11000000
		for (int i = 0; i < list.length; i++) {
			/*
			 * 1.중복번호 2.DivFg값 조회
			 */
			BgtCD initRow = mapper.getBgtCDDataForPath(list[i]); // -->B002의 정보
			System.out.println("이번 initRow는 " + i + "번째꺼");
			System.out.println(initRow.toString());
			int multiCk = initRow.getMultiCk();
			int multiNum = initRow.getMultiNum();
			String nowBgtCd = initRow.getBgtCd();
			System.out.println("multiCK:" + multiCk + "/multiNum:" + multiNum + "확인   :" + nowBgtCd);
			BgtCD searchClue = new BgtCD();
			String cycle = Integer.toString(i + 1);
			searchClue.setDivFg(cycle);
			searchClue.setCoCd(coCdInt);
			String divNm = mapper.getDataPath(searchClue); // -->B002의 divFg값을 토대로 가져온 divNm
			System.out.println("divNm:" + divNm + "|끝값");
			for (int j = 0; j < multiNum; j++) {// 공백추가 " "
				divNm = divNm + " ";
			} // for j문
			TreeViewPath = TreeViewPath + divNm + ",";
		} // for i 문
		System.out.println("2.divNm에 공백을 추가해서 Treeview 구성 :" + TreeViewPath + "|끝값");
		// 여기까지 부모의 패스를 바꿨고 아래부터 자신의 패스를 추가해야함

		// 자신의 divFg
		BgtCD searchClue = new BgtCD();
		int myDivFg = Integer.parseInt(divFg);
		myDivFg = myDivFg + 1;
		divFg = Integer.toString(myDivFg);
		searchClue.setDivFg(divFg);
		searchClue.setCoCd(coCdInt);
		String divNm1 = mapper.getDataPath(searchClue); // 장...관....항.......
		// 공백을 몇번 추가해야 하는가 ? mNum
		for (int k = 0; k < mNum; k++) {
			divNm1 = divNm1 + " ";
		}
		TreeViewPath = TreeViewPath + divNm1;
		System.out.println("완성된 본인의 패스 :" + TreeViewPath + "|끝값쳌");
		System.out.println("End===============================================================================");
		return TreeViewPath;
	}// convertDataPathToTreeViewPath

	@Override
	public BgtCD addRowData(String bgtCd, String coCd) {
		/*
		 * 부모의 데이터를 가지고 와서 , 자식의 데이터를 만들어준다. ★★★★★★반드시 detailInfo 초기값 설정 해놓은 상태로 보낼것
		 * ★★★★★★★★ 처음에 부모의 값을 가져와서 bgtCd코드랑 데이터패스, treeviewPath를 만들어야한다.
		 */
		// 1.클릭한 데이터를 조회
		System.out.println("서비스임플의 bgtCd:" + bgtCd + "  coCd" + coCd);
		Map<String, String> params = new HashMap<>();
		params.put("bgtCd", bgtCd);
		params.put("coCd", coCd);
		// 이건 클릭한 데이터야
		BgtCD info = mapper.getAddRowData(params);
		String parentCd = bgtCd;
		String divFg = info.getDivFg();
		String path = info.getDataPath();
		String grFg = info.getGrFg();
		System.out.println("부모의값들=> divFg:" + divFg + "/path:" + path + "/grFg:" + grFg);
		BgtCD info2 = mapper.getMaxMultiNum(params); // ->부모의 값을 가진 자식값들 조회 .
		String prevBgtCd = "";
		int mNum = 0;
		int mCk = 0;
		if (info2 != null) {// 형제 값이 있는 경우 .
			System.out.println("형제 값이 있는 경우 .");
			prevBgtCd = info2.getBgtCd(); // 같은 부모를 가진 자식들 중 가장 multiNum값이 큰 애의 BgtCd
			mNum = info2.getMultiNum(); // 같은 부모를 가진 자식들 중 가장 multiNum값이 큰 애의 multinum
			mCk = info2.getMultiCk(); // 같은 부모를 가진 자식들 중 가장 multiNum값이 큰 애의 중복 체크 여부
			mNum = mNum + 1;
			System.out.println("prevBgtCd:" + prevBgtCd);
			System.out.println("maxMultiNum:" + info2.getMultiNum());
		} else if (info2 == null) { // 형제 값이 없는 경우 .
			System.out.println("이 친구를 부모로 갖는 애가 없네 , 이번에 추가되는 로우를 최초의 값으로 설정하자");
			BgtCD info3 = new BgtCD();
			mNum = 0;
			prevBgtCd = bgtCd;
			String nBgtCd = createNewBgtCd(prevBgtCd, divFg);
			info3.setBgtCd(nBgtCd);
			info3.setParentCd(parentCd);
			info3.setDivFg(divFg);
			info3.setGrFg(grFg);
			info3.setCtlFg("0");
			info3.setBgajustFg("0");
			info3.setBottomFg("1");
			info3.setBizFg("0");
			String nPath = (path + bgtCd);
			String TreeViewPath = convertDataPathToTreeViewPath(nPath, coCd, divFg, grFg, mNum);
			info3.setDataPath(TreeViewPath);
		}
		// 2.클릭한 데이터의 dataPath에 공백을 하나 더 추가 .
		// 2-1 클릭한 데이터의 부모의 부모path + 부모 => add로우할 데이터의 path
		String nPath = (path + bgtCd); // 코드
		System.out.println("nPath ? : " + nPath);
		// 2-2 dataPath를 원래 내가 사용해야할 dataPath로 바꿔준다.

		// 2-3 새로 만들어질 bgtCd의 MultiNum 에 1을 더해준다 ,divFg 값을 1더해준다

		// 3.클릭한 데이터의 parentCd에서 divFg단계에 맞게 숫자를 +해서 bgtCd생성
		String nBgtCd = createNewBgtCd(prevBgtCd, divFg);
		// 4.데이터가 실제로 들어갈 TreeViewPath를 만드는 과정

		// String dataPath, String coCd, String divFg,String grFg
		String TreeViewPath = convertDataPathToTreeViewPath(nPath, coCd, divFg, grFg, mNum);
		System.out.println("완성된 TreeViewPath ?:" + TreeViewPath);
		System.out.println("nBgtCd: " + nBgtCd);
		// 5.detailInfo의 기본 값 세팅
		BgtCD info3 = new BgtCD();
		info3.setCoCd(Integer.parseInt(coCd));
		info3.setBgtCd(nBgtCd);
		info3.setParentCd(parentCd);
		info3.setDivFg(divFg);
		info3.setGrFg(grFg);
		info3.setCtlFg("0");
		info3.setBgajustFg("0");
		info3.setBottomFg("1");
		info3.setBizFg("0");
		info3.setMultiCk(1);
		info3.setMultiNum(mNum);
		info3.setDataPath(TreeViewPath);
		// 5.값 반환
		return info3;
	}

//
//	@Override
//	public String getDefNmFromBGTCD_TERM(int divFg) {
//		return mapper.getDefNmFromBGTCD_TERM(divFg);
//	}

	@Override
	public List<BgtCD> getDetailInfo(String bgt_Cd) {
		List<BgtCD> list = mapper.getDetailInfo(bgt_Cd);
		return list;
	}

	@Override
	public void updateDetailInfo(BgtCD updateData) {
		mapper.updateDetailInfo(updateData);
	}

	@Override
	public void insertAddRow(BgtCD bgtCD) {
		System.out.println("===Service insertAddRow===");
		System.out.println(bgtCD.toString());
		// BgtCD(coCd=1000, bgtCd=11111000, parentCd=, gisu=0, bgtNm=애기리퍼만세, divFg=,
		// defNm=, ctlFg=null, bgajustFg=null, toDt=Thu Aug 10 09:18:36 KST 2023,
		// bottomFg=null, bizFg=null, groupCd=, grFg=, insertId=ashtal, insertDt=Thu Aug
		// 10 09:18:40 KST 2023, insertIp=, modifyId=, modifyDt=Thu Aug 10 09:18:40 KST
		// 2023, modifyIp=, MultiCk=0, MultiNum=0, dataPath=수입,장,관,항,세항,목 , keyword=,
		// bgtGrNm=, divCd=0, carrAm=0)
		// 넣을꺼 parentCd, divFg , ctlFg o , bgajustFg o , toDt o, bottomFg o , bizFg o ,
		// groupcd, grFg ,dataPath // parentcd , divfg, groupcd ,grfg, datapath
		/* null 값들 초기값 부여 */
		if (bgtCD.getCtlFg() == null) {
			bgtCD.setCtlFg("0");
		}
		if (bgtCD.getBgajustFg() == null) {
			bgtCD.setBgajustFg("0");
		}
		if (bgtCD.getBizFg() == null) {
			bgtCD.setBizFg("0");
		}
		if (bgtCD.getBottomFg() == null) {
			bgtCD.setBottomFg("1");
		}
		String dataPathNm = bgtCD.getDataPath();
		System.out.println("데이터패스의 임시 값 :" + dataPathNm);
		String bgtcd = bgtCD.getBgtCd();
		BgtCD tempData = convertTreeViewPathToDataPath(dataPathNm, bgtcd); // divFg, parentCd , grFg, dataPath 가 리턴됨 .
		int b = bgtCD.getCoCd();
		System.out.println("cocd ? : " + b);
		bgtCD.setCoCd(b);
		bgtCD.setDivFg(tempData.getDivFg());
		bgtCD.setGrFg(tempData.getGrFg());
		bgtCD.setDataPath(tempData.getDataPath());
		bgtCD.setParentCd(tempData.getParentCd());
		bgtCD.setMultiNum(tempData.getMultiNum());
		if (tempData.getMultiNum() != 0) {
			bgtCD.setMultiCk(1);
		} else {
			bgtCD.setMultiCk(0);
		}
		mapper.insertAddRow(bgtCD);
		System.out.println("insertMapper에 넣기전에 값 확인 ");
		System.out.println(bgtCD.toString());
		/*
		 * BgtCD(coCd=1000, bgtCd=11121000, parentCd=11121000, gisu=0, bgtNm=마지막 테스트야,
		 * divFg=5, defNm=, ctlFg=0, bgajustFg=0, toDt=Thu Aug 10 13:03:28 KST 2023,
		 * bottomFg=1, bizFg=0, groupCd=, grFg=0, insertId=ashtal, insertDt=Thu Aug 10
		 * 13:03:40 KST 2023, insertIp=, modifyId=, modifyDt=Thu Aug 10 13:03:40 KST
		 * 2023, modifyIp=, MultiCk=0, MultiNum=0,
		 * dataPath=10000000,11000000,11100000,11120000,11121000,, keyword=, bgtGrNm=,
		 * divCd=0, carrAm=0)
		 * 
		 * 
		 * 
		 * INSERT INTO BGTCD (CO_CD, BGT_CD,parentCd, GISU, BGT_NM, DIV_FG, CTL_FG,
		 * BGAJUST_FG, TO_DT, BOTTOM_FG, BIZ_FG, GROUP_CD, GR_FG, INSERT_ID,INSERT_DT,
		 * INSERT_IP, MODIFY_ID, MODIFY_DT, MODIFY_IP,Multi_Ck,Multi_Num,dataPath)
		 * VALUES
		 * (#{coCd},#{bgtCd},#{parentCd},#{gisu},#{bgtNm},#{divFg},#{ctlFg},#{bgajustFg}
		 * ,#{toDt},#{bottomFg},#{bizFg},#{groupCd},#{grFg},#{insertId},#{insertDt},#{
		 * insertIp},#{modifyId},#{modifyDt},#{modifyIp},#{MultiCk},#{MultiNum},#{
		 * dataPath});
		 * 
		 * 
		 * 
		 * BgtCD(coCd=1000, bgtCd=11210000, parentCd=11210000, gisu=0, bgtNm=변경가자!!!!,
		 * divFg=4, defNm=, ctlFg=0, bgajustFg=0, toDt=Thu Aug 10 13:14:24 KST 2023,
		 * bottomFg=1, bizFg=0, groupCd=, grFg=0, insertId=ashtal, insertDt=Thu Aug 10
		 * 13:14:31 KST 2023, insertIp=, modifyId=, modifyDt=Thu Aug 10 13:14:31 KST
		 * 2023, modifyIp=, MultiCk=0, MultiNum=0,
		 * dataPath=10000000,11000000,11200000,11210000,, keyword=, bgtGrNm=, divCd=0,
		 * carrAm=0)
		 * 
		 * 
		 */

	}

	@Override
	public int deleteRow(String bgtCd) {
		/*
		 * 먼저 받아온 예산코드를 부모값으로 갖고있는 자식 코드가 있는지 확인한다. 여기서 부모 코드라 함은 'parentCd'를 의미한다.
		 * 
		 */
		System.out.println("deleteRow입니다.");
		int data = 0;
		if (mapper.findUseParentCdSubject(bgtCd) != 0) {
			data = mapper.findUseParentCdSubject(bgtCd);
			System.out.println("얘를 부모로 갖고있는 애들이 있다...지울 수 없어....");
		} else {
			System.out.println("부모없음 걍 지워도됨 ");
			mapper.deleteRow(bgtCd);
		}
		System.out.println("리턴값은?" + data);
		// 변경못하는 이-유
		return data;
	}

	@Override
	public List<BgtCDTermDTO> getBgtCDTerm(String CO_CD) {
		System.out.println("Service's getBgtCDTerm");
		List<BgtCDTerm> list = mapper.getBgtCDTerm(CO_CD);

		for (int i = 0; i < list.size(); i++) {
			list.get(i).setDivFg(list.get(i).getDivFg() + "lv");
		}

		return BgtCDTermConverter.convertToDtoList(list);
	}

	@Override
	public List<BgtGr> getBgtGrData(String coCd) {
		System.out.println("getBgtGrData 서비스");

		return mapper.getBgtGrData(coCd);
	}

	@Override
	public List<BgtCDTermDTO> updateBgtCDTerm(List<BgtCDTermDTO> dataList) {
		String coCD = Integer.toString(dataList.get(1).getCoCd());
		for (BgtCDTermDTO data : dataList) {
			System.out.println("for-each loop : " + data);
			BgtCDTerm temp = BgtCDTermConverter.convertToModel(data);
			temp.setDivFg(temp.getDivFg().replace("lv", ""));

			mapper.updateBgtCDTerm(temp);
		}
		List<BgtCDTerm> list = mapper.getBgtCDTerm(coCD);
		System.out.println(list.toString());

		return BgtCDTermConverter.convertToDtoList(list);
	}

	@Override
	public void insertBgtGr(List<BgtGr> dataList) {
		System.out.println("인서트 BGTGR");
		String coCd = Integer.toString(dataList.get(0).getCoCd());

		System.out.println(dataList.toString());
		List<BgtGr> compareData = mapper.getBgtGrData(coCd);
		int coCdNm = Integer.parseInt(coCd);
		int addNum = compareData.size() + 1;

		System.out.println("추가할 번호 " + addNum);

		for (int i = addNum - 1; i < dataList.size() - 1; i++) {
			String bgtGr = Integer.toString(dataList.get(i).getBgtGrCd());
			int bgtGrNm = Integer.parseInt(bgtGr);
			dataList.get(i).setCoCd(coCdNm);
			dataList.get(i).setBgtGrCd(bgtGrNm);
			mapper.insertBgtGr(dataList.get(i));
		}
	}

	@Override
	public List<BgtCDDTO> findBgcCDByGroupCdAndToDtAndKeyword(BgtCDDTO bgtCDDTO) {

		BgtCD bgtCD = BgtCDConverter.convertToModel(bgtCDDTO);
		List<BgtCD> bgtCDList = mapper.findBgcCDByGroupCdAndToDtAndKeyword(bgtCD);
		return BgtCDConverter.convertToDtoList(bgtCDList);
	}

	@Override
	public List<BgtCDDTO> findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(BgtCDDTO bgtCDDTO) {

		BgtCD bgtCD = BgtCDConverter.convertToModel(bgtCDDTO);

		List<BgtCD> rBgtCDList = mapper.findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(bgtCD);

		List<BgtCD> nBgtCDList = new ArrayList();

		rBgtCDList.forEach(rBgtCD -> {
			double carrAm = bgtICFMapper.getSumBgtICFByCoCdAndBgtCd(rBgtCD);
			rBgtCD.setCarrAm(Integer.parseInt(String.valueOf(Math.round(carrAm))));
			nBgtCDList.add(rBgtCD);
		});

		return BgtCDConverter.convertToDtoList(nBgtCDList);
	}

	@Override
	public String getPath(String bgtCd) {
		// TODO Auto-generated method stub
		return mapper.getPath(bgtCd);
	}

	@Override
	public void deleteBgtGr(String coCd, String bgtGrCd) {
		mapper.deleteBgtGr(coCd,bgtGrCd);
		
	}

	@Override
	public List<BgtCD> getBgtCDdialog(String coCd) {
		
		
		
		return mapper.getBgtCDdialog(coCd);
	}

}
