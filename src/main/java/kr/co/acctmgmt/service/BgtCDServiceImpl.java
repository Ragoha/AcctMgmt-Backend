package kr.co.acctmgmt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.converter.BgtCDConverter;
import kr.co.acctmgmt.converter.BgtCDTermConverter;
import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.dto.BgtCDDTO;
import kr.co.acctmgmt.dto.BgtCDTermDTO;
import kr.co.acctmgmt.mapper.BgtCDMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BgtCDServiceImpl implements BgtCDService {

	private final BgtCDMapper mapper;

	@Override
	public List<BgtCD> getBGTCDData(String groupcd) {
		List<BgtCD> list = mapper.getBGTCDData(groupcd); // defN
		System.out.println("Service  getBGTCDData.");
		System.out.println("groupCd ?" + groupcd);
		System.out.println(list.get(0).toString());
		int cocd=list.get(0).getCoCd(); //Integer.parseInt(groupcd);
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
			//수입수출여부
			//B002의 path는 수출이다 .
			System.out.println("수입일까 수출일까 : ? "+ list.get(i).getGrFg());
			if (list.get(i).getGrFg().equals("0")) {
				TreeViewPath = TreeViewPath + "수입,";
			} else if (list.get(i).getGrFg().equals("1")) {
				TreeViewPath = TreeViewPath + "수출,";
			}
			System.out.println("수입수출 적용됐는지 확인 : "+ TreeViewPath);
			if (tempDataPath != null) {
				// 2.패스경로를 나눈다.->BgtCd값을 갖고있음 "B001,B002 ...."
				String[] tempList = tempDataPath.split(",");//--> 만약 B002다 
				//여기서 할건 부모의 정보로 장 관 항 세 목 정하기 
				for(int p=0;p<tempList.length;p++) { //B002의 .. B003의 ...
					System.out.println("tempList?"+tempList[p]);
					BgtCD initRow = mapper.getBgtCDDataForPath(tempList[p]); //-->B002의 정보
					System.out.println("divFg는?:"+initRow.getDivFg());
					String pathPiece = initRow.getDivFg()+"lv"; //Bgt_Cd Term에서 가져온 값.
					BgtCD temp = new BgtCD();
					temp.setCoCd(cocd);
					temp.setDivFg(pathPiece);
					pathPiece = mapper.getDataPath(temp);
					System.out.println("pathPiece 1차는 ?:" + pathPiece);
					if(initRow.getMultiCk()==1) {
						for(int a = 0 ; a<initRow.getMultiNum();a++) {
							pathPiece = pathPiece+" ";
						}
					}
					TreeViewPath = TreeViewPath+pathPiece+",";
				}//int p for마무리
				
				BgtCD temp = new BgtCD();
				String a = list.get(i).getDivFg()+"lv";
				temp.setCoCd(cocd);
				temp.setDivFg(a);
				String pathPiece2=mapper.getDataPath(temp);// <<<defNm
				for(int z =0; z<list.get(i).getMultiNum();z++) {
					pathPiece2 = pathPiece2+" ";
				}
				System.out.println("pathPiece2는?"+pathPiece2);
				TreeViewPath = TreeViewPath +pathPiece2+",";
				
				TreeViewPath= TreeViewPath.substring(0, TreeViewPath.length() - 1);
			}//null Check if문
			
			//null이다 ? 
			else if(tempDataPath==null) {
				System.out.println("넌 널이야");
				String a = list.get(i).getDivFg()+"lv";
				int cycle1 = list.get(i).getMultiNum();
				BgtCD temp = new BgtCD();
				temp.setCoCd(cocd);
				temp.setDivFg(a);
				String defNm = mapper.getDataPath(temp);
				if(list.get(i).getMultiCk()==1) {
					for(int o = 0 ; o<cycle1;o++) {
						defNm=defNm+" ";
					}
				}
				TreeViewPath = TreeViewPath+defNm;
				System.out.println("널의 트리뷰:  "+ TreeViewPath);
			} 
			
			
			
			list.get(i).setDataPath(TreeViewPath);
		} // For i
		System.out.println("------");
		for(int q = 0 ; q<list.size();q++) {
			System.out.println(list.get(q).getBgtCd()+":"+list.get(q).getDataPath());
		}
		System.out.println("------");
		
		return list;
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
		 * 먼저 받아온 예산코드를 부모값으로 갖고있는 자식 코드가 있는지 확인한다. 여기서 부모 코드라 함은 
		 * 'parentCd'를 의미한다.
		 * 
		 */
		System.out.println("deleteRow입니다.");
		int data=0;
		if(mapper.findUseParentCdSubject(bgtCd)!=0) {
			data =mapper.findUseParentCdSubject(bgtCd) ;
			System.out.println("얘를 부모로 갖고있는 애들이 있다...지울 수 없어....");
		}else {
			System.out.println("부모없음 걍 지워도됨 ");
			mapper.deleteRow(bgtCd);
		}
		System.out.println("리턴값은?"+data);
		//변경못하는 이-유 
		return data;
	}

	@Override
	public List<BgtCDTermDTO> getBgtCDTerm(String CO_CD) {
		System.out.println("Service�쓽 getBgtCDTerm");
		List<BgtCDTerm> list = mapper.getBgtCDTerm(CO_CD);
		return BgtCDTermConverter.convertToDtoList(list);
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
		
		return BgtCDConverter.convertToDtoList(rBgtCDList);
	}
	// refer when you need to make insert dataPath
	/*
	 * /*
	 * 
	 * @Override public List<BgtCD> getBGTCDData(String groupcd) { List<BgtCD> list
	 * = mapper.getBGTCDData(groupcd); // defN
	 * System.out.println("Service  getBGTCDData."); System.out.println("groupCd ?"
	 * + groupcd); for (int i = 0; i < list.size(); i++) { // String space = " ";
	 * String dataPath = ""; // 1. String inOut = list.get(i).getGrFg(); // 2-1 if
	 * (inOut.equals("0")) { dataPath = dataPath + "수입"; // 2-2. } else if
	 * (inOut.equals("1")) { dataPath = dataPath + "수출"; } else {
	 * System.out.println("null."); } // 3.path // 3-1. path int cycle =
	 * Integer.parseInt(list.get(i).getDivFg()); //
	 * 
	 * for (int j = 1; j < cycle + 1; j++) { BgtCD tempBgtCD = new BgtCD(); String
	 * divFg = j + "lv"; tempBgtCD.setDivFg(divFg); // list.get(0).setDivFg(j);
	 * tempBgtCD.setCoCd(list.get(i).getCoCd()); String defNm =
	 * mapper.getDataPath(tempBgtCD); dataPath = dataPath + "," + defNm; }
	 * if(list.get(i).getMultiCk()==1) { for(int k=0
	 * ;k<list.get(i).getMultiNum();k++) { dataPath=dataPath + space; } }
	 * list.get(i).setDataPath(dataPath); } return list; }
	 * 
	 */

}
