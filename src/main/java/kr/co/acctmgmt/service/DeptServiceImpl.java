package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.Dept;
import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.mapper.DeptMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService{
	
	private final DeptMapper deptMapper;
	
	@Override
	public List<Dept> getDept(int coCd) {
		List<Dept> department = deptMapper.getDept(coCd);
		return department;
	}

	@Override
	public List<Dept> getDeptList() {
		List<Dept> deptList = deptMapper.getDeptList();
		return deptList;
	}

	@Override
	public List<Dept> getDepartment(int deptCd) {
		List<Dept> department = deptMapper.getDepartment(deptCd);
		return department;
	}

	@Override
	public void insertDept(Dept dept) {
		deptMapper.insertDept(dept);
		
	}

	@Override
	public void deleteDept(int deptCd) {
		deptMapper.deleteDept(deptCd);
		
	}

	@Override
	public void updateDept(Dept dept) {
		deptMapper.updateDept(dept);
		
	}

}
