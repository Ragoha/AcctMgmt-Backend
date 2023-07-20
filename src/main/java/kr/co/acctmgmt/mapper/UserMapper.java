package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.SBGTCDDomain;

public interface UserMapper {

	public String getTime();
	
	public List<SBGTCDDomain> getDataGridData();
	
}
