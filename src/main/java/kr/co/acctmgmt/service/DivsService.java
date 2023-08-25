package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Co;
import kr.co.acctmgmt.domain.Dept;
import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.dto.DivsDTO;

public interface DivsService {

	public List<DivsDTO> findDivByCoCdAndKeyword(DivsDTO divsDTO);
	
	public void insertDivs(Divs divs);
	
	public List<Divs> getDivsList();
	
	public List<Divs> getDivision(Divs divs);
	
	public List<Divs> getDiv(Divs divs);
	
	public void deleteDivs(Divs divs);
	
	public void updateDivs(Divs divs);
	
	public List<Divs> getDivBydivCdAnddivNm(Divs divs);
	
	public Integer getCoCd(String divCd);

	public List<Divs> findDivByCoCd(Divs divs);

}
