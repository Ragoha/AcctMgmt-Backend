package kr.co.acctmgmt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Dept;
import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.service.DeptService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class DeptController {
	
	private final DeptService deptService;
	
	@GetMapping("/ozt/dept")
	public List<Dept> getDeptList() {
		List<Dept> deptList = deptService.getDeptList();
	
//		System.out.println(coList.toString());
		return deptList;
	}
	
	@GetMapping("/ozt/sdept")
	public List<Dept> getDept(@RequestParam int coCd){
		
		List<Dept> department = deptService.getDept(coCd);
		System.out.println(department);
		return department;
	}

}
