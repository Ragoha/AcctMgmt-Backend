package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Divs;

public interface DivsMapper {

	public List<Divs> findDivByCoCdAndKeyword(Divs divs);
	
}
