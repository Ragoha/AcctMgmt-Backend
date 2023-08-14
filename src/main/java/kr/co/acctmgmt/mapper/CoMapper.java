package kr.co.acctmgmt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Co;

public interface CoMapper {

	public List<Co> getCoList();
	
	public void insertCo(Co co);
	
	public Co getCo(int coCd);
	
	public List<Co> getCompany(int coCd);
	
	public int getNum(); //�Ⱦ� �� ���� ������!
	
	public void deleteCo(int coCd);
	
	public void updateCo(Co co);
	
	public List<Co> getCoNm(String coNm);
	
	public List<Co> getCoBycoCdAndcoNm(String keyword);
}
