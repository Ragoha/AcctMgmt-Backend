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
import kr.co.acctmgmt.domain.Gisu;
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
	public List<BgtCD> getBGTCDData(String coCd,String gisu, String groupcd) {
//		System.out.println("=>getBGTCDData gisu : " + gisu);
//		System.out.println("getBGTCDData에서 groupCd :"+ groupcd);

		List<BgtCD> list;
		if (groupcd.equals("전체")) {
			list = mapper.getBGTCDData(coCd,gisu, null);
		} else {
			list = mapper.getBGTCDData(coCd, gisu, groupcd);
		}
//		System.out.println("*********Service  getBGTCDData***********.");
//		System.out.println(list.get(0).toString());
//		System.out.println("cocd? : " + cocd);
		for (int i = 0; i < list.size(); i++) {
			int cycle = 0;
			String TreeViewPath = "";
			// 1.부모의 경로
			String tempDataPath = list.get(i).getDataPath(); //
//			System.out.println(i+"번재 list " );
//			System.out.println(list.toString());
			
			// 수입수출여부
			// B002의 path는 수출이다 .
			if (list.get(i).getGrFg().equals("0")) {
				TreeViewPath = TreeViewPath + "수입,";
			} else if (list.get(i).getGrFg().equals("1")) {
				TreeViewPath = TreeViewPath + "수출,";
			}
			/*↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ 수입인지 수출인지 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑*/
			
			if (tempDataPath != null) {
				// 2.패스경로를 나눈다.->BgtCd값을 갖고있음 "B001,B002 ...."
				String[] tempList = tempDataPath.split(",");// --> 만약 B002다
				// 여기서 할건 부모의 정보로 장 관 항 세 목 정하기
				for (int p = 0; p < tempList.length; p++) { // B002의 .. B003의 ...
//System.out.println("tempList?" + tempList[p]);
					BgtCD initRow = mapper.getBgtCDDataForPath(coCd,gisu,groupcd,tempList[p]); // -->B002의 정보//cocd,gisu,groupcd,bgtCd
//System.out.println("initRow?");
//System.out.println(initRow.toString());
//					System.out.println("divFg는?:" + initRow.getDivFg());
					String divFgNm = initRow.getDivFg(); // Bgt_Cd Term에서 가져온 값.
//					System.out.println("pathPiece :          ->" + divFgNm);
					BgtCD temp = new BgtCD();
					temp.setCoCd(coCd);
					temp.setDivFg(divFgNm);
					// -----
					divFgNm = mapper.getDataPath(temp);
//					System.out.println("pathPiece 1차는 ?:" + divFgNm);
					for (int a = 0; a < initRow.getMultiNum(); a++) {
						divFgNm = divFgNm + " ";
					}
					TreeViewPath = TreeViewPath + divFgNm + ",";
				} // int p for마무리

				BgtCD temp = new BgtCD();
				String a = list.get(i).getDivFg();
				temp.setCoCd(coCd);
				temp.setDivFg(a);
				String pathPiece2 = mapper.getDataPath(temp);// <<<defNm
				for (int z = 0; z < list.get(i).getMultiNum(); z++) {
					pathPiece2 = pathPiece2 + " ";
				}
//				System.out.println("pathPiece2는?" + pathPiece2);
				TreeViewPath = TreeViewPath + pathPiece2 + ",";

				TreeViewPath = TreeViewPath.substring(0, TreeViewPath.length() - 1);
			} // null Check if문

			// null이다 ?
			else if (tempDataPath == null) {
//				System.out.println("넌 널이야");
				String a = list.get(i).getDivFg();
				int cycle1 = list.get(i).getMultiNum();
				BgtCD temp = new BgtCD();
				temp.setCoCd(coCd);
				temp.setDivFg(a);
				String defNm = mapper.getDataPath(temp);
				if (list.get(i).getMultiCk() == 1) {
					for (int o = 0; o < cycle1; o++) {
						defNm = defNm + " ";
					}
				}
				TreeViewPath = TreeViewPath + defNm;
//				System.out.println("널의 트리뷰:  " + TreeViewPath);
			}
			list.get(i).setDataPath(TreeViewPath);
//			System.out.println();
//			System.out.println();
		} // For i
//		System.out.println("------");
//		for (int q = 0; q < list.size(); q++) {
//			System.out.println(list.get(q).getBgtCd() + ":" + list.get(q).getDataPath());
//		}
//		System.out.println("------");

		return list;
	}
	public String createDivFg(String bgtCd) {
	    int countZeros = 0;
	    for (int i = bgtCd.length() - 1; i >= 0; i--) {
	        if (bgtCd.charAt(i) == '0') {
	            countZeros++;
	        } else {
	            break; // 연속된 0이 끝나면 루프를 종료합니다.
	        }
	    }
	    int divFg = 8 - countZeros;

	    return Integer.toString(divFg);
	}

	/*
	 * 새로운 bgtCd 만드는 코드
	 * 
	 */
	public String createNewBgtCd(String prevBgtCd, String divFg) {
		String nBgtCd = "";
//		System.out.println("createNewBgtCd에서 prevBgtCd는 ? :" + prevBgtCd + "/divFg는 ?:" + divFg);
		int a = Integer.parseInt(prevBgtCd);
		int b = Integer.parseInt(divFg);
		b = b + 1;
//		System.out.println("a는 ?:" + a);
//		System.out.println("b는 ?:" + b);
		// 여기서 이전의 bgtCd의 값에서
//		System.out.println("a값 ? : " + a);
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
//		System.out.println("변경된 값은 ? : " + a);
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
		System.out.println("===convertTreeViewPathToDataPath======");
//		System.out.println(dataPathNm);
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
//		System.out.println("convertTreeViewPathToDataPath메소드에서 path는? :" + path + "parenctCd는 ?:" + parentCd);
		int multiNum = Character.getNumericValue(bgtcd.charAt(divFg - 1)) - 1;
		BgtCD tempData = new BgtCD();
		tempData.setDivFg(Integer.toString(divFg));
		tempData.setGrFg(grFg);
		tempData.setDataPath(path);
		tempData.setParentCd(parentCd);
		tempData.setMultiNum(multiNum);

		return tempData;
	}// convertTreeViewPathToDataPath

	public String convertDataPathToTreeViewPath(String dataPath, String coCd,String gisu,  String groupCd, String divFg, String grFg, int mNum) {
		System.out.println("Start==dataPath-> TreeViewPath ===========================================================================");
		String TreeViewPath = "";
		/*
		 * 1. 부모의 패스 2. 내 bgtCd 3. divFg 4. 수입수출여부
		 */
		System.out.println("datapath : " + dataPath + "/CoCd:" + coCd + "/divFg: " + divFg + "/grFg: " + grFg + "/mNum :" + mNum);
		if (grFg.equals("0")) {
			TreeViewPath = TreeViewPath + "수입,";
		} else if (grFg.equals("1")) {
			TreeViewPath = TreeViewPath + "수출,";
		}

//		System.out.println("1.수입수출 적용 된 Treeviewpath : " + TreeViewPath);
		String[] list = dataPath.split(",");
//		System.out.println("dataPath: " + dataPath); // 10000000,11000000
		for (int i = 0; i < list.length; i++) {
			/*
			 * 1.중복번호 2.DivFg값 조회
			 */
			System.out.println(i+"번째 ::: " + list[i]);
			//coCd ,gisu, groupCd, bgtCd
			BgtCD initRow = mapper.getBgtCDDataForPath(coCd ,gisu ,groupCd, list[i]); // -->B002의 정보
			System.out.println(initRow.toString());
//			System.out.println("이번 initRow는 " + i + "번째꺼");
//			System.out.println(initRow.toString());
//			int multiCk = initRow.getMultiCk();
			int multiNum = initRow.getMultiNum();
			String nowBgtCd = initRow.getBgtCd();
			System.out.println("/multiNum:" + multiNum + "확인   :" + nowBgtCd);
			BgtCD searchClue = new BgtCD();
			String cycle = Integer.toString(i + 1);
			searchClue.setDivFg(cycle);
			searchClue.setCoCd(coCd);
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
		searchClue.setCoCd(coCd);
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
	public BgtCD addRowData(String bgtCd, String coCd,String gisu,String groupCd) {
		System.out.println("[grpupCd] " + groupCd);
		/*
		 * 부모의 데이터를 가지고 와서 , 자식의 데이터를 만들어준다. ★★★★★★반드시 detailInfo 초기값 설정 해놓은 상태로 보낼것
		 * ★★★★★★★★ 처음에 부모의 값을 가져와서 bgtCd코드랑 데이터패스, treeviewPath를 만들어야한다.
		 */
		// 1.클릭한 데이터를 조회
//		System.out.println("서비스임플의 bgtCd:" + bgtCd + "  coCd" + coCd);
		Map<String, String> params = new HashMap<>();
		params.put("bgtCd", bgtCd);
		params.put("coCd", coCd);
		params.put("groupCd", groupCd);
		params.put("gisu", gisu);
		// 이건 클릭한 데이터야
		BgtCD info = mapper.getAddRowData(params);
		System.out.println("bgtCd , coCd , gisu , groupCd::->" + bgtCd +"/"+coCd+"/"+gisu+"/"+groupCd);
		String parentCd = bgtCd;
		String divFg = info.getDivFg();
		String path = info.getDataPath();
		String grFg = info.getGrFg();
//		System.out.println("부모의값들=> divFg:" + divFg + "/path:" + path + "/grFg:" + grFg);
		BgtCD info2 = mapper.getMaxMultiNum(params); // ->부모의 값을 가진 자식값들 조회 .
		String prevBgtCd = "";
		int mNum = 0;
		if (info2 != null) {// 형제 값이 있는 경우 .
			System.out.println("형제 값이 있는 경우 .");
			prevBgtCd = info2.getBgtCd(); // 같은 부모를 가진 자식들 중 가장 multiNum값이 큰 애의 BgtCd
			mNum = info2.getMultiNum(); // 같은 부모를 가진 자식들 중 가장 multiNum값이 큰 애의 multinum
			mNum = mNum + 1;
//			System.out.println("prevBgtCd:" + prevBgtCd);
//			System.out.println("maxMultiNum:" + info2.getMultiNum());
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
			String nPath = bgtCd;
			String TreeViewPath = convertDataPathToTreeViewPath(nPath, coCd, gisu, groupCd, divFg, grFg, mNum);
			info3.setDataPath(TreeViewPath);

			return info3;
		}
		System.out.println("여기로넘어오는건가 ?"); //여기로?
		// 2.클릭한 데이터의 dataPath에 공백을 하나 더 추가 .
		// 2-1 클릭한 데이터의 부모의 부모path + 부모 => add로우할 데이터의 path
		String nPath =  bgtCd; // 코드
//		System.out.println("nPath ? : " + nPath);
		// 2-2 dataPath를 원래 내가 사용해야할 dataPath로 바꿔준다.

		// 2-3 새로 만들어질 bgtCd의 MultiNum 에 1을 더해준다 ,divFg 값을 1더해준다

		// 3.클릭한 데이터의 parentCd에서 divFg단계에 맞게 숫자를 +해서 bgtCd생성
		String nBgtCd = createNewBgtCd(prevBgtCd, divFg);
		// 4.데이터가 실제로 들어갈 TreeViewPath를 만드는 과정

		// String dataPath, String coCd, String divFg,String grFg
		String TreeViewPath = convertDataPathToTreeViewPath(nPath, coCd,gisu,groupCd, divFg, grFg, mNum);
//		System.out.println("완성된 TreeViewPath ?:" + TreeViewPath);
//		System.out.println("nBgtCd: " + nBgtCd);
		// 5.detailInfo의 기본 값 세팅
		BgtCD info3 = new BgtCD();
		info3.setCoCd(coCd);
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
		info3.setGroupCd(groupCd);
		// 5.값 반환
		return info3;
	}


	@Override
	public String getDefNmFromBGTCD_TERM(String coCd, String divFg) {
		return mapper.getDefNmFromBGTCD_TERM(coCd, divFg);
	}

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
		String groupCd = "";
		String coCd = bgtCD.getCoCd();
		String gisu = Integer.toString(bgtCD.getGisu());
		System.out.println("groupCd , coCd , gisu  : " +groupCd+"/"+coCd+"/"+gisu);
		/* null 값들 초기값 부여 */
//		if (bgtCD.getCtlFg() == null) {
			bgtCD.setCtlFg("0");
//		}
//		if (bgtCD.getBgajustFg() == null) {
			bgtCD.setBgajustFg("0");
//		}
//		if (bgtCD.getBizFg() == null) {
			bgtCD.setBizFg("0");
//		}
//		if (bgtCD.getBottomFg() == null) {
			bgtCD.setBottomFg("1");
//		}
		String[] a = bgtCD.getGroupCd().split("\\.");
		groupCd = a[0];
		bgtCD.setGroupCd(groupCd);
		String dataPathNm = bgtCD.getDataPath();
		System.out.println("데이터패스의 임시 값 :" + dataPathNm);//수입,항,세항,목
		String[]b = dataPathNm.split(",");
		// b 배열의 마지막 값 가져오기
 		String lastValue = b[b.length - 1];
		int mNum = 0;

		for (int i = 0; i < lastValue.length(); i++) {
		    if (lastValue.charAt(i) == ' ') {
		        mNum++;
		    }
		}
		String grfg = "";
		if(b[0].equals("수입")) {
			grfg="0";
		}
		if(b[0].equals("수출")) {
			grfg="1";
		}
		System.out.println(bgtCD.toString());
		/*
		 *  여기서부터 divFg값을 가져와서 새로 패스를 만들고
		 *  뚝딱뚝딱
		 */
		System.out.println("끄엥?:"+ bgtCD.getParentCd());//끄엥?:11110000
		
		BgtCD abc =  mapper.getBgtCDDataForPath(coCd, gisu, groupCd, bgtCD.getParentCd()); //1.부모의 부모의 패스여서 //cocd,gisu,groupcd,bgtCd
		
		String abcPath = abc.getDataPath();
		System.out.println("abcPath : "+abcPath + "/bgtCd ? :" + abc.getBgtCd()) ;//abcPath : 10000000,11000000,11100000,
		if(abcPath!=null) {
			abcPath= abcPath+bgtCD.getParentCd()+"," ; //2.내가 갖어야할 패스로 만들어버린다. 
		}else if(abcPath==null) {
			abcPath =bgtCD.getParentCd()+",";
		}
		String abcDivFg= createDivFg(bgtCD.getBgtCd());
		bgtCD.setCoCd(bgtCD.getCoCd());
		bgtCD.setDivFg(abcDivFg);
		bgtCD.setGrFg(grfg);
		bgtCD.setDataPath(abcPath);
		bgtCD.setMultiNum(mNum);
		mapper.insertAddRow(bgtCD);

	}

	@Override
	public int deleteRow(String bgtCd,String coCd) {
		/*
		 * 먼저 받아온 예산코드를 부모값으로 갖고있는 자식 코드가 있는지 확인한다. 여기서 부모 코드라 함은 'parentCd'를 의미한다.
		 * 
		 */
		String msg = "";
		int msgNum = 0;
		int data = mapper.findUseParentCdSubject(bgtCd);
		int chk = mapper.findUseParentCdSubjectInBgtICF(coCd,bgtCd);
		if(chk !=0) {
			msg = "사용중인 데이터입니다.";
			msgNum =0;
		}else {
			if (data != 0) {
				msg ="해당 과목의 하위과목이 존재합니다";
				msgNum = 1; 
			} else {
				msg = "삭제완료";
				msgNum = 2;
				mapper.deleteRow(bgtCd,coCd);
			}
		}
		System.out.println(msg);
		
		
		// 변경못하는 이-유
		return msgNum;
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
		String coCd = Integer.toString(dataList.get(0).getCoCd());
		List<BgtGr> compareData = mapper.getBgtGrData(coCd);

//	        mapper.insertBgtGr();
	}

	@Override
	public List<BgtCDDTO> findBgcCDByGroupCdAndToDtAndKeyword(BgtCDDTO bgtCDDTO) {

		BgtCD bgtCD = BgtCDConverter.convertToModel(bgtCDDTO);
		System.out.println("=======================");
		System.out.println(bgtCD.toString());
		List<BgtCD> bgtCDList = mapper.findBgcCDByGroupCdAndToDtAndKeyword(bgtCD);
		return BgtCDConverter.convertToDtoList(bgtCDList);
	}

	@Override
	public List<BgtCDDTO> findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(BgtCDDTO bgtCDDTO) {

		BgtCD bgtCD = BgtCDConverter.convertToModel(bgtCDDTO);
		System.out.println(bgtCD.getBgtCdList().size());
		List<BgtCD> rBgtCDList = new ArrayList<>();
		
		if (bgtCD.getBgtCdList().size() == 0) {
		    rBgtCDList.addAll(mapper.findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(bgtCD));
		} else {
		    bgtCD.getBgtCdList().forEach(bgtCdItem -> {
		        BgtCD tempBgtCD = BgtCD.builder()
		        		.coCd(bgtCD.getCoCd())
		        		.divCd(bgtCD.getDivCd())
		        		.gisu(bgtCD.getGisu())
		        		.bgtGrCdList(bgtCD.getBgtGrCdList())
		        		.grFg(bgtCD.getGrFg())
		        		.bgtCd(bgtCdItem)
		        		.build();
		        tempBgtCD.setBgtCd(bgtCdItem);
		        
		        rBgtCDList.addAll(mapper.findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd1(tempBgtCD));
		    });
		}

		
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
		mapper.deleteBgtGr(coCd, bgtGrCd);

	}

	@Override
	public List<BgtCD> getBgtCDdialog(String coCd , String keyword) {
		System.out.println("keyword : " +  keyword);
		return mapper.getBgtCDdialog(coCd ,keyword);
	}

	@Override
	public List<BgtCD> getBgtCdLikeSearch(String coCd, String keyword) {

		return mapper.getBgtCdLikeSearch(coCd, keyword);
	}

	@Override
	public List<BgtCD> getSearchData(String coCd, String gisu, String groupCd, String keyword) {
		/*
		 * SELECT * FROM BGTCD WHERE CO_CD=#{coCd} and GROUP_CD=#{groupCd} and
		 * GISU=#{gisu} and (BGT_CD LIKE CONCAT('%', #{keyword}, '%') OR BGT_NM LIKE
		 * CONCAT('%', #{keyword}, '%'));
		 */
		System.out.println("==SERVICE: getSearchData===");
		System.out.println("keyword : " + keyword);
		List<BgtCD> bgtcd = null;
		if (keyword != null ||keyword !="") {
			String[] a = groupCd.split("\\.");
			String[] b = keyword.split("\\.");
			groupCd = a[0];
			keyword = b[0];
			bgtcd = mapper.getSearchData(coCd, gisu, groupCd, keyword);
		}  
		if(keyword==null || keyword ==""){
			System.out.println("keyword null이거나 공백일때 getBGTCDdata를하고 return함. 아래는 그 값. ");
			String[] a = groupCd.split("\\.");
			groupCd = a[0];
//			System.out.println("coCd: "+ coCd + "/gisu: "+gisu+"groupCd :"+groupCd);
			bgtcd = getBGTCDData(coCd, gisu, groupCd);
			System.out.println(bgtcd.toString());
			return bgtcd;
		}
		String TreeViewPath = "";
		String basePath = "";
		String grfg = "";

		for (int i = 0; i < bgtcd.size(); i++) {
			String tPath = bgtcd.get(i).getDataPath();
			if (tPath != null) {
				if (bgtcd.get(i).getGrFg().equals("0")) {
					TreeViewPath = "수입,";
				} else if (bgtcd.get(i).getGrFg().equals("1")) {
					TreeViewPath = "수출,";
				}
				grfg = TreeViewPath;
				System.out.println("tPaht::::>>>>"+ tPath);
				String[] tPathList = tPath.split(",");
				for (int j = 0; j < tPathList.length; j++) {
					BgtCD tInfo = mapper.getBgtCDDataForPath(coCd,gisu,groupCd, tPathList[j]);
					System.out.print(j+"번째" +"tPathList[j] : "+tPathList[j]);
					System.out.println(tInfo.toString());
					String divFgNm = tInfo.getDivFg();
					System.out.println(tPathList[j]+" 의 divFgNm값 :" +divFgNm);
					BgtCD temp = new BgtCD();
					temp.setCoCd(coCd);
					temp.setDivFg(divFgNm);
					divFgNm = mapper.getDataPath(temp);
					for (int k = 0; k < tInfo.getMultiNum(); k++) {

						divFgNm = divFgNm + " ";
					}
					TreeViewPath = TreeViewPath + divFgNm + ",";
				}
				System.out.println(bgtcd.get(i).getBgtCd() + "의 데이터 패스 :" + TreeViewPath);
				if (i == 0) {
					basePath = TreeViewPath;
					System.out.println("i=0 basePath : " + TreeViewPath);
				}

				int mNum = bgtcd.get(i).getMultiNum();
				BgtCD tInfo = mapper.getBgtCDDataForPath(coCd,gisu,groupCd,bgtcd.get(i).getBgtCd());
				String divFgNm = tInfo.getDivFg();
				BgtCD temp = new BgtCD();
				temp.setCoCd(coCd);
				temp.setDivFg(divFgNm);
				divFgNm = mapper.getDataPath(temp);
				for (int k = 0; k < tInfo.getMultiNum(); k++) {

					divFgNm = divFgNm + " ";
				}
				TreeViewPath = TreeViewPath.replace(basePath, grfg);
				TreeViewPath = TreeViewPath + divFgNm;
				System.out.println(bgtcd.get(i).getBgtCd() + "의 최종 데이터 패스 :" + TreeViewPath);
				bgtcd.get(i).setDataPath(TreeViewPath);
			} else if (tPath == null) {
				if (bgtcd.get(i).getGrFg().equals("0")) {
					TreeViewPath = "수입,";
				} else if (bgtcd.get(i).getGrFg().equals("1")) {
					TreeViewPath = "수출,";
				}
				int mNum = bgtcd.get(i).getMultiNum();
				BgtCD tInfo = mapper.getBgtCDDataForPath(coCd,gisu,groupCd, bgtcd.get(i).getBgtCd());
				String divFgNm = tInfo.getDivFg();
				BgtCD temp = new BgtCD();
				temp.setCoCd(coCd);
				temp.setDivFg(divFgNm);
				divFgNm = mapper.getDataPath(temp);
				for (int k = 0; k < tInfo.getMultiNum(); k++) {
					divFgNm = divFgNm + " ";
				}
				TreeViewPath = TreeViewPath + divFgNm;
				System.out.println(bgtcd.get(i).getBgtCd() + "의 최종 데이터 패스 :" + TreeViewPath);
				bgtcd.get(i).setDataPath(TreeViewPath);
			}
		}
		return bgtcd;
	}

	@Override
	public List<Gisu> getinitGisuList(String coCd) {
		return mapper.getinitGisuList(coCd);
	}

	@Override
	public List<BgtGr> getinitBgtGrSearch(String coCd,String keyword) {
		System.out.println("keyword : " + keyword);
		List<BgtGr> list =  mapper.getinitBgtGrSearch(coCd,keyword);
		System.out.println(list.toString());
		return list;
	}

	@Override
	public List<BgtGr> getBgtGrSearch(String coCd, String keyword) {

		return mapper.getBgtGrSearch(coCd, keyword);
	}
	@Override
	public void updateBgtNm(String coCd, String bgtCd, String bgtNm) {
		mapper.updateBgtNm(coCd,bgtCd,bgtNm);
		
	}
	@Override
	public BgtCD checkTopData(String coCd, String gisu, String tDataPath, String keyword) {
		//SELECT DEF_NM from BGTCD_TERM where DIV_FG =#{divFg} and CO_CD=#{coCd};
		//id = getDefNmFromBGTCD_TERM
		System.out.println("coCd : " + coCd + "/ gisu : " + gisu +"/ tDataPath :"+tDataPath + "/ keyword : "+keyword);
		String divFg = "1";
		String defNm = mapper.getDefNmFromBGTCD_TERM(coCd, divFg); //장 
		String grFg="";
		String TreeViewPath ="";
		int mNum = 0;
		if(tDataPath.equals("수입,")) {
			grFg="0";
		}else if(tDataPath.equals("수출,")) {
			grFg="1";
		}
		List<BgtCD> tData=  mapper.checkTopData(coCd,gisu,grFg);
		String bgtCd = "";
		if(tData==null||tData.isEmpty()) { //형제 값이 없는 최초의 데이터이다. 
			System.out.println("형제값 x");
			bgtCd = "10000000";
		    mNum = Integer.parseInt(bgtCd);
			mNum = (mNum/10000000)-1;
			for(int i = 0 ; i<mNum ;i++) {
				defNm=defNm +" ";
			}
			TreeViewPath = tDataPath+defNm;
			
			
		}else if(tData !=null) {
			System.out.println("형제값o");
			System.out.println("tData값은 ? : ");
			System.out.println(tData.toString());
			BgtCD lastData = tData.get(tData.size()-1);
		    bgtCd = lastData.getBgtCd();
		    bgtCd = Integer.toString(Integer.parseInt(bgtCd)+10000000);
		    
		    mNum = Integer.parseInt(bgtCd);
			mNum = (mNum/10000000)-1;
			for(int i = 0 ; i<mNum ;i++) {
				defNm=defNm +" ";
			}
			TreeViewPath = tDataPath+defNm;
		}
		
		BgtCD data  = new BgtCD();
		
		data.setGrFg(grFg);
		data.setDataPath(TreeViewPath);
		data.setDivFg(divFg);
		data.setCoCd(coCd);
		data.setBgtCd(bgtCd);
		data.setMultiNum(mNum);
		
		System.out.println("<==end");
		return data ;
		
	}
	@Override
	public List<BgtGr> getbgtGrSearchKeywordData(String coCd, String keyword) {
		return mapper.getbgtGrSearchKeywordData(coCd, keyword);
	}
}


























