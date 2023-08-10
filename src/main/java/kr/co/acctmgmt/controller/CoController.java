package kr.co.acctmgmt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Co getCo(@RequestParam int coCd){
		
		Co sco = coService.getCo(coCd);
		System.out.println(sco);
		return sco;
	}
	
	@GetMapping("/ozt/scom")
	public List<Co> getCompany(@RequestParam int coCd){
		
		List<Co> scompany = coService.getCompany(coCd);
		System.out.println(scompany);
		return scompany;
	}
	
	@PostMapping("/ozt/ico")
	public List<Co> insertCo(@RequestBody Co co) {
		coService.insertCo(co);
		System.out.println(co);
		
		List<Co> coList = coService.getCoList();
		return coList;
	}
	
	@DeleteMapping("/ozt/dco")
	public List<Co> deleteCo(@RequestParam int coCd) {
//		System.out.println(co.getCoCd());
		coService.deleteCo(coCd);
		List<Co> coList = coService.getCoList();
		return coList;
	}
	
	@PutMapping("/ozt/uco")
	public List<Co> updateCo(@RequestBody Co co){
		System.out.println(co.getCoCd());
		System.out.println(co.toString());
		
		coService.updateCo(co);
		List<Co> coList = coService.getCoList();
		return coList;
	}
	
	@GetMapping("/ozt/co/search")
	public List<Co> getCoBycoCdAndcoNm(@RequestParam String keyword){
		
		List<Co> searchCo = coService.getCoBycoCdAndcoNm(keyword);
		System.out.println(searchCo);
		return searchCo;
	}
	
	@GetMapping("/ozt/sconm")
	public List<Co> getCoNm(@RequestParam String coNm){
		
		List<Co> coCd = coService.getCoNm(coNm);
		System.out.println(coCd);
		return coCd;
	}
}
