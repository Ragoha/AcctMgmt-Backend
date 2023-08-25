package kr.co.acctmgmt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Pgr;
import kr.co.acctmgmt.domain.Pjt;
import kr.co.acctmgmt.dto.GisuDTO;
import kr.co.acctmgmt.service.PgrService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class PgrController {
	private final PgrService pgrService;

	@GetMapping("/pgr/{coCd}")
	public ResponseEntity<List> findPgrByCoCd(Pgr pgr) {
		List<Pgr> rPgrList = pgrService.findPgrByCoCd(pgr);
		
		return new ResponseEntity<List>(rPgrList, HttpStatus.OK);

	}
	
	@PostMapping("/pgr")
	public ResponseEntity<Void> insertPgr(@RequestBody Pgr pgr){
		System.out.println("===========");
		System.out.println(pgr.toString());
		
		pgrService.insertPgr(pgr);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/pgr/{coCd}/{pgrCd}")
	public ResponseEntity<Void> deletePgr(Pgr pgr){
		System.out.println("삭제들어왔디" + pgr.toString());
		pgrService.deletePgr(pgr);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/dialog/pgr/{coCd}")
	public ResponseEntity<?> getPjtByKeyword1(Pgr pgr) {		
		System.out.println(pgr.toString());

		List<Pgr> searchPgr = pgrService.getPgrBy(pgr);
		System.out.println("dialog select : " + searchPgr.toString());
		return ResponseEntity.ok(searchPgr);
	}
	
	@GetMapping("/dialog/pgr/{coCd}/{keyword}")
	public ResponseEntity<?> getPjtByKeyword2(Pgr pgr) {

		List<Pgr> searchPgr = pgrService.getPgrBy(pgr);
		
		return ResponseEntity.ok(searchPgr);
	}
}
