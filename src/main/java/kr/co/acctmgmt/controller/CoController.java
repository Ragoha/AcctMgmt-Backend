package kr.co.acctmgmt.controller;

import java.util.List;

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

import kr.co.acctmgmt.domain.Co;
import kr.co.acctmgmt.service.CoService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class CoController {

	private final CoService coService;
	
	@GetMapping("/co")
	public ResponseEntity<List<Co>> getCoList(Co co) {
		List<Co> coList = coService.getCoList(co);
	
//		System.out.println(coList.toString());
		return new ResponseEntity<List<Co>>(coList, HttpStatus.OK);
	}
	
	@GetMapping("/co/{coCd}")
	public ResponseEntity<List<Co>> getCompany(Co co){
		
		List<Co> scompany = coService.getCoList(co);
		System.out.println(scompany);
		return new ResponseEntity<List<Co>>(scompany, HttpStatus.OK);
	}
	
//	@GetMapping("/ozt/sco")
//	public ResponseEntity<Co> getCo(@RequestParam String coCd){
//		
//		Co sco = coService.getCo(coCd);
//		System.out.println(sco);
//		return new ResponseEntity<Co>(sco, HttpStatus.OK);
//	}
	

	
	@PostMapping("/co")
	public ResponseEntity<List<Co>> insertCo(@RequestBody Co co) {
		coService.insertCo(co);
		System.out.println(co);
		
		List<Co> coList = coService.getCoList(new Co());
		return new ResponseEntity<List<Co>>(coList, HttpStatus.OK);
	}
	
	@DeleteMapping("/co/{coCd}")
	public ResponseEntity<List<Co>> deleteCo(Co co) {
//		System.out.println(co.getCoCd());
		coService.deleteCo(co);
		List<Co> coList = coService.getCoList(new Co());
		return new ResponseEntity<List<Co>>(coList, HttpStatus.OK);
	}
	
	@PutMapping("/co/{coCd}")
	public ResponseEntity<List<Co>> updateCo(@PathVariable("coCd") String coCd, @RequestBody Co co){
		System.out.println(co.getCoCd());
		System.out.println(co.toString());
		
		co.setCoCd(coCd);
		
		coService.updateCo(co);
		List<Co> coList = coService.getCoList(new Co());
		return new ResponseEntity<List<Co>>(coList, HttpStatus.OK);
	}
	
	@GetMapping("/dialog/co/{keyword}")
	public ResponseEntity<List<Co>> getCoBycoCdAndcoNm1(Co co){
		
		List<Co> searchCo = coService.getCoBycoCdAndcoNm(co);
		System.out.println(searchCo);
		return new ResponseEntity<List<Co>>(searchCo, HttpStatus.OK);
	}
	
	@GetMapping("/dialog/co")
	public ResponseEntity<List<Co>> getCoBycoCdAndcoNm2(Co co){
		
		List<Co> searchCo = coService.getCoBycoCdAndcoNm(co);
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
