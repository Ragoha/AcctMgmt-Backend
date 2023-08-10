package kr.co.acctmgmt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Pjt;

public interface PjtService {

	public List<Pjt> getPjtList();

	public void insertPjt(Pjt pjt, int coCd);

	public Pjt getPjt(int coCd);

	public Pjt getSelPjt(@Param("coCd") int coCd, @Param("pjtCd") String pjtCd);
	
	public List<Pjt> getPjtList(int coCd);

	public void deletePjt(@Param("pjt") Pjt pjt);

	public void updatePjt(Pjt pjt, int coCd);

	public List<Pjt> getSelPjtList(String pjtCd, int coCd);
	
	public List<Pjt> getPjtBy(@Param("keyword")String keyword, @Param("coCd") int coCd);
	
	public Pjt getPgrBy(String keyword, int coCd);

}
