package kr.co.acctmgmt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Gisu;
import kr.co.acctmgmt.service.GisuService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class GisuController {
	
	private final GisuService gisuService;
	
	@GetMapping("/ozt/sgisu")
	public List<Gisu> getGisu(@RequestParam int coCd){
		
		List<Gisu> sgisu= gisuService.getGisu(coCd);
		
		return sgisu;
	}

}
