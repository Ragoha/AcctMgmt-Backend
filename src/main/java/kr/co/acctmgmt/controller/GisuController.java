package kr.co.acctmgmt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.dto.GisuDTO;
import kr.co.acctmgmt.service.GisuService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class GisuController {
	
	private final GisuService gisuService;
	
	@GetMapping("/gisu")
	public ResponseEntity<List<GisuDTO>> findGisuByCoCd(GisuDTO gisuDTO){
		System.out.println(gisuDTO.toString());
		
		List<GisuDTO> rGisuDTO= gisuService.findGisuByCoCd(gisuDTO);
		
		System.out.println(rGisuDTO.toString());
		
		return new ResponseEntity<List<GisuDTO>>(rGisuDTO, HttpStatus.OK);
	}
	
	@PostMapping("/gisu")
	public ResponseEntity<Void> insertGisu(@RequestBody GisuDTO gisuDTO){
		System.out.println("===========");
		System.out.println(gisuDTO.toString());
		
		gisuService.insertGisu(gisuDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/gisu")
	public ResponseEntity<Void> updateGisu(@RequestBody GisuDTO gisuDTO){

		gisuService.updateGisu(gisuDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/gisu")
	public ResponseEntity<Void> deleteGisu(GisuDTO gisuDTO){
		
		gisuService.deleteGisu(gisuDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	

}
