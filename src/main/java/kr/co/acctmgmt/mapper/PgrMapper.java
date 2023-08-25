package kr.co.acctmgmt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Pgr;

public interface PgrMapper {

	List<Pgr> findPgrByCoCd(Pgr pgr);
	
	void deletePgr(Pgr pgr);

	void updatePgr(Pgr pgr);

	void insertPgr(Pgr pgr);

	String findPgrByNm(@Param("coCd") String coCd, @Param("pgrCd") String pgrCd);
	
	public List<Pgr> getPgrBy(Pgr pgr);
	}
