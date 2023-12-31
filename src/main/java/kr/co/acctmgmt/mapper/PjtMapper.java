package kr.co.acctmgmt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Pjt;

public interface PjtMapper {
	public List<Pjt> getPjtList(); 

	public void insertPjt(@Param("pjt") Pjt pjt, @Param("coCd") String coCd);

	public Pjt getPjt(int coCd);

	public Pjt getSelPjt(@Param("coCd") String coCd, @Param("pjtCd") String pjtCd);

	public List<Pjt> getPjtList(String coCd); 

	public void deletePjt(@Param("pjt") Pjt pjt);

	public void updatePjt(@Param("pjt") Pjt pjt, @Param("coCd") String coCd);

	public List<Pjt> getSelPjtList(Pjt pjt);
	
	public List<Pjt> getSelPgrList(@Param("pgrCd") String pgrCd, @Param("coCd") String coCd);
	
	public List<Pjt> selPjtBy(@Param("pjt") Pjt pjt);
	
	public List<Pjt> selPgrBy(@Param("pjt") Pjt pjt);
	
	public List<Pjt> findPjtByCoCdAndKeyword(Pjt pjt);
		
    List<Pjt> conditionPjtSelect(@Param("pjt") Pjt pjt, @Param("keyword") String keyword, @Param("keyword2") String keyword2);
    
    //getGroupPjt
	public List<Pjt> getGroupPjt(@Param("pjt") Pjt pjt);

	public List<Pjt> getPjtBy(Pjt pjt);


}