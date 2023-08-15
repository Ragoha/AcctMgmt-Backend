package kr.co.acctmgmt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Pjt;
import kr.co.acctmgmt.dto.PjtDTO;

public interface PjtService {

	public List<Pjt> getPjtList();

	public void insertPjt(Pjt pjt, int coCd);

	public Pjt getPjt(int coCd);

	public Pjt getSelPjt(@Param("coCd") int coCd, @Param("pjtCd") String pjtCd);
	
	public List<Pjt> getPjtList(int coCd);

	public void deletePjt(@Param("pjt") Pjt pjt);

	public void updatePjt(Pjt pjt, int coCd);

	public List<Pjt> getSelPjtList(String pjtCd, int coCd);
	
	public List<Pjt> getSelPgrList(@Param("pgrCd") String pgrCd, @Param("coCd") int coCd);
	
	public List<Pjt> getPjtBy(@Param("keyword")String keyword, @Param("coCd") int coCd);
	
	public List<Pjt> getPgrtBy(@Param("keyword")String keyword, @Param("coCd")int coCd);
	
	public List<PjtDTO> findPjtByCoCdAndKeyword(PjtDTO pjtDTO);

	public List<Pjt> selPjtBy(@Param("pjt") Pjt pjt);
	
	public List<Pjt> selPgrBy(@Param("pjt") Pjt pjt);
	
	public List<Pjt> conditionPjtSelect(Pjt pjt, String keyword, String keyword2);

}
