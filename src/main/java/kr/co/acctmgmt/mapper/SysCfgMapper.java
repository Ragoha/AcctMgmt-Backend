package kr.co.acctmgmt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.SysCfg;

public interface SysCfgMapper {

	public List<SysCfg> getConfigList(int coCd);
	
    SysCfg getConfig(@Param("coCd") int coCd, @Param("sysCd") String sysCd);
	
	public void updateConfig(SysCfg Config);
	
}
