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

import kr.co.acctmgmt.domain.SBGTCDDomain;
import kr.co.acctmgmt.service.SBGTCDService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SBGTCDController {

	private final SBGTCDService service;

	// http://localhost:8080/acctmgmt/bgt/sbgtcd/getGridData?groupcd=GROUP1
	@GetMapping("/bgt/sbgtcd/getGridData") // groupcd �޾Ƽ� ùȭ�� �����͸� �Է��ϴ� �ڵ�
	public List<SBGTCDDomain> getGridData(@RequestParam String groupcd) {
		System.out.println("controller�� getGridData�� ����!");
		System.out.println("groupcd�� �Դ°�" + groupcd);
		List<SBGTCDDomain> list = service.getSBGTCDData(groupcd);
		System.out.println(list.toString());
		return list;
	}

	@GetMapping("/bgt/sbgtcd/getDetailInfo")
	public ResponseEntity<List<SBGTCDDomain>> getDetailInfo(@RequestParam String bgtCd) {
		System.out.println("�ٵ�������: " + bgtCd);
		List<SBGTCDDomain> list = service.getDetailInfo(bgtCd);
		System.out.println(list.toString());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	//
	@PutMapping("/bgt/sbgtcd/updateDetailInfo")
	public String updateDetailInfo(@RequestBody SBGTCDDomain updateData) {//@RequestParam SBGTCDDomain updateData
		System.out.println("���� updateDetailInfo�� ~");
		System.out.println("updateData�� ? : " +updateData.toString());
		service.updateDetailInfo(updateData);
		return "���� controller�� ~ �� ó���߾�~" ;
	}
	@DeleteMapping("/bgt/sbgtcd/deleteRow")
	public void deleteRow(@RequestParam String bgtCd) {
		System.out.println("���� delete�� ����� �ٽô� ���ư��� ���ϴ� ���̾� ");
		service.deleteRow(bgtCd);
		System.out.println("�����Ϸ� ! ");
	}
	
}