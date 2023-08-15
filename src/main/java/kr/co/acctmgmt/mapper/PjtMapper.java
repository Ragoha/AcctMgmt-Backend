package kr.co.acctmgmt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Pjt;

public interface PjtMapper {
	public List<Pjt> getPjtList(); 

	public void insertPjt(@Param("pjt") Pjt pjt, @Param("coCd") int coCd);

	public Pjt getPjt(int coCd);

	public Pjt getSelPjt(@Param("coCd") int coCd, @Param("pjtCd") String pjtCd);

	public List<Pjt> getPjtList(int coCd); 

	public void deletePjt(@Param("pjt") Pjt pjt);

	public void updatePjt(@Param("pjt") Pjt pjt, @Param("coCd") int coCd);

	public List<Pjt> getSelPjtList(@Param("pjtCd") String pjtCd, @Param("coCd") int coCd);
	
	public List<Pjt> getSelPgrList(@Param("pgrCd") String pgrCd, @Param("coCd") int coCd);
	
	public List<Pjt> getPjtBy(@Param("keyword")String keyword, @Param("coCd")int coCd);

	public List<Pjt> getPgrBy(@Param("keyword")String keyword, @Param("coCd")int coCd);
	
	public List<Pjt> selPjtBy(@Param("pjt") Pjt pjt);
	
	public List<Pjt> selPgrBy(@Param("pjt") Pjt pjt);
	
	public List<Pjt> findPjtByCoCdAndKeyword(Pjt pjt);
		
    List<Pjt> conditionPjtSelect(@Param("pjt") Pjt pjt, @Param("keyword") String keyword, @Param("keyword2") String keyword2);

}