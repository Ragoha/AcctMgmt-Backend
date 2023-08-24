package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Dept;

public interface DeptService {

	public List<Dept> getDepartment(Dept dept);

	public void insertDept(Dept dept);

	public void deleteDept(Dept dept);

	public void updateDept(Dept dept);

	public List<Dept> getDivDept(String coCd);

	public List<Dept> getDivsDept(String divCd);

	public List<Dept> findDeptByCoCd(Dept dept);
	
	public List<Dept> getDeptBydeptCdAnddeptNm(Dept dept);

}
