package kr.co.acctmgmt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.dto.BgtICFDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BgtICFController {

	@PostMapping("/budget")
//	public void getBGT(@RequestBody Budget budget) {
	public ResponseEntity<List<BgtICFDTO>> getBGT(@RequestBody Map<String, String> budget) {
		
		System.out.println(budget.toString());
		
		List<BgtICFDTO> bgtList = new ArrayList<>();

        
        System.out.println(bgtList.toString());
		
		return new ResponseEntity<List<BgtICFDTO>>(bgtList, HttpStatus.OK); 
	}
}
