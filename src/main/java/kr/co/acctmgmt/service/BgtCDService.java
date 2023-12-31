package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.domain.BgtGr;
import kr.co.acctmgmt.domain.Gisu;
import kr.co.acctmgmt.dto.BgtCDDTO;
import kr.co.acctmgmt.dto.BgtCDTermDTO;

public interface BgtCDService {
	public List<BgtCD> getBGTCDData(String coCd ,String gisu, String bgtGrCd);
	
	public String getDefNmFromBGTCD_TERM(String coCd, String divFg);

	public List<BgtCD> getDetailInfo(String bgt_Cd);

	public void updateDetailInfo(BgtCD updateData);

	public int deleteRow(String bgtCd,String coCd);

	public List<BgtCDTermDTO> getBgtCDTerm(String CO_CD);

	public List<BgtCDTermDTO> updateBgtCDTerm(List<BgtCDTermDTO> dataList);
	
	public List<BgtCDDTO> findBgcCDByGroupCdAndToDtAndKeyword(BgtCDDTO bgtCDDTO);
	
	public List<BgtCDDTO> findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(BgtCDDTO bgtCDDTO);

	public String getPath(String bgtCd);//Get this dataPath for using insert into DataGrid in Front


	public List<BgtGr> getBgtGrData(String coCd);


	public BgtCD addRowData(String bgtCd, String coCd,String gisu, String groupCd);


	public void insertAddRow(BgtCD bgtcd);


	public void insertBgtGr(List<BgtGr> dataList);


	public void deleteBgtGr(String coCd, String bgtGrCd);


	public List<BgtCD> getBgtCDdialog(String coCd,String keyword);


	public List<BgtCD> getBgtCdLikeSearch(String coCd, String keyword);


	public List<BgtCD> getSearchData(String coCd,String gisu ,String groupCd, String keyword);


	public List<Gisu> getinitGisuList(String coCd);


	public List<BgtGr> getinitBgtGrSearch(String coCd,String keyword);
	
	public List<BgtGr> getBgtGrSearch(String coCd, String keyword);

	public void updateBgtNm(BgtCD bgtcd);

	public BgtCD checkTopData(String coCd, String gisu, String tDataPath, String keyword);

	public List<BgtGr> getbgtGrSearchKeywordData(String coCd, String keyword);





}
