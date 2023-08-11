package kr.co.acctmgmt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Dept;
import kr.co.acctmgmt.service.DeptService;
import kr.co.acctmgmt.service.DivsService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class DeptController {
	
	private final DeptService deptService;
	private final DivsService divsService;
	
	@GetMapping("/ozt/dept")
	public List<Dept> getDeptList() {
		List<Dept> deptList = deptService.getDeptList();
	
//		System.out.println(coList.toString());
		return deptList;
	}
	
	@GetMapping("/ozt/sdept")
	public List<Dept> getDept(@RequestParam int coCd){
		
//		System.out.println(coCd);
		List<Dept> department = deptService.getDept(coCd);
		System.out.println(department);
		return department;
	}
	
	@GetMapping("/ozt/sdepart")
	public List<Dept> getDepartment(@RequestParam int deptCd){
		
		List<Dept> department = deptService.getDepartment(deptCd);
		return department;
	}
	
	@PostMapping("/ozt/idept")
	public void insertDept(@RequestBody Dept dept) {
		deptService.insertDept(dept);
		System.out.println(dept);

	}
	
	@DeleteMapping("/ozt/ddept")
	public void deleteDept(@RequestParam int deptCd) {  
		deptService.deleteDept(deptCd);
		
	}
	
	@PutMapping("/ozt/udept")
	public void updateDept(@RequestBody Dept dept){
		deptService.updateDept(dept);
	}
	
	@GetMapping("/ozt/sdivdept")
	public List<Dept> getDivDept(@RequestParam int coCd){
		
		List<Dept> department = deptService.getDivDept(coCd);
		System.out.println(department);
		return department;
	}
	
	@GetMapping("/ozt/stcocd")
	public List<Dept> getDivCo(@RequestParam int coCd){
		
		List<Dept> department = deptService.getDivCo(coCd);
		System.out.println(department);
		return department;
	}
	
	@GetMapping("/ozt/stdivcd")
	public List<Dept> getDivsDept(@RequestParam int divCd){
		
		List<Dept> department = deptService.getDivsDept(divCd);
		System.out.println(department);
		return department;
	}
	
	@GetMapping("/ozt/sdivdept2")
	public ResponseEntity<List<Dept>> getDivDept2(@RequestParam int coCd){
		
		System.out.println("asdf00");
//		divsService.findDivByCoCd(coCd);
		List<Dept> rDeptList = deptService.findDeptByCoCd(coCd);
		
		System.out.println(rDeptList.toString());
		
		System.out.println("asdf00");
		return new ResponseEntity<List<Dept>>(rDeptList, HttpStatus.OK);
	}

}
