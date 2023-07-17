package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Bgticf;

public interface BgticfService {
	Bgticf getBgticf(Bgticf bgticf);

	List<Bgticf> getBgticfList();

	void insertBgticf(Bgticf bgticf);

	void updateBgticf(Bgticf bgticf);

	void deleteBgticf(Bgticf bgticf);
}
