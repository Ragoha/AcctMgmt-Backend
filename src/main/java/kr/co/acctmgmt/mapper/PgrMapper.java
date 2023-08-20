package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Pgr;

public interface PgrMapper {

	List<Pgr> findPgrByCoCd(String pgr);
	
	void deletePgr(Pgr gisu);

	void updatePgr(Pgr gisu);

	void insertPgr(Pgr gisu);

}
