package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Co;

public interface CoService {

	public List<Co> getCoList();
	
	public void insertCo(Co co);
	
	public List<Co> getCo(int coCd);
}
