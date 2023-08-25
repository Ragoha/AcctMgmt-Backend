package kr.co.acctmgmt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/dept")
	public ResponseEntity<Void> insertDept(@RequestBody Dept dept) {
		deptService.insertDept(dept);
		System.out.println(dept);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/dept/{coCd}/{deptCd}")
	public ResponseEntity<Void> deleteDept(Dept dept) {  
		deptService.deleteDept(dept);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/dept/{coCd}/{deptCd}")
	public ResponseEntity<Void> updateDept(@PathVariable("coCd") String coCd, @PathVariable("deptCd") String deptCd, @RequestBody Dept dept){
	
		dept.setCoCd(coCd);
		dept.setDeptCd(deptCd);
		deptService.updateDept(dept);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/dept/{coCd}")
	public ResponseEntity<List<Dept>> getDivDept1(Dept dept){
		
		System.out.println(dept.toString());
		List<Dept> rDeptList = deptService.findDeptByCoCd(dept);
		
		return new ResponseEntity<List<Dept>>(rDeptList, HttpStatus.OK);
	}
	
	@GetMapping("/dept/{coCd}/{deptCd}")
	public ResponseEntity<List<Dept>> getDivDept2(Dept dept){
		
		System.out.println(dept.toString());		
		List<Dept> rDeptList = deptService.findDeptByCoCd(dept);
		
		return new ResponseEntity<List<Dept>>(rDeptList, HttpStatus.OK);
	}
	
	@GetMapping("/dialog/dept/{coCd}/{keyword}")
	public ResponseEntity<List<Dept>> getDeptBydeptCdAnddeptNm(Dept dept){
		
		List<Dept> searchDept = deptService.getDeptBydeptCdAnddeptNm(dept);
		return new ResponseEntity<List<Dept>>(searchDept, HttpStatus.OK);
	}
	
	@GetMapping("/dialog/dept/{coCd}")
	public ResponseEntity<List<Dept>> getDeptBydeptCdAnddeptNm2(Dept dept){
		
		List<Dept> searchDept = deptService.getDeptBydeptCdAnddeptNm(dept);
		return new ResponseEntity<List<Dept>>(searchDept, HttpStatus.OK);
	}

}
