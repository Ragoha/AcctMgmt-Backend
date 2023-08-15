package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.dto.DivsDTO;

public interface DivsService {

	public List<DivsDTO> findDivByCoCdAndKeyword(DivsDTO divsDTO);
	
	public void insertDivs(Divs divs);
	
	public List<Divs> getDivsList();
	
	public List<Divs> getDivision(int coCd);
	
	public List<Divs> getDiv(int divCd);
	
	public void deleteDivs(int divCd);
	
	public void updateDivs(Divs divs);
	
	public List<Divs> getDivBydivCdAnddivNm(Divs divs);
	
	public Integer getCoCd(int divCd);

	public List<Divs> findDivByCoCd(int coCd);

}
