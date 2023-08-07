package kr.co.acctmgmt.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Pjt;
import kr.co.acctmgmt.service.PjtService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PjtController {

	private final PjtService pjtService;
	
	@GetMapping("/pjtDate/{coCd}")
	public ResponseEntity<List> pjtDataList(@PathVariable int coCd){
		
		System.out.println("������Ʈ �� �������");
		List<Pjt> pjt = pjtService.getPjtList(coCd);
		System.out.println(pjt.toString());
		return ResponseEntity.ok(pjt);
	}
//	@GetMapping("/ozt/co")
//	public List<Co> getCoList() {
//		List<Co> coList = coService.getCoList();
//	
////		System.out.println(coList.toString());
//		return coList;
//	}
	
//	@GetMapping("/ozt/scom")
//	public List<Co> getCompany(@RequestParam int coCd){
//		
//		List<Co> scompany = coService.getCompany(coCd);
//		System.out.println(scompany);
//		return scompany;
//	}
	@GetMapping("/pjtSelDate/{pjtCd}/{coCd}")
	public ResponseEntity<List<Pjt>> getSelPjtList(@PathVariable("pjtCd") String pjtCd, @PathVariable("coCd") int coCd) {
	    System.out.println("pjtcd : " + pjtCd + " / coCd: " + coCd);
	    
	    List<Pjt> pjtList = pjtService.getSelPjtList(pjtCd, coCd);
	    
	    // ��¥ �ʵ带 ���ϴ� �������� �����Ͽ� ����
	    SimpleDateFormat targetDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    for (Pjt pjt : pjtList) {
	        try {
	            Date formattedPrDt = targetDateFormat.parse(targetDateFormat.format(pjt.getPrDt()));
	            pjt.setPrDt(formattedPrDt);
	            
	            Date formattedToDt = targetDateFormat.parse(targetDateFormat.format(pjt.getToDt()));
	            pjt.setToDt(formattedToDt);
	            
	            Date formattedStDt = targetDateFormat.parse(targetDateFormat.format(pjt.getStDt()));
	            pjt.setStDt(formattedStDt);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    // ������ �����͸� ���
	    for (Pjt pjt : pjtList) {
	        System.out.println("������ ������: " + pjt);
	    }
	    
	    return ResponseEntity.ok(pjtList);
	}

	@PostMapping("/pjtDate/update/{coCd}/{date}")
	public ResponseEntity<?> updatePjt(@PathVariable("coCd") int coCd, Pjt data) {
		
		System.out.println("������Ʈ �� �� �������");
		System.out.println("����Ʈ���� ��ƿø� ��" + data.toString());

		pjtService.updatePjt(data, coCd);
		Pjt pjt = pjtService.getSelPjt(coCd, data.getPjtCd());
		
		System.out.println("�� �ݿ� �Ƴ�? " + pjt.toString());
		return ResponseEntity.ok(null);
	}
}
