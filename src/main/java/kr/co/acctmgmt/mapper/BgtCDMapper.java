package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.dto.BgtCDTermDTO;

public interface BgtCDMapper {
	
	public List<BgtCD> getBGTCDData(String groupcd);
	
	public List<BgtCD> getDetailInfo(String bgtCd);
	
	public int getDetailInfo(BgtCD updateData);
	
	public void updateDetailInfo(BgtCD updateData);

	public void deleteRow(String bgtCd);
	
	public List<BgtCDTerm> getBgtCDTerm(String CO_CD);
	
	public int updateBgtCDTerm(BgtCDTerm dataList);
	
	public String getDefNmFromBGTCD_TERM(String divFg);
	
	public List<BgtCD> findBgcCDByGroupCdAndToDtAndKeyword(BgtCD bgtCD);
}
