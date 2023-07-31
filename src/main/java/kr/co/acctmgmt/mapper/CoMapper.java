package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Co;

public interface CoMapper {

	public List<Co> getCoList();
	
	public void insertCo(Co co);
	
	public Co getCo(int coCd);
	
	public int getNum(); //�Ⱦ� �� ���� ������!
	
	public void deleteCo(int coCd);
	
	public void updateCo(Co co);
	
	public List<Co> getCoBycoCdAndcoNm(Co co);
}
