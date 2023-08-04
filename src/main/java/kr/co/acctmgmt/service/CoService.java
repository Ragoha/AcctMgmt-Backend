package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Co;

public interface CoService {

	public List<Co> getCoList();
	
	public void insertCo(Co co);
	
	public Co getCo(int coCd);
	
	public List<Co> getCompany(int coCd);
	
	public void deleteCo(int coCd);
	
	public void updateCo(Co co);
	
	public List<Co> getCoNm(String coNm);
	
	public List<Co> getCoBycoCdAndcoNm(Co co);
}
