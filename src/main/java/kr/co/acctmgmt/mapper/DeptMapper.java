package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Dept;

public interface DeptMapper {
	
	public List<Dept> getDeptList();
	
	public List<Dept> getDept(int coCd);

}
