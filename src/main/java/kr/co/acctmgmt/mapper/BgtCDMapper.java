package kr.co.acctmgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.domain.BgtGr;
import kr.co.acctmgmt.dto.BgtCDTermDTO;

public interface BgtCDMapper {
	
	public List<BgtCD> getBGTCDData(@Param("coCd") String coCd, @Param("bgtGrCd") String bgtGrCd);
	
	public List<BgtCD> getDetailInfo(String bgtCd);
	
	public int getDetailInfo(BgtCD updateData);
	
	public void updateDetailInfo(BgtCD updateData);

	public void deleteRow(String bgtCd);
	
	/*BgtCDDevFgCustom.js>>>*/
	public List<BgtCDTerm> getBgtCDTerm(String CO_CD);
	
	//getBgtGrData
	public List<BgtGr> getBgtGrData(String coCd);
	
	public BgtCD getMaxMultiNum(Map<String, String> params);
	
	public int updateBgtCDTerm(BgtCDTerm dataList);
	/*<<<BgtCDDevFgCustom.js */
	//ÅÂ¿µÇü²¨ 
	public List<BgtCD> findBgcCDByGroupCdAndToDtAndKeyword(BgtCD bgtCD);
	
	/*insert */
	public void insertAddRow(BgtCD bgtcd);

	/*DataPath& TreeViewDataGrid>>>>*/
	public String getDefNmFromBGTCD_TERM(int divFg);
	
	public String getDataPath(BgtCD temp);
	
	public BgtCD getBgtCDDataForPath(String bgtCd);
	
	public String getBgtCd_TermForDataPath(String ivFg);
	
	public String getPath(String bgtCd);

	/*---DELETE---*/
	public int findUseParentCdSubject(String bgtCd); //[230801]S.H method for find rows who have parentCd of bgtCd variable 

	public List<BgtCD> findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(BgtCD bgtCD);

	public BgtCD getAddRowData(Map<String, String> params);

	public void updateBgtGr(BgtGr data);
}
