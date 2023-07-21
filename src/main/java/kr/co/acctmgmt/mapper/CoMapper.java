package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Co;

public interface CoMapper {

	public List<Co> getCoList();
	
	public void insertCo(Co co);
	
	public List<Co> getCo(int coCd);
}
