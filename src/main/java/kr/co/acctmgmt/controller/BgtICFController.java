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
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/bgticf/{coCd}/{bgtCd}")
	public ResponseEntity<List<BgtICFDTO>> getBgtICFList(BgtICFDTO bgtICFDTO) {
		
		System.out.println(bgtICFDTO.toString());
		
		List<BgtICFDTO> rBgtICFList = bgtICFService.getBgtICFList(bgtICFDTO);
        
		return new ResponseEntity<List<BgtICFDTO>>(rBgtICFList, HttpStatus.OK); 
	}
	
	@DeleteMapping("/bgticf/{coCd}/{bgtCd}")
	public ResponseEntity<Void> deleteBgtICFList(BgtICFDTO bgtICFDTO){
		System.out.println("==============");
		System.out.println(bgtICFDTO.toString());
		bgtICFService.deleteBgtICF(bgtICFDTO);
		List<String> sqList = bgtICFDTO.getSqList();
		sqList.forEach(sq -> {
			System.out.println(sq);
		});
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/bgticf")
	public ResponseEntity<Void> insertBgtICF(@RequestBody BgtICFDTO bgtICFDTO){

		bgtICFService.insertBgtICF(bgtICFDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@PutMapping("/bgticf/{coCd}/{bgtCd}/{sq}")
	public ResponseEntity<Void> updateBgtICF(@PathVariable("coCd") String coCd, @PathVariable("bgtCd") String bgtCd, @PathVariable("sq") int sq, @RequestBody BgtICFDTO bgtICFDTO){

		bgtICFDTO.setCoCd(coCd);
		bgtICFDTO.setSq(sq);
		bgtICFDTO.setBgtCd(bgtCd);
		bgtICFService.updateBgtICF(bgtICFDTO);
		
		System.out.println(bgtICFDTO.toString());
		System.out.println("==================");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@GetMapping("/bgticf/div")
	public ResponseEntity<List<DivsDTO>> findDivByCoCdAndKeyword(DivsDTO divsDTO){
		
		List<DivsDTO> rDivsDTOList = divsService.findDivByCoCdAndKeyword(divsDTO);
		
		return new ResponseEntity<List<DivsDTO>>(rDivsDTOList, HttpStatus.OK);
	}
	

	
	@GetMapping("/dialog/bgticf/bgtcd/{coCd}")
	public ResponseEntity<List<BgtCDDTO>> findBgtCDByKeyword(BgtCDDTO bgtCDDTO){
		System.out.println(bgtCDDTO.toString());
		
		List<BgtCDDTO> rBgtCDDTOList = bgtCDService.findBgcCDByGroupCdAndToDtAndKeyword(bgtCDDTO);
		
		return new ResponseEntity<List<BgtCDDTO>>(rBgtCDDTOList, HttpStatus.OK);
	}
//	
//	@GetMapping("/bgticf/gisu")
//	public ResponseEntity<List<GisuDTO>> findGisuByCoCd(GisuDTO gisuDTO){
//		
//		List<GisuDTO> rGisuDTOList = gisuService.findGisuByCoCd(gisuDTO);
//		
//		return new ResponseEntity<List<GisuDTO>>(rGisuDTOList, HttpStatus.OK);
//		
//	}
	
	@GetMapping("/bgticf/pjt")
	public ResponseEntity<List<PjtDTO>> findPjtByCoCdAndKeyword(PjtDTO pjtDTO){

		List<PjtDTO> rPjtDTOList = pjtService.findPjtByCoCdAndKeyword(pjtDTO);
		
		return new ResponseEntity<List<PjtDTO>>(rPjtDTOList, HttpStatus.OK);
		
	}
	
	@GetMapping("/bgticf/bgtcd/{coCd}")
	public ResponseEntity<List<BgtCDDTO>> findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(BgtCDDTO bgtCDDTO) {
		
		System.out.println("======================");
		System.out.println(bgtCDDTO.toString());
		
		
		String ip = ClientUtil.getRemoteIP(request);
		
		
		List<BgtCDDTO> rBgtCDDTOList = bgtCDService.findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(bgtCDDTO);
		
		
		return new ResponseEntity<List<BgtCDDTO>>(rBgtCDDTOList, HttpStatus.OK);
	}
	
	
}
