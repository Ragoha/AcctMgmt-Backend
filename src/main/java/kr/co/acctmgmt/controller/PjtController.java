package kr.co.acctmgmt.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<List> pjtDataList(@PathVariable int coCd) {

		System.out.println("������Ʈ �� �������");
		List<Pjt> pjt = pjtService.getPjtList(coCd);
		System.out.println(pjt.toString());
		return ResponseEntity.ok(pjt);
	}
	
	@PostMapping("/pjtDate/pjtSel")
	public ResponseEntity<List> getSelPjtList(@RequestBody Pjt selData) {
	    System.out.println("������Ʈ �� �������");
	    System.out.println("data : " + selData.toString());
		List<Pjt> pjt = pjtService.selPjtBy(selData);
		System.out.println("�˻� ��: �ֱ�?  :"+pjt.toString());
		return ResponseEntity.ok(pjt);
	}
	
	@GetMapping("/pjtSelDate/{pjtCd}/{coCd}")
	public ResponseEntity<List<Pjt>> getSelPjtList(@PathVariable("pjtCd") String pjtCd,
			@PathVariable("coCd") int coCd) {
		System.out.println("pjtcd : " + pjtCd + " / coCd: " + coCd);

		List<Pjt> pjtList = pjtService.getSelPjtList(pjtCd, coCd);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (Pjt pjt : pjtList) {
		    String formattedPrDtOrEmpty = ""; // �⺻������ �� ĭ���� �ʱ�ȭ

		    if (pjt.getPrDt() != null) {
		        formattedPrDtOrEmpty = dateFormat.format(pjt.getPrDt());
		    }

//		    pjt.setFormattedPrDt(formattedPrDtOrEmpty);
		}
		// ��¥ �ʵ带 ���ϴ� �������� �����Ͽ� ����
		

		return ResponseEntity.ok(pjtList);
	}

	@PostMapping("/pjtDate/update/{coCd}")
	public ResponseEntity<?> updatePjt(@PathVariable("coCd") int coCd, @RequestBody Pjt pjt) {
		System.out.println("hih: " + coCd);
		System.out.println("������Ʈ �� �� �������");
		System.out.println("����Ʈ���� ��ƿø� �� : " + pjt.toString());


		System.out.println("������ ������ : " + pjt.toString());

		pjtService.updatePjt(pjt, coCd);

		// ������Ʈ �۾� �Ϸ� �� ���ο� Pjt ��ü�� ������ �� ����� data ��� pjt ��ü�� ����մϴ�.
		Pjt pjtt = pjtService.getSelPjt(coCd, pjt.getPjtCd()); // ������ �κ�

		System.out.println("�� �ݿ� �Ƴ�? " + pjtt.toString());
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/pjtDate/insert/{coCd}")
	public ResponseEntity<?> insertPjt(@PathVariable("coCd") int coCd, @RequestBody Pjt pjt) {
		System.out.println("hih: " + coCd);
		System.out.println("�μ�Ʈ �� �� �������");
		System.out.println("����Ʈ���� ��ƿø� �� : " + pjt.toString());


		System.out.println("������ ������ : " + pjt.toString());

		pjtService.insertPjt(pjt, coCd);

		// ������Ʈ �۾� �Ϸ� �� ���ο� Pjt ��ü�� ������ �� ����� data ��� pjt ��ü�� ����մϴ�.
		Pjt pjtt = pjtService.getSelPjt(coCd, pjt.getPjtCd()); // ������ �κ�

		System.out.println("�� �ݿ� �Ƴ�? " + pjtt.toString());
		return ResponseEntity.ok(null);

	}
	
	@PostMapping("/pjtDate/delete/")
	public ResponseEntity<?> deletePjt(@RequestBody Pjt pjt) {
		System.out.println("������ �� �������");
		System.out.println("����Ʈ���� ��ƿø� �� : " + pjt.toString());

		pjtService.deletePjt(pjt);
		System.out.println("���� ��");
		return ResponseEntity.ok(null);

	}
//	@GetMapping("/pjtDate/pgrSearch")
//	public List<Pjt> getCoBycoCdAndcoNm(Pjt pjt){
		
//		List<Co> searchPgr = pjtService.getPgrBy(pjt);
//		System.out.println(searchPgr);
//		return searchPgr;
//	}
	
	@GetMapping("/pjtDate/pjtSearch/{coCd}")
	public ResponseEntity<?> getPjtByKeyword(@RequestParam String keyword, @PathVariable("coCd") int coCd) {
//	    Pjt searchPjt = pjtService.getPjtByKeyword(keyword);
	    System.out.println("���� ��� �ִ°� ��? Ű����ȿ� : "+ keyword);
	    System.out.println("ȸ���ڵ�� �� ����ñ�? : " + coCd );
	    
	    List<Pjt> searchPjt = pjtService.getPjtBy(keyword, coCd);
	    System.out.println("���� ã�� ���� : " + searchPjt.toString());
	    return ResponseEntity.ok(searchPjt);
	}
}
