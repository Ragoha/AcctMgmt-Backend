package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Pgr;

public interface PgrMapper {

	List<Pgr> findPgrByCoCd(String pgr);
	
	void deletePgr(Pgr pgr);

	void updatePgr(Pgr pgr);

	void insertPgr(Pgr pgr);

}
