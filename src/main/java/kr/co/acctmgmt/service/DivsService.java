package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Divs;

public interface DivsService {

	public List<Divs> findDivCdAndDivNmByCoCd(int coCd);
	
	public List<Divs> findDivCdAndDivNmByCoCd(List<String> keyword);
}
