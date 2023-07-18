package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Config;
import kr.co.acctmgmt.domain.Employee;

public interface ConfigMapper {

	public List<Config> getConfigList();
	
	public void updateConfig(Config Config);

}
