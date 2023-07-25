package kr.co.acctmgmt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Co;
import kr.co.acctmgmt.service.CoService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class CoController {

	private final CoService coService;
	
	@GetMapping("/ozt/co")
	public List<Co> getCoList() {
		List<Co> coList = coService.getCoList();
	
//		System.out.println(coList.toString());
		return coList;
	}
	
	@GetMapping("/ozt/sco")
	public List<Co> getCo(@RequestParam int coCd){
		
		List<Co> sco = coService.getCo(coCd);
		System.out.println(sco);
		return sco;
	}
	
	@PostMapping("/ozt/ico")
	public void insertCo(@RequestBody Co co) {
		coService.insertCo(co);
		
		System.out.println(co);
	}
	
	@PostMapping("/ozt/dco")
	public void deleteCo(@RequestBody int coCd) {
		System.out.println(coCd);
		coService.deleteCo(coCd);
	}
}
