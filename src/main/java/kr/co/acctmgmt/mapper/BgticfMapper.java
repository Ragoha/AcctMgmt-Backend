package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Bgticf;

public interface BgticfMapper {

	Bgticf getBgticf(Bgticf bgticf);

	List<Bgticf> getBgticfList();

	void insertBgticf(Bgticf bgticf);

	void updateBgticf(Bgticf bgticf);

	void deleteBgticf(Bgticf bgticf);
	
}
