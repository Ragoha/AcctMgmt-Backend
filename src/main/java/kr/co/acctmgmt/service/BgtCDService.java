package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.BgtCD;

public interface BgtCDService {
   public List<BgtCD> getSBGTCDData(String groupcd);

   public List<BgtCD> getDetailInfo(String bgt_Cd);
   
	public int updateDetailInfo(BgtCD updateData);
	
	public void deleteRow(String bgtCd);
}
