package kr.co.acctmgmt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	public ResponseEntity<List> pjtDataList(@PathVariable String coCd) {

		System.out.println("Allselect");
		List<Pjt> pjt = pjtService.getPjtList(coCd);
		System.out.println(pjt.toString());
		return ResponseEntity.ok(pjt);
	}

	@PostMapping("/pjtDate/pjtSel")
	public ResponseEntity<List> getSelPjtList(@RequestBody Pjt selData) {
		System.out.println("choice");
		System.out.println("data : " + selData.toString());
		List<Pjt> pjt = pjtService.selPjtBy(selData);
		System.out.println("sel data  :" + pjt.toString());
		return ResponseEntity.ok(pjt);
	}

	@GetMapping("/pjtSelDate/{pjtCd}/{coCd}")
	public ResponseEntity<List<Pjt>> getSelPjtList(@PathVariable("pjtCd") String pjtCd,
			@PathVariable("coCd") String coCd) {
		System.out.println("pjtcd : " + pjtCd + " / coCd: " + coCd);

		List<Pjt> pjtList = pjtService.getSelPjtList(pjtCd, coCd);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (Pjt pjt : pjtList) {
			String formattedPrDtOrEmpty = "";

			if (pjt.getPrDt() != null) {
				formattedPrDtOrEmpty = dateFormat.format(pjt.getPrDt());
			}

		}

		return ResponseEntity.ok(pjtList);
	}

	@PostMapping("/pjtDate/update/{coCd}")
	public ResponseEntity<?> updatePjt(@PathVariable("coCd") String coCd, @RequestBody Pjt pjt) {
	    System.out.println("hih: " + coCd);
	    System.out.println("바꿀값 : " + pjt.toString());
	    
	    Pjt existingPjt = pjtService.getSelPjt(coCd, pjt.getPjtCd());
	    
	    if(pjt.getPgrNm() != null || pjt.getPgrNm()!="") {
	        existingPjt.setPgrNm(pjt.getPgrNm());
	    }
	    if(pjt.getPgrNm() != null || pjt.getPgrNm()!="") {
	        existingPjt.setPgrNm(pjt.getPgrNm());
	    }
	    pjtService.updatePjt(pjt, coCd);

	    Pjt pjtt = pjtService.getSelPjt(coCd, pjt.getPjtCd());

	    System.out.println("바뀐값 " + pjtt.toString());
	    return ResponseEntity.ok(pjt);
	}


	@PostMapping("/pjtDate/insert/{coCd}")
	public ResponseEntity<?> insertPjt(@PathVariable("coCd") String coCd, @RequestBody Pjt pjt) {
		System.out.println("hih: " + coCd);
		System.out.println("받은 값 : " + pjt.toString());

		List<Pjt> pjList = pjtService.getPjtList(coCd);
		for (Pjt existingPjt : pjList) {
			if (existingPjt.getPjtCd().equals(pjt.getPjtCd())) {
				return ResponseEntity.badRequest().body("중복된 코드");
			}
		}
		pjtService.insertPjt(pjt, coCd);

		// �뾽�뜲�씠�듃 �옉�뾽 �셿猷� �썑 �깉濡쒖슫 Pjt 媛앹껜瑜� 媛��졇�삱 �븣 �궗�슜�븳 data ���떊 pjt 媛앹껜瑜�
		// �궗�슜�빀�땲�떎.
		Pjt pjtt = pjtService.getSelPjt(coCd, pjt.getPjtCd()); // �닔�젙�맂 遺�遺�

		System.out.println("저장된 값 불러오기? " + pjtt.toString());
		return ResponseEntity.ok(null);
	}

	@PostMapping("/pjtDate/duplication/{coCd}")
	public ResponseEntity<?> duplication(@PathVariable("coCd") String coCd, @RequestBody Pjt pjt) {
		List<Pjt> pjList = pjtService.getPjtList(coCd);
		for (Pjt existingPjt : pjList) {
			if (existingPjt.getPjtCd().equals(pjt.getPjtCd())) {
				return ResponseEntity.badRequest().body("중복된 코드");
			}
		}
		return ResponseEntity.ok(null);
	}

	@PostMapping("/pjtDate/delete/")
	public ResponseEntity<?> deletePjt(@RequestBody Pjt pjt) {
		System.out.println("delete data : " + pjt.toString());

		pjtService.deletePjt(pjt);
		System.out.println("delete clear");
		return ResponseEntity.ok(null);

	}
//	@GetMapping("/pjtDate/pgrSearch")
//	public List<Pjt> getCoBycoCdAndcoNm(Pjt pjt){

//		List<Co> searchPgr = pjtService.getPgrBy(pjt);
//		System.out.println(searchPgr);
//		return searchPgr;
//	}

	@GetMapping("/pjtDate/pjtSearch/{coCd}")
	public ResponseEntity<?> getPjtByKeyword(@RequestParam String keyword, @PathVariable("coCd") String coCd) {
//	    Pjt searchPjt = pjtService.getPjtByKeyword(keyword);
		System.out.println("select keyword : " + keyword);

		List<Pjt> searchPjt = pjtService.getPjtBy(keyword, coCd);
		System.out.println("dialog select : " + searchPjt.toString());
		return ResponseEntity.ok(searchPjt);
	}
	
	@GetMapping("/pjtDate/pgrSearch/{coCd}")
	public ResponseEntity<?> getPgrByKeyword(@RequestParam String keyword, @PathVariable("coCd") String coCd) {
	    System.out.println("select keyword : " + keyword);

	    List<Pjt> searchPgr = pjtService.getPgrtBy(keyword, coCd);
	    System.out.println("dialog select : " + searchPgr.toString());
	    return ResponseEntity.ok(searchPgr);
	}


	@PostMapping("/pjtData/condition/")
	public ResponseEntity<List> condtionPjtSelect(@RequestBody Pjt pjt) {
		return null;
	}
	
	@PostMapping("/pjtDate/groupSel/")
	public ResponseEntity<?> groupSelect(@RequestBody Pjt pjt) {

		System.out.println("req: " + pjt.toString());
		
		List<Pjt> pjtt = pjtService.getGroupPjt(pjt);
		System.out.println("잘 갖고올까?" + pjtt.toString());
		return ResponseEntity.ok(pjtt);

	}
}
