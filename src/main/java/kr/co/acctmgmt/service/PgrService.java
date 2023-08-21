package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Pgr;

public interface PgrService {

	List<Pgr> findPgrByCoCd(String coCd);

	void deletePgr(Pgr gisu);

	void updatePgr(Pgr gisu);

	void insertPgr(Pgr gisu);
}
