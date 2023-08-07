package kr.co.acctmgmt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Co;
import kr.co.acctmgmt.domain.Pjt;
import kr.co.acctmgmt.service.PjtService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PjtController {

	private final PjtService pjtService;
	
	@GetMapping("/pjtDate/{coCd}")
	public ResponseEntity<List> pjtDataList(@PathVariable int coCd){
		
		System.out.println("프로젝트 값 갖고오기");
		List<Pjt> pjt = pjtService.getPjtList(coCd);
		System.out.println(pjt.toString());
		return ResponseEntity.ok(pjt);
	}
//	@GetMapping("/ozt/co")
//	public List<Co> getCoList() {
//		List<Co> coList = coService.getCoList();
//	
////		System.out.println(coList.toString());
//		return coList;
//	}
	
//	@GetMapping("/ozt/scom")
//	public List<Co> getCompany(@RequestParam int coCd){
//		
//		List<Co> scompany = coService.getCompany(coCd);
//		System.out.println(scompany);
//		return scompany;
//	}
	@GetMapping("/pjtSelDate/{pjtCd}")
	public List<Pjt> getSelPjtList(@PathVariable String pjtCd){
		
		List<Pjt> pjt = pjtService.getSelPjtList(pjtCd);
		System.out.println("하나 잘 갖고오나?"+pjt);
		return pjt;
	}
}
