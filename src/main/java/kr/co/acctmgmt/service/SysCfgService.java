package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.SysCfg;

public interface SysCfgService {

	List<SysCfg> getConfigList(String coCd);
	public void updateConfig(SysCfg Config);
}
