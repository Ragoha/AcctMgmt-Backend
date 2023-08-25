package kr.co.acctmgmt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Pjt;
import kr.co.acctmgmt.dto.PjtDTO;

public interface PjtService {

	public List<Pjt> getPjtList();

	public void insertPjt(Pjt pjt, String coCd);

	public Pjt getPjt(String coCd);

	public Pjt getSelPjt(@Param("coCd") String coCd, @Param("pjtCd") String pjtCd);
	
	public List<Pjt> getPjtList(String coCd);

	public void deletePjt(@Param("pjt") Pjt pjt);

	public void updatePjt(Pjt pjt, String coCd);

	public List<Pjt> getSelPjtList(Pjt pjt);
	
	public List<Pjt> getSelPgrList(@Param("pgrCd") String pgrCd, @Param("coCd") String coCd);
	
	public List<Pjt> getPjtBy(Pjt pjt);
		
	public List<PjtDTO> findPjtByCoCdAndKeyword(PjtDTO pjtDTO);

	public List<Pjt> selPjtBy(@Param("pjt") Pjt pjt);
	
	public List<Pjt> selPgrBy(@Param("pjt") Pjt pjt);
	
	public List<Pjt> conditionPjtSelect(Pjt pjt, String keyword, String keyword2);

	public List<Pjt> getGroupPjt(@Param("pjt") Pjt pjt);

}
