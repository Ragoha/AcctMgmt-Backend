package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Dept;

public interface DeptService {

	public List<Dept> getDeptList();

	public List<Dept> getDept(int coCd);

	public List<Dept> getDepartment(int deptCd);

	public void insertDept(Dept dept);

	public void deleteDept(int deptCd);

	public void updateDept(Dept dept);

	public List<Dept> getDivDept(int coCd);

	public List<Dept> getDivCo(int coCd);

	public List<Dept> getDivsDept(int divCd);

	public List<Dept> findDeptByCoCd(int coCd);

}
