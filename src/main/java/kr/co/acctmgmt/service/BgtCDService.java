package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.domain.BgtGr;
import kr.co.acctmgmt.dto.BgtCDDTO;
import kr.co.acctmgmt.dto.BgtCDTermDTO;

public interface BgtCDService {
	public List<BgtCD> getBGTCDData(String groupcd);


//	public String getDefNmFromBGTCD_TERM(int divFg);

	public List<BgtCD> getDetailInfo(String bgt_Cd);

	public void updateDetailInfo(BgtCD updateData);

	public int deleteRow(String bgtCd);

	public List<BgtCDTermDTO> getBgtCDTerm(String CO_CD);

	public List<BgtCDTermDTO> updateBgtCDTerm(List<BgtCDTermDTO> dataList);
	
	public List<BgtCDDTO> findBgcCDByGroupCdAndToDtAndKeyword(BgtCDDTO bgtCDDTO);
	
	public List<BgtCDDTO> findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(BgtCDDTO bgtCDDTO);

	public String getPath(String bgtCd);//Get this dataPath for using insert into DataGrid in Front


	public List<BgtGr> getBgtGrData(String coCd);


	public BgtCD addRowData(String bgtCd, String coCd);


	public void insertAddRow(BgtCD bgtcd);

}
