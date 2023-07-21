package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.SysCfg;

public interface SysCfgMapper {

	public List<SysCfg> getConfigList(String coCd);
	
	public void updateConfig(SysCfg Config);
	
}
