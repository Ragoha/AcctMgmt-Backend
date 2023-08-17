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
import kr.co.acctmgmt.domain.Divs;
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
	public ResponseEntity<List<Dept>> getDeptList() {
		List<Dept> deptList = deptService.getDeptList();
	
//		System.out.println(coList.toString());
		return new ResponseEntity<List<Dept>>(deptList, HttpStatus.OK);
	}
	
	@GetMapping("/ozt/sdept")
	public ResponseEntity<List<Dept>> getDept(@RequestParam String coCd){
		
//		System.out.println(coCd);
		List<Dept> department = deptService.getDept(coCd);
		System.out.println(department);
		return new ResponseEntity<List<Dept>>(department, HttpStatus.OK);
	}
	
	@GetMapping("/ozt/sdepart")
	public ResponseEntity<List<Dept>> getDepartment(@RequestParam String deptCd){
		
		List<Dept> department = deptService.getDepartment(deptCd);
		return new ResponseEntity<List<Dept>>(department, HttpStatus.OK);
	}
	
	@PostMapping("/ozt/idept")
	public ResponseEntity<Void> insertDept(@RequestBody Dept dept) {
		deptService.insertDept(dept);
		System.out.println(dept);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/ozt/ddept")
	public ResponseEntity<Void> deleteDept(@RequestParam String deptCd) {  
		deptService.deleteDept(deptCd);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/ozt/udept")
	public ResponseEntity<Void> updateDept(@RequestBody Dept dept){
		deptService.updateDept(dept);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/ozt/sdivdept")
	public ResponseEntity<List<Dept>> getDivDept(@RequestParam String coCd){
		
		List<Dept> department = deptService.getDivDept(coCd);
		System.out.println(department);
		return new ResponseEntity<List<Dept>>(department, HttpStatus.OK);
	}
	
	@GetMapping("/ozt/stcocd")
	public ResponseEntity<List<Dept>> getDivCo(@RequestParam String coCd){
		
		List<Dept> department = deptService.getDivCo(coCd);
		System.out.println(department);
		return new ResponseEntity<List<Dept>>(department, HttpStatus.OK);
	}
	
	@GetMapping("/ozt/stdivcd")
	public ResponseEntity<List<Dept>> getDivsDept(@RequestParam String divCd){
		
		List<Dept> department = deptService.getDivsDept(divCd);
		System.out.println(department);
		return new ResponseEntity<List<Dept>>(department, HttpStatus.OK);
	}
	
	@GetMapping("/ozt/sdivdept2")
	public ResponseEntity<List<Dept>> getDivDept2(@RequestParam String coCd){
		
		System.out.println("asdf00");
//		divsService.findDivByCoCd(coCd);
		List<Dept> rDeptList = deptService.findDeptByCoCd(coCd);
		
		System.out.println(rDeptList.toString());
		
		System.out.println("asdf00");
		return new ResponseEntity<List<Dept>>(rDeptList, HttpStatus.OK);
	}
	
	@GetMapping("/ozt/dept/search")
	public ResponseEntity<List<Dept>> getDeptBydeptCdAnddeptNm(Dept dept){
		
		List<Dept> searchDept = deptService.getDeptBydeptCdAnddeptNm(dept);
		System.out.println(searchDept);
		return new ResponseEntity<List<Dept>>(searchDept, HttpStatus.OK);
	}

}
