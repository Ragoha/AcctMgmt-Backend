package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Pgr;

public interface PgrService {

	List<Pgr> findPgrByCoCd(String pgr);

	void deletePgr(Pgr pgr);
	
	void updatePgr(Pgr pgr);

	void insertPgr(Pgr pgr);
}
