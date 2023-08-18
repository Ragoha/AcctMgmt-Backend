package kr.co.acctmgmt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Co;

public interface CoMapper {

	public List<Co> getCoList();
	
	public void insertCo(Co co);
	
	public Co getCo(String coCd);
	
	public List<Co> getCompany(String coCd);
	
	public int getNum(); //안쓸 것 같음 지우자!
	
	public void deleteCo(String coCd);
	
	public void updateCo(Co co);
	
	public List<Co> getCoNm(String coNm);
	
	public List<Co> getCoBycoCdAndcoNm(String keyword);
}
