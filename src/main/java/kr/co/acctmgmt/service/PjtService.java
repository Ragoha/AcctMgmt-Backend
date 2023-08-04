package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Pjt;

public interface PjtService {

	public List<Pjt> getPjtList();

	public void insertCo(Pjt pjt);

	public Pjt getPjt(int coCd);

	public List<Pjt> getPjtList(int coCd);

	public void deletePjt(int coCd);

	public void updatePjt(Pjt pjt);

}
