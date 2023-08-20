package kr.co.acctmgmt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Pgr;
import kr.co.acctmgmt.service.PgrService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class PgrController {
	private final PgrService pgrService;

	@GetMapping("/pgr")
	public ResponseEntity<List> findPgrByCoCd(String coCd) {
		System.out.println("do it" + coCd);
		List<Pgr> pgr = pgrService.findPgrByCoCd(coCd);
		
		System.out.println(pgr.toString());
		return new ResponseEntity<List>(pgr, HttpStatus.OK);

	}
}
