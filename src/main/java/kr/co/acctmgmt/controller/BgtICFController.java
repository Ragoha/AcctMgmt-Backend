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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.dto.BgtGrDTO;
import kr.co.acctmgmt.dto.BgtICFDTO;
import kr.co.acctmgmt.dto.DivsDTO;
import kr.co.acctmgmt.service.BgtGrService;
import kr.co.acctmgmt.service.BgtICFService;
import kr.co.acctmgmt.service.DivsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BgtICFController {
	
	private final BgtICFService bgtICFService;
	private final DivsService divsService;
	private final BgtGrService bgtGrService;

//	@GetMapping("/bgt/bgticf")
//	public void getBGT(@RequestBody Budget budget) {
	public ResponseEntity<List<BgtICFDTO>> getBGT(@RequestBody Map<String, String> budget) {
		
		System.out.println(budget.toString());
		
		List<BgtICFDTO> bgtList = new ArrayList<>();
        
        System.out.println(bgtList.toString());
		
		return new ResponseEntity<List<BgtICFDTO>>(bgtList, HttpStatus.OK); 
	}
	
	@GetMapping("/bgticf")
//	public void getBGT(@RequestBody Budget budget) {
	public ResponseEntity<List<BgtICFDTO>> getBgtICFList() {
		
		List<BgtICFDTO> rBgtICFList = bgtICFService.getBgtICFList();
        
		
		return new ResponseEntity<List<BgtICFDTO>>(rBgtICFList, HttpStatus.OK); 
	}
	
	@DeleteMapping("/bgticf/{sq}")
	public ResponseEntity<Void> deleteBgtICFList(@PathVariable String sq){
		bgtICFService.deleteBgtICF(BgtICFDTO.builder()
				.sq(Integer.valueOf(sq))
				.build()
				);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/bgticf")
	public ResponseEntity<Void> updateBgtICF(BgtICFDTO bgtICFDTO){
		System.out.println(bgtICFDTO);
//		bgtICFService.updateBgtICF(bgtICFDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/bgticf/div")
	public ResponseEntity<List<DivsDTO>> findDivCdAndDivNmByCoCd(DivsDTO divsDTO){
		
		List<DivsDTO> rDivsDTOList = divsService.findDivsByCoCd(divsDTO);
		return new ResponseEntity<List<DivsDTO>>(rDivsDTOList,HttpStatus.OK);
	}
	
	@GetMapping("/bgticf/div/search")
	public ResponseEntity<List<DivsDTO>> findDivCdAndDivNmByCoCdAndKeyword(DivsDTO divsDTO){
		
		List<DivsDTO> rDivsDTOList = divsService.findDivsByCoCdAndKeyword(divsDTO);
		
		rDivsDTOList.forEach(rDivs -> {
		System.out.println(rDivs.toString());
		});
		
		return new ResponseEntity<List<DivsDTO>>(rDivsDTOList, HttpStatus.OK);
	}
	
	@GetMapping("/bgticf/bgtgr")
	public ResponseEntity<List<BgtGrDTO>> findBgtGrCdAndBgtGrNmByCoCd(BgtGrDTO bgtGrDTO) {
		
		System.out.println(bgtGrDTO.toString());
		
		List<BgtGrDTO> rBgtGrDTOList = bgtGrService.findBgtGrCdAndBgtGrNmByCoCd(bgtGrDTO);
		
		return new ResponseEntity<List<BgtGrDTO>>(rBgtGrDTOList, HttpStatus.OK);
	}
	
	@GetMapping("/bgticf/bgtgr/search")
	public ResponseEntity<List<BgtGrDTO>> findBgtGrCdAndBgtGrNmByKeyword(BgtGrDTO bgtGrDTO) {
		
		System.out.println(bgtGrDTO.toString());
		
		List<BgtGrDTO> rBgtGrDTOList = bgtGrService.findBgtGrCdAndBgtGrNmByKeyword(bgtGrDTO);
		
		
		
		System.out.println(rBgtGrDTOList.toString());
		return new ResponseEntity<List<BgtGrDTO>>(rBgtGrDTOList, HttpStatus.OK);
	}
	
	
}
