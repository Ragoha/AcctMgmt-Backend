package kr.co.acctmgmt.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.junit.experimental.theories.ParametersSuppliedBy;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.domain.BgtGr;
import kr.co.acctmgmt.domain.Gisu;
import kr.co.acctmgmt.dto.BgtCDTermDTO;

public interface BgtCDMapper {
	
	public List<BgtCD> getBGTCDData(@Param("coCd") String coCd,@Param("gisu") String gisu, @Param("bgtGrCd") String bgtGrCd);
	
	public List<BgtCD> getDetailInfo(String bgtCd);
	
	public int getDetailInfo(BgtCD updateData);
	
	public void updateDetailInfo(BgtCD updateData);

	public void deleteRow(@Param("bgtCd") String bgtCd,@Param("coCd") String coCd);
	
	/*BgtCDDevFgCustom.js>>>*/
	public List<BgtCDTerm> getBgtCDTerm(String CO_CD);
	
	//getBgtGrData
	public List<BgtGr> getBgtGrData(String coCd);
	
	public BgtCD getMaxMultiNum(Map<String, String> params);
	
	public int updateBgtCDTerm(BgtCDTerm dataList);
	
	public List<BgtCD> getSearchData(@Param("coCd") String coCd,@Param("gisu") String gisu, @Param("groupCd") String groupCd, @Param("keyword") String keyword);
	
	public List<BgtCD> getSearchData2(@Param("coCd") String coCd,@Param("gisu") String gisu, @Param("groupCd") String groupCd);
	
	/*<<<BgtCDDevFgCustom.js */
	//ÅÂ¿µÇü²¨ 
	public List<BgtCD> findBgcCDByGroupCdAndToDtAndKeyword(BgtCD bgtCD);
	
	/*insert */
	public void insertAddRow(BgtCD bgtcd);

	/*DataPath& TreeViewDataGrid>>>>*/
	public String getDefNmFromBGTCD_TERM(@Param("coCd")String coCd,@Param("divFg") String divFg);
	
	public String getDataPath(BgtCD temp);
	
	public BgtCD getBgtCDDataForPath(@Param("coCd") String coCd, @Param("gisu") String gisu, @Param("groupCd") String groupCd ,@Param("bgtCd")String bgtCd);
	
	public String getBgtCd_TermForDataPath(String divFg);
	
	public String getPath(String bgtCd);

	/*---DELETE---*/
	public int findUseParentCdSubject(String bgtCd); //[230801]S.H method for find rows who have parentCd of bgtCd variable 

	public List<BgtCD> findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(BgtCD bgtCD);

	public BgtCD getAddRowData(Map<String, String> params);

	public void updateBgtGr(BgtGr data);

	public void insertBgtGr(BgtGr data);
	
	public void deleteBgtGr(@Param("coCd") String coCd, @Param("bgtGrCd") String bgtGrCd);

	public List<BgtCD> getBgtCDdialog(@Param("coCd") String coCd, @Param("keyword") String keyword);

	public List<BgtCD> getBgtCdLikeSearch(@Param("coCd")String coCd, @Param("keyword")String keyword);

	public List<Gisu> getinitGisuList(String coCd);
	
	public List<BgtGr> getBgtGrSearch(@Param("coCd") String coCd, @Param("keyword") String keyword);

	public List<BgtGr> getinitBgtGrSearch(@Param("coCd") String coCd,@Param("keyword") String keyword);

	public void updateBgtNm(BgtCD bgtcd);//@Param("coCd") String coCd, @Param("bgtCd")String bgtCd, @Param("bgtNm") String bgtNm

	public List<BgtCD> checkTopData(@Param("coCd") String coCd,@Param("gisu") String gisu,@Param("grFg") String grFg);

	public List<BgtGr> getbgtGrSearchKeywordData(@Param("coCd") String coCd, @Param("keyword") String keyword);

	public int  findUseParentCdSubjectInBgtICF(@Param("coCd") String coCd , @Param("bgtCd") String bgtCd);

	public Collection<? extends BgtCD> findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd1(BgtCD tempBgtCD);
	
}
