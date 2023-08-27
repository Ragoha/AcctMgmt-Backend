package kr.co.acctmgmt.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Pjt;
import kr.co.acctmgmt.service.PgrService;
import kr.co.acctmgmt.service.PjtService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PjtController {

	private final PjtService pjtService;
	private final PgrService pgrService;

	@GetMapping("/pjt/{coCd}")
	public ResponseEntity<List> pjtDataList(@PathVariable String coCd) {

		System.out.println("Allselect");
		List<Pjt> pjt = pjtService.getPjtList(coCd);
		System.out.println(pjt.toString());
		return ResponseEntity.ok(pjt);
	}
	
	@PostMapping("/pjt")
	public ResponseEntity<?> insertPjt(@RequestParam("coCd") String coCd, @RequestBody Pjt pjt) {
		System.out.println("hih: " + coCd);
		System.out.println("받은 값 : " + pjt.toString());

		List<Pjt> pjList = pjtService.getPjtList(coCd);
		for (Pjt existingPjt : pjList) {
			if (existingPjt.getPjtCd().equals(pjt.getPjtCd())) {
				return ResponseEntity.badRequest().body("중복된 코드");
			}
		}
		pjtService.insertPjt(pjt, coCd);
		Pjt pjtt = pjtService.getSelPjt(coCd, pjt.getPjtCd());

		System.out.println("저장된 값 불러오기? " + pjtt.toString());
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/pjt/{coCd}/{pjtCd}")
	public ResponseEntity<?> updatePjt(@RequestBody Pjt pjt) {
	    String coCd = pjt.getCoCd();
	    System.out.println("comCode: " + pjt.getCoCd());
	    System.out.println("바꿀값 : " + pjt.toString());
	    if(!pjt.getPgrCd().isEmpty()) {
	    	String pgr = pjt.getPgrCd();
		    System.out.println("pgrCd :" + pgr);
		    String pgrNm = pgrService.findPgrByNm(coCd, pgr);
		    System.out.println("find pgrNm :" + pgrNm);
		    pjt.setPgrNm(pgrNm);
	    }
	    
	    System.out.println("바꿀값2 : " + pjt.toString());

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
	
	@DeleteMapping("/pjt/{coCd}/{pjtCd}")
	public ResponseEntity<Void> deletePjt(Pjt pjt) {
	    System.out.println("delete data : " + pjt.toString());
	    pjtService.deletePjt(pjt);
	    System.out.println("delete clear");
	    return ResponseEntity.ok(null);
	}
	
	@GetMapping("/dialog/pjt/{coCd}")
	public ResponseEntity<?> getPjtByKeyword1(Pjt pjt) {
//	    Pjt searchPjt = pjtService.getPjtByKeyword(keyword);
		
		System.out.println(pjt.toString());
		
		

		List<Pjt> searchPjt = pjtService.getPjtBy(pjt);
		System.out.println("dialog select : " + searchPjt.toString());
		return ResponseEntity.ok(searchPjt);
	}
	
	@GetMapping("/dialog/pjt/{coCd}/{keyword}")
	public ResponseEntity<?> getPjtByKeyword2(Pjt pjt) {

		List<Pjt> searchPjt = pjtService.getPjtBy(pjt);
		
		return ResponseEntity.ok(searchPjt);
	}
	

	@GetMapping("/pjt/{coCd}/{pjtCd}")
	public ResponseEntity<List<Pjt>> getSelPjtList(Pjt pjt) {
//		System.out.println("pjtcd : " + pjtCd + " / coCd: " + coCd);

		List<Pjt> rpjtList = pjtService.getSelPjtList(pjt);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (Pjt rpjt : rpjtList) {
			String formattedPrDtOrEmpty = "";

			if (pjt.getPrDt() != null) {
				formattedPrDtOrEmpty = dateFormat.format(pjt.getPrDt());
			}
		}
		return ResponseEntity.ok(rpjtList);
	}
	
	
	@GetMapping("/pjt/{coCd}/pjtcd/{pjtCd}")
	public ResponseEntity<?> duplication(Pjt pjt) {
		System.out.println("pjt : " + pjt.toString());
		List<Pjt> pjList = pjtService.getPjtList(pjt.getCoCd());
		System.out.println("pjtList : " + pjList.toString());

		for (Pjt existingPjt : pjList) {
			if (existingPjt.getPjtCd().equals(pjt.getPjtCd())) {
				return ResponseEntity.badRequest().body("중복된 코드");
			}
		}
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/pjt/groupSel/")
	public ResponseEntity<?> groupSelect(@RequestBody Pjt pjt) {		
		List<Pjt> pjtt = pjtService.getGroupPjt(pjt);
		return ResponseEntity.ok(pjtt);

	}
}
