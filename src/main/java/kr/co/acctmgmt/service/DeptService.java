package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Dept;

public interface DeptService {
	
	public List<Dept> getDeptList();
	
	public List<Dept> getDept(int coCd);

}
