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
		List<BgtCD> list = mapper.getBGTCDData(groupcd); // defNm이 필요함 .
		System.out.println("Service의 getBGTCDData 시작.");
		System.out.println("groupCd는 ?" + groupcd);
		for (int i = 0; i < list.size(); i++) {
			// 변수선언
			String space = " ";
			String dataPath = "";
			// 1.수입수출여부 확인
			String inOut = list.get(i).getGrFg();
			// 2-1.수입이면..
			if (inOut.equals("0")) {
				dataPath = dataPath + "수입";
			// 2-2.수출이면..
			} else if (inOut.equals("1")) {
				dataPath = dataPath + "수출";
			} else {
				System.out.println("null들어옴 문제있음.");
			}
			// 3.path 경로를 가져오는 로직
			// 3-1. path 숫자
			int cycle = Integer.parseInt(list.get(i).getDivFg()); // 반복되어야 할 숫자

			for (int j = 1; j < cycle + 1; j++) {
				BgtCD tempBgtCD = new BgtCD();
				String divFg = j + "lv";
				tempBgtCD.setDivFg(divFg); // list.get(0).setDivFg(j);
				tempBgtCD.setCoCd(list.get(i).getCoCd());
				String defNm = mapper.getDataPath(tempBgtCD);
				dataPath = dataPath + "," + defNm;
			}
			if(list.get(i).getMultiCk()==1) {
				for(int k=0 ;k<list.get(i).getMultiNum();k++) {
					dataPath=dataPath + space;
				}
			}
			list.get(i).setDataPath(dataPath);
		}
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
	public void deleteRow(String bgtCd) {
		mapper.deleteRow(bgtCd);

	}

	@Override
	public List<BgtCDTermDTO> getBgtCDTerm(String CO_CD) {
		System.out.println("Service의 getBgtCDTerm");
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

}
