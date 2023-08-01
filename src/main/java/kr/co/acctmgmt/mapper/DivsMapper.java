package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Divs;

public interface DivsMapper {

	public List<Divs> findDivsByCoCdAndKeyword(Divs divs);
	
	public void insertDivs(Divs divs);
	
	public List<Divs> getDivsList();
	
	public List<Divs> getDivision(int divCd);
	
	public void deleteDivs(int divCd);
	
	public void updateDivs(Divs divs);
	
}
