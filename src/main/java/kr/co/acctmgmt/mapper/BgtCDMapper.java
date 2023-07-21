package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.BgtCD;

public interface BgtCDMapper {
	
	public List<BgtCD> getSBGTCDData(String groupcd);
	
	public List<BgtCD> getDetailInfo(String bgtCd);
	
	public int getDetailInfo(BgtCD updateData);
	
	public int updateDetailInfo(BgtCD updateData);

	public void deleteRow(String bgtCd);
}