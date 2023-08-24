package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Dept;
import kr.co.acctmgmt.domain.Divs;

public interface DivsMapper {

	public List<Divs> findDivByCoCdAndKeyword(Divs divs);
	
	public void insertDivs(Divs divs);
	
	public List<Divs> getDivsList();
	
	public List<Divs> getDivision(Divs divs);
	
	public List<Divs> getDiv(Divs divs);
	
	public void deleteDivs(String divCd);
	
	public void updateDivs(Divs divs);
	
	public List<Divs> getDivBydivCdAnddivNm(Divs divs);
	
	public Integer getCoCd(String divCd);

	public List<Divs> findDivByCoCd(Divs divs);
	
}
