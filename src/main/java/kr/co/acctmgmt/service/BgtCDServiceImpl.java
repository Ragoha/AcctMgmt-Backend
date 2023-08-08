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
	public List<BgtCD> getBGTCDData(String groupcd) {
		List<BgtCD> list = mapper.getBGTCDData(groupcd); // defN
		System.out.println("*********Service  getBGTCDData***********.");
		System.out.println("groupCd ? " + groupcd);
		System.out.println(list.get(0).toString());
		int cocd = list.get(0).getCoCd(); // Integer.parseInt(groupcd);
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
					//-----
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
	 * dataPath 만들기ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ
	 * 
	 */
	public String convertDataPathToTreeViewPath(String dataPath, String coCd, String divFg,String grFg) {
		String TreeViewPath="";
		/*
			1. 부모의 패스 
			2. 내 bgtCd
			3. divFg
			4. 수입수출여부
		*/
		int coCdInt = Integer.parseInt(coCd);
		if (grFg.equals("0")) {
			TreeViewPath = TreeViewPath + "수입,";
		} else if (grFg.equals("1")) {
			TreeViewPath = TreeViewPath + "수출,";
		}
System.out.println("1. 수입수출 적용 된 Treeviewpath : " +TreeViewPath);
		String[] list = dataPath.split(",");
		for(int i =0;i<list.length;i++) {
			/*
			 * 1.중복번호
			 * 2.DivFg값 조회 
			 */
			BgtCD initRow = mapper.getBgtCDDataForPath(list[i]); // -->B002의 정보
			int multiCk =initRow.getMultiCk();
			int multiNum =initRow.getMultiNum();
			BgtCD searchClue = new BgtCD();
			searchClue.setDivFg(divFg);
			searchClue.setCoCd(coCdInt);
			String divNm = mapper.getDataPath(searchClue); //-->B002의 divFg값을 토대로 가져온 divNm
			for(int j=0;j<multiNum;j++) {//공백추가 " "
				divNm= divNm+" ";
			}//for j문 
			TreeViewPath= divNm+",";
		}//for i 문 
System.out.println("2.divNm에 공백을 추가해서 Treeview 구성 :" + TreeViewPath+"|끝값");
		return null;
	}
	@Override
	public BgtCD addRowData(String bgtCd, String coCd) {
		/*
		 * 부모의 데이터를 가지고 와서 , 자식의 데이터를 만들어준다.
		 * ★★★★★★반드시 detailInfo 초기값 설정 해놓은 상태로 보낼것 ★★★★★★★★
		 * 
		 * 처음에 부모의 값을 가져와서
		 * bgtCd코드랑 데이터패스, treeviewPath를 만들어야한다. 
		 */
		// 1.클릭한 데이터를 조회
System.out.println("서비스임플의 bgtCd:"+bgtCd +"  coCd"+coCd);
		Map<String, String> params = new HashMap<>();
		params.put("bgtCd", bgtCd);
		params.put("coCd", coCd);
		//이건 클릭한 데이터야ㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑ
		BgtCD info = mapper.getAddRowData(params);
		String parentCd=bgtCd;
		String divFg = info.getDivFg();
		String path  = info.getDataPath();
		String grFg  = info.getGrFg();
System.out.println("부모의값들=> divFg:"+divFg+"/path:"+path+ "/grFg:"+grFg);
		BgtCD info2 = mapper.getMaxMultiNum(params);
		String prevBgtCd = info.getBgtCd();  //같은 부모를 가진 자식들중 가장 multiNum값이 큰 애의 BgtCd
		int num = info2.getMultiNum();       //같은 부모를 가진 자식들중 가장 multiNum값이 큰 애의 multinum
		int mck = info2.getMultiCk();        //같은 부모를 가진 자식들중 가장 multiNum값이 큰 애의 중복 체크 여부 
System.out.println("prevBgtCd:" + prevBgtCd );
System.out.println("maxMultiNum:" + info2.getMultiNum());
		// 2.클릭한 데이터의 dataPath에 공백을 하나 더 추가 .
		// 2-1 클릭한 데이터의 부모의 부모path + 부모 => add로우할 데이터의 path
		String nPath = (path + bgtCd); // 코드 
System.out.println("nPath ? : "+ nPath);
		// 2-2 dataPath를 원래 내가 사용해야할 dataPath로 바꿔준다. 
		
		// 2-3 클릭한 데이터의 num 에 1을 더해준다 ,divFg 값을 1더해준다
		num= num+1;
		// 3.클릭한 데이터의 parentCd에서 divFg단계에 맞게 숫자를 +해서 bgtCd생성
		String nBgtCd = createNewBgtCd(prevBgtCd, divFg);
System.out.println("nBgtCd: "+nBgtCd);
		// 4.detailInfo의 기본 값 세팅
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
	//	info.setDataPath(nPath);
		// 5.값 반환
		return info3 ; 
	}

	public String createNewBgtCd(String bgtCd, String divFg) {
		String  nBgtCd = "";
		int a = Integer.parseInt(bgtCd);
		int b = Integer.parseInt(divFg);
		b=b+1;
		
		
		
		
		
		
System.out.println("a값 ? : " + a );
		switch (b) {
		case 1:
			a= a+10000000;
			break; 
		case 2:
			a= a+1000000;
			break;
		case 3:
			a= a+100000;
			break;
		case 4:
			a= a+10000;
			break;
		case 5:
			a= a+1000;
			break;
		case 6:
			a= a+100;
			break;
		case 7:
			a= a+10;
			break;
		case 8:
			a= a+1;
			break;
		default:
			break;
		}
		nBgtCd= Integer.toString(a);
		return nBgtCd;
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
			mapper.updateBgtCDTerm(temp);
		}
		List<BgtCDTerm> list = mapper.getBgtCDTerm(coCD);

		return BgtCDTermConverter.convertToDtoList(list);
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

}
