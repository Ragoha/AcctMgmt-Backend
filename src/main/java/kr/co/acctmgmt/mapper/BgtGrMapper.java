package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtGr;

public interface BgtGrMapper {
	
	public List<BgtGr> findBgtGrByCoCdAndKeyword(BgtGr bgtGr);

	public void deleteBgtGr(BgtGr bgtgr);

	public void updateBgtGr(BgtGr bgtgr);

	public void insertBgtGr(BgtGr bgtgr);

	public String getMaxBgtCd(String coCd);

	public void initBgtCd(BgtCD bgtCdInfo);
	
}
