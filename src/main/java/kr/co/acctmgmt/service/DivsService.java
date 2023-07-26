package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.dto.DivsDTO;

public interface DivsService {

	public List<DivsDTO> findDivsByCoCd(DivsDTO divsDTO);
	
	public List<DivsDTO> findDivsByCoCdAndKeyword(DivsDTO divsDTO);
}
