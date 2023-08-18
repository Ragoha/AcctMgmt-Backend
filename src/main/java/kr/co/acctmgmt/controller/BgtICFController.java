package kr.co.acctmgmt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.dto.BgtCDDTO;
import kr.co.acctmgmt.dto.BgtGrDTO;
import kr.co.acctmgmt.dto.BgtICFDTO;
import kr.co.acctmgmt.dto.DivsDTO;
import kr.co.acctmgmt.dto.GisuDTO;
import kr.co.acctmgmt.dto.PjtDTO;
import kr.co.acctmgmt.service.BgtCDService;
import kr.co.acctmgmt.service.BgtGrService;
import kr.co.acctmgmt.service.BgtICFService;
import kr.co.acctmgmt.service.DivsService;
import kr.co.acctmgmt.service.GisuService;
import kr.co.acctmgmt.service.PjtService;
import kr.co.acctmgmt.util.ClientUtil;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BgtICFController {
	
	private final HttpServletRequest request;
	private final BgtICFService bgtICFService;
	private final DivsService divsService;
	private final BgtCDService bgtCDService; 
	private final BgtGrService bgtGrService;
	private final GisuService gisuService;
	private final PjtService pjtService;

	@GetMapping("/bgticf")
	public ResponseEntity<List<BgtICFDTO>> getBgtICFList(BgtICFDTO bgtICFDTO) {
		
		List<BgtICFDTO> rBgtICFList = bgtICFService.getBgtICFList(bgtICFDTO);
        
		return new ResponseEntity<List<BgtICFDTO>>(rBgtICFList, HttpStatus.OK); 
	}
	
	@DeleteMapping("/bgticf")
	public ResponseEntity<Void> deleteBgtICFList(BgtICFDTO bgtICFDTO){
		bgtICFService.deleteBgtICF(bgtICFDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/bgticf")
	public ResponseEntity<Void> insertBgtICF(@RequestBody BgtICFDTO bgtICFDTO){

		bgtICFService.insertBgtICF(bgtICFDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@PutMapping("/bgticf")
	public ResponseEntity<Void> updateBgtICF(@RequestBody BgtICFDTO bgtICFDTO){

		bgtICFService.updateBgtICF(bgtICFDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@GetMapping("/bgticf/div")
	public ResponseEntity<List<DivsDTO>> findDivByCoCdAndKeyword(DivsDTO divsDTO){
		
		List<DivsDTO> rDivsDTOList = divsService.findDivByCoCdAndKeyword(divsDTO);
		
		return new ResponseEntity<List<DivsDTO>>(rDivsDTOList, HttpStatus.OK);
	}
	
	@GetMapping("/bgticf/bgtgr")
	public ResponseEntity<List<BgtGrDTO>> findBgtGrByCoCdAndKeyword(BgtGrDTO bgtGrDTO) {
		
		List<BgtGrDTO> rBgtGrDTOList = bgtGrService.findBgtGrByCoCdAndKeyword(bgtGrDTO);

		return new ResponseEntity<List<BgtGrDTO>>(rBgtGrDTOList, HttpStatus.OK);
	}
	
	@GetMapping("/bgticf/bgtcd")
	public ResponseEntity<List<BgtCDDTO>> findBgtCDByKeyword(BgtCDDTO bgtCDDTO){
		
		List<BgtCDDTO> rBgtCDDTOList = bgtCDService.findBgcCDByGroupCdAndToDtAndKeyword(bgtCDDTO);
		
		return new ResponseEntity<List<BgtCDDTO>>(rBgtCDDTOList, HttpStatus.OK);
	}
	
	@GetMapping("/bgticf/gisu")
	public ResponseEntity<List<GisuDTO>> findGisuByCoCd(GisuDTO gisuDTO){
		
		List<GisuDTO> rGisuDTOList = gisuService.findGisuByCoCd(gisuDTO);
		
		return new ResponseEntity<List<GisuDTO>>(rGisuDTOList, HttpStatus.OK);
		
	}
	
	@GetMapping("/bgticf/pjt")
	public ResponseEntity<List<PjtDTO>> findPjtByCoCdAndKeyword(PjtDTO pjtDTO){

		List<PjtDTO> rPjtDTOList = pjtService.findPjtByCoCdAndKeyword(pjtDTO);
		
		return new ResponseEntity<List<PjtDTO>>(rPjtDTOList, HttpStatus.OK);
		
	}
	
	@GetMapping("/bgticf/bgtcd/search")
	public ResponseEntity<List<BgtCDDTO>> findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(BgtCDDTO bgtCDDTO) {
		
		
		String ip = ClientUtil.getRemoteIP(request);
		
		
		List<BgtCDDTO> rBgtCDDTOList = bgtCDService.findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(bgtCDDTO);
		
		
		return new ResponseEntity<List<BgtCDDTO>>(rBgtCDDTOList, HttpStatus.OK);
	}
	
	
}
