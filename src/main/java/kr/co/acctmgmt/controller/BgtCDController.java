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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.service.BgtCDService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BgtCDController {

	private final BgtCDService service;

	// http://localhost:8080/acctmgmt/bgt/sbgtcd/getGridData?groupcd=GROUP1
	@GetMapping("/bgt/bgtcd/getGridData") // groupcd 
	public List<BgtCD> getGridData(@RequestParam String groupcd) {
		System.out.println("groupcd를 찾아야함");
		List<BgtCD> list = service.getSBGTCDData(groupcd);
		System.out.println(list.toString());
		return list;
	}

	@GetMapping("/bgt/bgtcd/getDetailInfo")
	public ResponseEntity<List<BgtCD>> getDetailInfo(@RequestParam String bgtCd) {
		System.out.println("getDetailINfo 입니다 : " + bgtCd);
		List<BgtCD> list = service.getDetailInfo(bgtCd);
		System.out.println(list.toString());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	//
	@PutMapping("/bgt/bgtcd/updateDetailInfo")
	public String updateDetailInfo(@RequestBody BgtCD updateData) {//@RequestParam SBGTCDDomain updateData
		service.updateDetailInfo(updateData);
		return "여기가 컨트롤러야~ "  ;
	}
	@DeleteMapping("/bgt/bgtcd/deleteRow")
	public void deleteRow(@RequestParam String bgtCd) {
		service.deleteRow(bgtCd);
		System.out.println("여기가 딜리트야 ~");
	}
	
}