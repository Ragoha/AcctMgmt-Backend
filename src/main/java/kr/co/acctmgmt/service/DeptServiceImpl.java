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
	public List<Dept> getDepartment(Dept dept) {
		List<Dept> department = deptMapper.getDepartment(dept);
		return department;
	}

	@Override
	public void insertDept(Dept dept) {
		deptMapper.insertDept(dept);
		
	}

	@Override
	public void deleteDept(Dept dept) {
		deptMapper.deleteDept(dept);
		
	}

	@Override
	public void updateDept(Dept dept) {
		deptMapper.updateDept(dept);
		
	}

	@Override
	public List<Dept> getDivDept(String coCd) {
		List<Dept> department = deptMapper.getDivDept(coCd);
		return department;
	}

	@Override
	public List<Dept> getDivsDept(String divCd) {
		List<Dept> department = deptMapper.getDivsDept(divCd);
		return department;
	}

	@Override
	public List<Dept> findDeptByCoCd(Dept dept) {
		
		List<Divs> rDivsList = divsMapper.findDivByCoCd(
				Divs.builder()
				.coCd(dept.getCoCd())
				.build()
				);
		
		
		
		List<Dept> fDeptList = new ArrayList<Dept>(); 
		
		System.out.println(fDeptList.size());
		
		if(dept.getDeptCd() == null) {
		rDivsList.forEach(rDivs -> {
			
			System.out.println(rDivs.getDivCd());
			
			Dept ndept = Dept.builder()
					.coCd(rDivs.getCoCd())
					.divCd(rDivs.getDivCd())
//					.deptCd(dept.getDeptCd())
					.build();
			
			System.out.println(ndept.toString());
			
			List<Dept> rDeptList = deptMapper.findDeptByCoCd(ndept);
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
		}else {
			List<Dept> rDeptList = deptMapper.findDeptByCoCd(dept);
			System.out.println("단일 조회");
			System.out.println(rDeptList.toString());
			
			return rDeptList;
		}
	}

	@Override
	public List<Dept> getDeptBydeptCdAnddeptNm(Dept dept) {
		List<Dept> searchDept = deptMapper.getDeptBydeptCdAnddeptNm(dept);
		return searchDept;
	}

}
