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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Gisu;
import kr.co.acctmgmt.dto.BgtCDDTO;
import kr.co.acctmgmt.dto.BgtGrDTO;
import kr.co.acctmgmt.dto.BgtICFDTO;
import kr.co.acctmgmt.dto.DivsDTO;
import kr.co.acctmgmt.dto.GisuDTO;
import kr.co.acctmgmt.service.BgtCDService;
import kr.co.acctmgmt.service.BgtGrService;
import kr.co.acctmgmt.service.BgtICFService;
import kr.co.acctmgmt.service.DivsService;
import kr.co.acctmgmt.service.GisuService;
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
	public ResponseEntity<List<BgtICFDTO>> getBgtICFList(BgtICFDTO bgtICFDTO) {
		
		
		List<BgtICFDTO> rBgtICFList = bgtICFService.getBgtICFList(bgtICFDTO);
        
		
		return new ResponseEntity<List<BgtICFDTO>>(rBgtICFList, HttpStatus.OK); 
	}
	
	@DeleteMapping("/bgticf")
	public ResponseEntity<Void> deleteBgtICFList(BgtICFDTO bgtICFDTO){
		bgtICFService.deleteBgtICF(bgtICFDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/bgticf")
	public ResponseEntity<Void> updateBgtICF(@RequestBody BgtICFDTO bgtICFDTO){
		System.out.println("ででででででででででで");

		bgtICFService.updateBgtICF(bgtICFDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@GetMapping("/bgticf/div")
	public ResponseEntity<List<DivsDTO>> findDivByCoCdAndKeyword(DivsDTO divsDTO){
		
		List<DivsDTO> rDivsDTOList = divsService.findDivByCoCdAndKeyword(divsDTO);
		
		rDivsDTOList.forEach(rDivs -> {
		System.out.println(rDivs.toString());
		});
		
		return new ResponseEntity<List<DivsDTO>>(rDivsDTOList, HttpStatus.OK);
	}
	
	@GetMapping("/bgticf/bgtgr")
	public ResponseEntity<List<BgtGrDTO>> findBgtGrByCoCdAndKeyword(BgtGrDTO bgtGrDTO) {
		
		System.out.println(bgtGrDTO.toString());
		
		List<BgtGrDTO> rBgtGrDTOList = bgtGrService.findBgtGrByCoCdAndKeyword(bgtGrDTO);
		
		
		
		System.out.println(rBgtGrDTOList.toString());
		return new ResponseEntity<List<BgtGrDTO>>(rBgtGrDTOList, HttpStatus.OK);
	}
	
	@GetMapping("/bgticf/bgtcd")
	public ResponseEntity<List<BgtCDDTO>> findBgtCDByKeyword(BgtCDDTO bgtCDDTO){
		System.out.println(bgtCDDTO.toString());
		
		List<BgtCDDTO> rBgtCDDTOList = bgtCDService.findBgcCDByGroupCdAndToDtAndKeyword(bgtCDDTO);
		
		System.out.println(rBgtCDDTOList.toString());
		
		return new ResponseEntity<List<BgtCDDTO>>(rBgtCDDTOList, HttpStatus.OK);
	}
	
	@GetMapping("/bgticf/gisu")
	public ResponseEntity<List<GisuDTO>> findGisuByCoCd(GisuDTO gisuDTO){
		
		System.out.println(gisuDTO.toString());
		
		List<GisuDTO> rGisuDTOList = gisuService.findGisuByCoCd(gisuDTO);
		
		System.out.println(rGisuDTOList.toString());
		
		return new ResponseEntity<List<GisuDTO>>(rGisuDTOList, HttpStatus.OK);
		
	}
	
	@GetMapping("/bgticf/bgtcd/search")
	public ResponseEntity<List<BgtCDDTO>> findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(BgtCDDTO bgtCDDTO) {
		
		System.out.println(bgtCDDTO.toString());
		
		String ip = ClientUtil.getRemoteIP(request);
		
		System.out.println(ip);
		
		List<BgtCDDTO> rBgtCDDTOList = bgtCDService.findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(bgtCDDTO);
		
		System.out.println("asdf");
		System.out.println(rBgtCDDTOList.toString());
		
		return new ResponseEntity<List<BgtCDDTO>>(rBgtCDDTOList, HttpStatus.OK);
	}
	
	
}
