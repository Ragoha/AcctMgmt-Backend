package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.dto.BgtCDTermDTO;

public interface BgtCDService {
   public List<BgtCD> getSBGTCDData(String groupcd);
   
   public String getDefNmFromBGTCD_TERM(String divFg);

   public List<BgtCD> getDetailInfo(String bgt_Cd);
   
	public int updateDetailInfo(BgtCD updateData);
	
	public void deleteRow(String bgtCd);
	
	public List<BgtCDTermDTO> getSbgtCDTerm(String CO_CD);

	public List<BgtCDTermDTO> updateBgtCDTerm(List<BgtCDTermDTO> dataList);
	
	
}
