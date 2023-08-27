package kr.co.acctmgmt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/dialog/bgtgr/{coCd}")
	public ResponseEntity<List<BgtGrDTO>> findBgtGrByCoCdAndKeyword1(BgtGrDTO bgtGrDTO) {
		
		System.out.println(bgtGrDTO.toString());
		
		List<BgtGrDTO> rBgtGrDTOList = bgtGrService.findBgtGrByCoCdAndKeyword(bgtGrDTO);

		return new ResponseEntity<List<BgtGrDTO>>(rBgtGrDTOList, HttpStatus.OK);
	}
	
	
	@GetMapping("/dialog/bgtgr/{coCd}/{keyword}")
	public ResponseEntity<List<BgtGrDTO>> findBgtGrByCoCdAndKeyword2(BgtGrDTO bgtGrDTO) {
		
		System.out.println(bgtGrDTO.toString());
		
		List<BgtGrDTO> rBgtGrDTOList = bgtGrService.findBgtGrByCoCdAndKeyword(bgtGrDTO);

		return new ResponseEntity<List<BgtGrDTO>>(rBgtGrDTOList, HttpStatus.OK);
	}
	
	@PostMapping("/dialog/bgtgr")
	public ResponseEntity<Void> insertBgtGr(@RequestBody BgtGrDTO bgtGrDTO){
		 System.out.println(bgtGrDTO.toString());
		bgtGrService.insertBgtGr(bgtGrDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/dialog/bgtgr/{coCd}/{bgtGrCd}")
	public ResponseEntity<Void> deleteBgtGr(BgtGrDTO bgtGrDTO){
		
		bgtGrService.deleteBgtGr(bgtGrDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/dialog/bgtgr/{coCd}/{bgtGrCd}")
	public ResponseEntity<Void> updateBgtGr(@PathVariable("coCd") String coCd, @PathVariable("bgtGrCd") int bgtGrCd, @RequestBody BgtGrDTO bgtGrDTO){
		
		bgtGrDTO.setCoCd(coCd);
		bgtGrDTO.setBgtGrCd(bgtGrCd);
		bgtGrService.updateBgtGr(bgtGrDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
