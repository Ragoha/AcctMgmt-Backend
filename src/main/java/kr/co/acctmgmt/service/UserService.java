package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.SBGTCDDomain;

public interface UserService {
	
	public String getTime();

	
	public List<SBGTCDDomain> getDataGridData();
}
