package kr.co.acctmgmt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Pjt;
import kr.co.acctmgmt.service.PjtService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PjtController {

	private final PjtService pjtService;
	
//	@GetMapping("/pjtDate")
//	public ResponseEntity<List> configData(@RequestParam("pjtCd") int pjtCd){
//		
//		System.out.println("프로젝트 값 갖고오기");
//		List<Pjt> pjt = pjtService.getPjtList(pjtCd);
//		System.out.println(sys.toString());
//		return ResponseEntity.ok(sys);
//	}
//	
}
