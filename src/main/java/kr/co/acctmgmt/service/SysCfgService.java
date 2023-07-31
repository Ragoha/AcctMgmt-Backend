package kr.co.acctmgmt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.SysCfg;

public interface SysCfgService {

	List<SysCfg> getConfigList(int coCd);
	public void updateConfig(SysCfg Config);
    SysCfg getConfig(@Param("coCd") int coCd, @Param("sysCd") String sysCd);

}
