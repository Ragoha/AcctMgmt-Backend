package kr.co.acctmgmt.controller;

import java.util.List;

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

import kr.co.acctmgmt.domain.Co;
import kr.co.acctmgmt.service.CoService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class CoController {

	private final CoService coService;
	
	@GetMapping("/ozt/co")
	public ResponseEntity<List<Co>> getCoList() {
		List<Co> coList = coService.getCoList();
	
//		System.out.println(coList.toString());
		return new ResponseEntity<List<Co>>(coList, HttpStatus.OK);
	}
	
	@GetMapping("/ozt/sco")
	public ResponseEntity<Co> getCo(@RequestParam String coCd){
		
		Co sco = coService.getCo(coCd);
		System.out.println(sco);
		return new ResponseEntity<Co>(sco, HttpStatus.OK);
	}
	
	@GetMapping("/ozt/scom")
	public ResponseEntity<List<Co>> getCompany(@RequestParam String coCd){
		
		List<Co> scompany = coService.getCompany(coCd);
		System.out.println(scompany);
		return new ResponseEntity<List<Co>>(scompany, HttpStatus.OK);
	}
	
	@PostMapping("/ozt/ico")
	public ResponseEntity<List<Co>> insertCo(@RequestBody Co co) {
		coService.insertCo(co);
		System.out.println(co);
		
		List<Co> coList = coService.getCoList();
		return new ResponseEntity<List<Co>>(coList, HttpStatus.OK);
	}
	
	@DeleteMapping("/ozt/dco")
	public ResponseEntity<List<Co>> deleteCo(@RequestParam String coCd) {
//		System.out.println(co.getCoCd());
		coService.deleteCo(coCd);
		List<Co> coList = coService.getCoList();
		return new ResponseEntity<List<Co>>(coList, HttpStatus.OK);
	}
	
	@PutMapping("/ozt/uco")
	public ResponseEntity<List<Co>> updateCo(@RequestBody Co co){
		System.out.println(co.getCoCd());
		System.out.println(co.toString());
		
		coService.updateCo(co);
		List<Co> coList = coService.getCoList();
		return new ResponseEntity<List<Co>>(coList, HttpStatus.OK);
	}
	
	@GetMapping("/ozt/co/search")
	public ResponseEntity<List<Co>> getCoBycoCdAndcoNm(@RequestParam String keyword){
		
		List<Co> searchCo = coService.getCoBycoCdAndcoNm(keyword);
		System.out.println(searchCo);
		return new ResponseEntity<List<Co>>(searchCo, HttpStatus.OK);
	}
	
	@GetMapping("/ozt/sconm")
	public ResponseEntity<List<Co>> getCoNm(@RequestParam String coNm){
		
		List<Co> coCd = coService.getCoNm(coNm);
		System.out.println(coCd);
		return new ResponseEntity<List<Co>>(coCd, HttpStatus.OK);
	}
}
