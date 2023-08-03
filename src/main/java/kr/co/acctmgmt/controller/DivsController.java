package kr.co.acctmgmt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public List<Divs> getDivsList() {
		List<Divs> divsList = divsService.getDivsList();
	
//		System.out.println(coList.toString());
		return divsList;
	}
	
	@PostMapping("/ozt/idiv")
	public List<Divs> insertDivs(@RequestBody Divs divs) {
		divsService.insertDivs(divs);
		System.out.println(divs);
		
		List<Divs> divsList = divsService.getDivsList();
		return divsList;
	}
	
	@GetMapping("/ozt/sdiv")
	public List<Divs> getDivision(@RequestParam int divCd){
		
		List<Divs> division = divsService.getDivision(divCd);
		System.out.println(division);
		return division;
	}
	
	@PostMapping("/ozt/ddiv")
	public List<Divs> deleteDivs(@RequestBody Divs divs) {
		System.out.println(divs.getDivCd());
		divsService.deleteDivs(divs.getDivCd());
		
		List<Divs> divsList = divsService.getDivsList();
		return divsList;
	}
	
	@PostMapping("/ozt/udiv")
	public List<Divs> updateDivs(@RequestBody Divs divs){
		System.out.println(divs.getCoCd());
		System.out.println(divs.toString());
		
		divsService.updateDivs(divs);
		List<Divs> divsList = divsService.getDivsList();
		return divsList;
	}

}