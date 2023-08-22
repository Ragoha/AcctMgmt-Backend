package kr.co.acctmgmt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kr.co.acctmgmt.dto.BgtGrDTO;
import kr.co.acctmgmt.service.BgtGrService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BgtGrController {
	
	private final BgtGrService bgtGrService;
	
	@GetMapping("/bgtgr")
	public ResponseEntity<List<BgtGrDTO>> findBgtGrByCoCd(BgtGrDTO bgtGrDTO){
		
		List<BgtGrDTO> rBgtGr = bgtGrService.findBgtGrByCoCd(bgtGrDTO);
		
		return new ResponseEntity<List<BgtGrDTO>>(rBgtGr, HttpStatus.OK);
	}
	
	@PostMapping("/bgtgr")
	public ResponseEntity<Void> insertBgtGr(@RequestBody BgtGrDTO bgtGrDTO){
		System.out.println("¶×¶¥¶×µûµûµû");
		 System.out.println(bgtGrDTO.toString());
		 System.out.println(bgtGrDTO.getGisu());
		bgtGrService.insertBgtGr(bgtGrDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/bgtgr")
	public ResponseEntity<Void> deleteBgtGr(BgtGrDTO bgtGrDTO){
		
		bgtGrService.deleteBgtGr(bgtGrDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/bgtgr")
	public ResponseEntity<Void> updateBgtGr(@RequestBody BgtGrDTO bgtGrDTO){
		
		bgtGrService.updateBgtGr(bgtGrDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
