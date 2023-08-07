package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Divs;

public interface DivsMapper {

	public List<Divs> findDivByCoCdAndKeyword(Divs divs);
	
	public void insertDivs(Divs divs);
	
	public List<Divs> getDivsList();
	
	public List<Divs> getDivision(int coCd);
	
	public List<Divs> getDiv(int divCd);
	
	public void deleteDivs(int divCd);
	
	public void updateDivs(Divs divs);
	
	public List<Divs> getDivBydivCdAnddivNm(Divs divs);
	
}
