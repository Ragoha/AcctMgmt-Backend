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

import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.service.DivsService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class DivsController {
	
	private final DivsService divsService;
	
	@GetMapping("/ozt/div")
	public ResponseEntity<List<Divs>> getDivsList() {
		List<Divs> divsList = divsService.getDivsList();
	
//		System.out.println(coList.toString());
		return new ResponseEntity<List<Divs>>(divsList, HttpStatus.OK);
	}
	
	@PostMapping("/ozt/idiv")
	public ResponseEntity<Void> insertDivs(@RequestBody Divs divs) {
		divsService.insertDivs(divs);
		System.out.println(divs);
		
//		List<Divs> divsList = divsService.getDivsList();
//		return divsList;
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/ozt/sdiv")
	public ResponseEntity<List<Divs>> getDivision(@RequestParam String coCd){
		List<Divs> division = divsService.getDivision(coCd);
		System.out.println(division);
		return new ResponseEntity<List<Divs>>(division, HttpStatus.OK);
	}
	
	@GetMapping("/ozt/sdivi")
	public ResponseEntity<List<Divs>> getDiv(Divs divs){
		
		List<Divs> division = divsService.getDiv(divs);
		System.out.println(division);
		return new ResponseEntity<List<Divs>>(division, HttpStatus.OK);
	}
	
//	@GetMapping("/ozt/scodi")
//	public Divs getCoCd(@RequestParam int divCd){
//		
//		Divs coCd = divsService.getCoCd(divCd);
//		System.out.println(coCd);
//		return coCd;
//	}
	
	@DeleteMapping("/ozt/ddiv")
	public ResponseEntity<List<Divs>> deleteDivs(@RequestParam String divCd) {  
//		System.out.println(divs.getDivCd());
		divsService.deleteDivs(divCd);
		
//		Integer coCd = divsService.getCoCd(divCd);
//		System.out.println(coCd);
		List<Divs> divsList = divsService.getDivision("coCd");
		return new ResponseEntity<List<Divs>>(divsList, HttpStatus.OK);
	}
	
	@PutMapping("/ozt/udiv")
	public ResponseEntity<List<Divs>> updateDivs(@RequestBody Divs divs){
//		System.out.println(divs.getCoCd());
//		System.out.println(divs.toString());
		
		divsService.updateDivs(divs);
		
		List<Divs> divsList = divsService.getDivision("coCd");
		return new ResponseEntity<List<Divs>>(divsList, HttpStatus.OK);
	}
	
	@GetMapping("/ozt/div/search")
	public ResponseEntity<List<Divs>> getDivBydivCdAnddivNm(Divs divs){
		
		List<Divs> searchDiv = divsService.getDivBydivCdAnddivNm(divs);
		System.out.println(searchDiv);
		return new ResponseEntity<List<Divs>>(searchDiv, HttpStatus.OK);
	}

}
