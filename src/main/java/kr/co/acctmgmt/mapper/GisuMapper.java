package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Gisu;

public interface GisuMapper {

	List<Gisu> findGisuByCoCd(Gisu gisu);
	
	List<Gisu> getGisu(int coCd);

	void deleteGisu(Gisu gisu);

	void updateGisu(Gisu gisu);

	void insertGisu(Gisu gisu);

}
