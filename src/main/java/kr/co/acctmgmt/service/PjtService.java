package kr.co.acctmgmt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Pjt;

public interface PjtService {

	public List<Pjt> getPjtList();

	public void insertCo(Pjt pjt);

	public Pjt getPjt(int coCd);

	public Pjt getSelPjt(@Param("coCd") int coCd, @Param("pjtCd") String pjtCd);
	
	public List<Pjt> getPjtList(int coCd);

	public void deletePjt(int coCd);

	public void updatePjt(Pjt pjt, int coCd);

	public List<Pjt> getSelPjtList(String pjtCd, int coCd);

}
