package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Dept;

public interface DeptService {

	public List<Dept> getDeptList();

	public List<Dept> getDept(String coCd);

	public List<Dept> getDepartment(String deptCd);

	public void insertDept(Dept dept);

	public void deleteDept(String deptCd);

	public void updateDept(Dept dept);

	public List<Dept> getDivDept(String coCd);

	public List<Dept> getDivCo(String coCd);

	public List<Dept> getDivsDept(String divCd);

	public List<Dept> findDeptByCoCd(String coCd);
	
	public List<Dept> getDeptBydeptCdAnddeptNm(Dept dept);

}
