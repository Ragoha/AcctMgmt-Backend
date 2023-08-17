package kr.co.acctmgmt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Co;

public interface CoService {

	public List<Co> getCoList();
	
	public void insertCo(Co co);
	
	public Co getCo(String coCd);
	
	public List<Co> getCompany(String coCd);
	
	public void deleteCo(String coCd);
	
	public void updateCo(Co co);
	
	public List<Co> getCoNm(String coNm);
	
	public List<Co> getCoBycoCdAndcoNm(String keyword);
}
