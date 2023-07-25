package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.converter.BgtCDConverter;
import kr.co.acctmgmt.converter.BgtCDTermConverter;
import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.dto.BgtCDTermDTO;
import kr.co.acctmgmt.mapper.BgtCDMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BgtCDServiceImpl implements BgtCDService {

	private final BgtCDMapper mapper;

	@Override
	public List<BgtCD> getSBGTCDData(String groupcd) {
		List<BgtCD> list= mapper.getSBGTCDData(groupcd); //defNm이 필요함 .
		
		for(int i =0 ; i<list.size();i++) {
			String temp = list.get(i).getDivFg()+"lv";
			list.get(i).setDefNm(getDefNmFromBGTCD_TERM(temp));
		}
		return list;
	}
	@Override
	public String getDefNmFromBGTCD_TERM(String divFg) {
		
		return mapper.getDefNmFromBGTCD_TERM(divFg);
	}
	@Override
	public List<BgtCD> getDetailInfo(String bgt_Cd) {
		System.out.println("1. getDetailInfo ");
		List<BgtCD> list = mapper.getDetailInfo(bgt_Cd);
		System.out.println("2. getDetailInfo");
		return list;
	}

	@Override
	public int updateDetailInfo(BgtCD updateData) {
		int changeRow = mapper.updateDetailInfo(updateData);
		return changeRow;
	}

	@Override
	public void deleteRow(String bgtCd) {
		mapper.deleteRow(bgtCd);

	}

	@Override
	public List<BgtCDTermDTO> getSbgtCDTerm(String CO_CD) {
		System.out.println("getSbgtCDTerm로 오긴하니 ?");
		List<BgtCDTerm> list = mapper.getSbgtCDTerm(CO_CD);
		return BgtCDTermConverter.convertToDtoList(list);
	}

	@Override
	public List<BgtCDTermDTO> updateBgtCDTerm(List<BgtCDTermDTO> dataList) {
		String coCD  = Integer.toString(dataList.get(1).getCoCd());
		for (BgtCDTermDTO data : dataList) {
	        System.out.println("for-each loop : " + data);
	        BgtCDTerm temp= BgtCDTermConverter.convertToModel(data);
	        mapper.updateBgtCDTerm(temp);
	    }
		List<BgtCDTerm> list = mapper.getSbgtCDTerm(coCD);
		
		return BgtCDTermConverter.convertToDtoList(list);
	}
	

}
