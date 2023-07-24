package kr.co.acctmgmt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.dto.BgtICFDTO;
import kr.co.acctmgmt.service.BgtICFService;
import kr.co.acctmgmt.service.DivsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BgtICFController {
	
	private final BgtICFService bgtICFService;
	private final DivsService divsService;

//	@GetMapping("/bgt/bgticf")
//	public void getBGT(@RequestBody Budget budget) {
	public ResponseEntity<List<BgtICFDTO>> getBGT(@RequestBody Map<String, String> budget) {
		
		System.out.println(budget.toString());
		
		List<BgtICFDTO> bgtList = new ArrayList<>();
        
        System.out.println(bgtList.toString());
		
		return new ResponseEntity<List<BgtICFDTO>>(bgtList, HttpStatus.OK); 
	}
	
	@GetMapping("/bgt/bgticf")
//	public void getBGT(@RequestBody Budget budget) {
	public ResponseEntity<List<BgtICFDTO>> getBgtICFList() {
		
		List<BgtICFDTO> rBgtICFList = bgtICFService.getBgtICFList();
        
		
		return new ResponseEntity<List<BgtICFDTO>>(rBgtICFList, HttpStatus.OK); 
	}
	
	@DeleteMapping("/bgt/bgticf/{sq}")
	public ResponseEntity<Void> deleteBgtICFList(@PathVariable String sq){
		bgtICFService.deleteBgtICF(BgtICFDTO.builder()
				.sq(Integer.valueOf(sq))
				.build()
				);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/bgt/bgticf/")
	public ResponseEntity<Void> updateBgtICF(BgtICFDTO bgtICFDTO){
		System.out.println(bgtICFDTO);
//		bgtICFService.updateBgtICF(bgtICFDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/bgt/bgticf/div")
	public ResponseEntity<List<Divs>> findDivCdAndDivNmByCoCd(Divs divs){
		
		List<Divs> rDivs = divsService.findDivCdAndDivNmByCoCd(divs.getCoCd());
		return new ResponseEntity<List<Divs>>(rDivs,HttpStatus.OK);
	}
	
	@GetMapping("/bgt/bgticf/div")
	public ResponseEntity<List<Divs>> findDivCdAndDivNmByCoCdAndKeyword(Divs divs){
		
		List<Divs> rDivs = divsService.findDivCdAndDivNmByCoCd(divs.getCoCd());
		return new ResponseEntity<List<Divs>>(rDivs,HttpStatus.OK);
	}
	
	
}
