package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.BgtGr;

public interface BgtGrMapper {
	
	public List<BgtGr> findBgtGrByCoCdAndKeyword(BgtGr bgtGr);
	
}
