package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.mapper.BgtCDMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BgtCDServiceImpl implements BgtCDService {
	
	private final BgtCDMapper mapper;
	@Override
	public List<BgtCD> getSBGTCDData(String groupcd) {
		return mapper.getSBGTCDData(groupcd);
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

}
