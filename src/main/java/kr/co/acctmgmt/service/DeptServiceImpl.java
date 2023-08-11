package kr.co.acctmgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.Dept;
import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.mapper.DeptMapper;
import kr.co.acctmgmt.mapper.DivsMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService{
	
	private final DeptMapper deptMapper;
	private final DivsMapper divsMapper;
	
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

	@Override
	public List<Dept> getDivDept(int coCd) {
		List<Dept> department = deptMapper.getDivDept(coCd);
		return department;
	}

	@Override
	public List<Dept> getDivCo(int coCd) {
		List<Dept> department = deptMapper.getDivCo(coCd);
		return department;
	}

	@Override
	public List<Dept> getDivsDept(int divCd) {
		List<Dept> department = deptMapper.getDivsDept(divCd);
		return department;
	}

	@Override
	public List<Dept> findDeptByCoCd(int coCd) {
		
		List<Divs> rDivsList = divsMapper.findDivByCoCd(coCd);
		
		List<Dept> fDeptList = new ArrayList<Dept>(); 
		
		rDivsList.forEach(rDivs -> {
			
			System.out.println(rDivs.getDivCd());
			
			Dept dept = Dept.builder()
					.coCd(coCd)
					.divCd(rDivs.getDivCd())
					.build();
			
			List<Dept> rDeptList = deptMapper.findDeptByCoCd(dept);
			System.out.println("rDeptList.forEach(rDept):");
			rDeptList.forEach(rDept -> {
				System.out.println("rDept"+rDept.toString());
				fDeptList.add(rDept);
			});
			
		});

		System.out.println("==============");
		System.out.println(fDeptList.toString());
		System.out.println("==============");
		return fDeptList;
	}

}
