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
import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.service.DivsService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class DivsController {
	
	private final DivsService divsService;
	
	@GetMapping("/ozt/div")
	public List<Divs> getDivsList() {
		List<Divs> divsList = divsService.getDivsList();
	
//		System.out.println(coList.toString());
		return divsList;
	}
	
	@PostMapping("/ozt/idiv")
	public void insertDivs(@RequestBody Divs divs) {
		divsService.insertDivs(divs);
		System.out.println(divs);
		
//		List<Divs> divsList = divsService.getDivsList();
//		return divsList;
	}
	
	@GetMapping("/ozt/sdiv")
	public List<Divs> getDivision(@RequestParam int coCd){
		
		List<Divs> division = divsService.getDivision(coCd);
		System.out.println(division);
		return division;
	}
	
	@GetMapping("/ozt/sdivi")
	public List<Divs> getDiv(@RequestParam int divCd){
		
		List<Divs> division = divsService.getDiv(divCd);
		System.out.println(division);
		return division;
	}
	
//	@GetMapping("/ozt/scodi")
//	public Divs getCoCd(@RequestParam int divCd){
//		
//		Divs coCd = divsService.getCoCd(divCd);
//		System.out.println(coCd);
//		return coCd;
//	}
	
	@DeleteMapping("/ozt/ddiv")
	public void deleteDivs(@RequestParam int divCd) {  
//		System.out.println(divs.getDivCd());
		divsService.deleteDivs(divCd);
		
//		Integer coCd = divsService.getCoCd(divCd);
//		System.out.println(coCd);
//		List<Divs> divsList = divsService.getDivision(coCd);
//		return divsList;
	}
	
	@PutMapping("/ozt/udiv")
	public void updateDivs(@RequestBody Divs divs){
//		System.out.println(divs.getCoCd());
//		System.out.println(divs.toString());
		
		divsService.updateDivs(divs);
		
//		List<Divs> divsList = divsService.getDivision(coCd);
//		return divsList;
	}
	
	@GetMapping("/ozt/div/search")
	public List<Divs> getDivBydivCdAnddivNm(Divs divs){
		
		List<Divs> searchDiv = divsService.getDivBydivCdAnddivNm(divs);
		System.out.println(searchDiv);
		return searchDiv;
	}

}
