package kr.co.acctmgmt.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.http.HttpStatus;
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

		System.out.println("�봽濡쒖젥�듃 媛� 媛뽮퀬�삤湲�");
		List<Pjt> pjt = pjtService.getPjtList(coCd);
		System.out.println(pjt.toString());
		return ResponseEntity.ok(pjt);
	}
	
	@PostMapping("/pjtDate/pjtSel")
	public ResponseEntity<List> getSelPjtList(@RequestBody Pjt selData) {
	    System.out.println("�봽濡쒖젥�듃 媛� 媛뽮퀬�삤湲�");
	    System.out.println("data : " + selData.toString());
		List<Pjt> pjt = pjtService.selPjtBy(selData);
		System.out.println("寃��깋 媛�: �꽔湲�?  :"+pjt.toString());
		return ResponseEntity.ok(pjt);
	}
	
	@GetMapping("/pjtSelDate/{pjtCd}/{coCd}")
	public ResponseEntity<List<Pjt>> getSelPjtList(@PathVariable("pjtCd") String pjtCd,
			@PathVariable("coCd") int coCd) {
		System.out.println("pjtcd : " + pjtCd + " / coCd: " + coCd);

		List<Pjt> pjtList = pjtService.getSelPjtList(pjtCd, coCd);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (Pjt pjt : pjtList) {
		    String formattedPrDtOrEmpty = ""; // 湲곕낯�쟻�쑝濡� 鍮� 移몄쑝濡� 珥덇린�솕

		    if (pjt.getPrDt() != null) {
		        formattedPrDtOrEmpty = dateFormat.format(pjt.getPrDt());
		    }



		}
		// �궇吏� �븘�뱶瑜� �썝�븯�뒗 �삎�떇�쑝濡� 媛�怨듯븯�뿬 �꽕�젙
		

		return ResponseEntity.ok(pjtList);
	}

	@PostMapping("/pjtDate/update/{coCd}")
	public ResponseEntity<?> updatePjt(@PathVariable("coCd") int coCd, @RequestBody Pjt pjt) {
		System.out.println("hih: " + coCd);
		System.out.println("�뾽�뜲�씠�듃 �븷 媛� 媛뽮퀬�삤湲�");
		System.out.println("�봽濡좏듃�뿉�꽌 �룜�븘�삱由� 媛� : " + pjt.toString());


		System.out.println("媛�怨듬맂 �뜲�씠�꽣 : " + pjt.toString());

		pjtService.updatePjt(pjt, coCd);

		// �뾽�뜲�씠�듃 �옉�뾽 �셿猷� �썑 �깉濡쒖슫 Pjt 媛앹껜瑜� 媛��졇�삱 �븣 �궗�슜�븳 data ���떊 pjt 媛앹껜瑜� �궗�슜�빀�땲�떎.
		Pjt pjtt = pjtService.getSelPjt(coCd, pjt.getPjtCd()); // �닔�젙�맂 遺�遺�

		System.out.println("�옒 諛섏쁺 �릱�굹? " + pjtt.toString());
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/pjtDate/insert/{coCd}")
	public ResponseEntity<?> insertPjt(@PathVariable("coCd") int coCd, @RequestBody Pjt pjt) {
		System.out.println("hih: " + coCd);
		System.out.println("받은 값 : " + pjt.toString());
		
		List<Pjt> pjList = pjtService.getPjtList(coCd);
		for (Pjt existingPjt : pjList) {
            if (existingPjt.getPjtCd().equals(pjt.getPjtCd())) {
                return ResponseEntity.badRequest().body("중복된 코드");
            }
        }		
		pjtService.insertPjt(pjt, coCd);

		// �뾽�뜲�씠�듃 �옉�뾽 �셿猷� �썑 �깉濡쒖슫 Pjt 媛앹껜瑜� 媛��졇�삱 �븣 �궗�슜�븳 data ���떊 pjt 媛앹껜瑜� �궗�슜�빀�땲�떎.
		Pjt pjtt = pjtService.getSelPjt(coCd, pjt.getPjtCd()); // �닔�젙�맂 遺�遺�

		System.out.println("저장된 값 불러오기? " + pjtt.toString());
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/pjtDate/duplication/{coCd}")
	public ResponseEntity<?> duplication(@PathVariable("coCd") int coCd, @RequestBody Pjt pjt) {		
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
		System.out.println("�궘�젣�븷 媛� 媛뽮퀬�삤湲�");
		System.out.println("�봽濡좏듃�뿉�꽌 �룜�븘�삱由� 媛� : " + pjt.toString());

		pjtService.deletePjt(pjt);
		System.out.println("�궘�젣 而�");
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
	    System.out.println("萸먭� �뱾�뼱 �엳�뒗嫄� 源�? �궎�썙�뱶�븞�뿉 : "+ keyword);
	    System.out.println("�쉶�궗肄붾뱶�뒗 �옒 媛뽮퀬�삱源�? : " + coCd );
	    
	    List<Pjt> searchPjt = pjtService.getPjtBy(keyword, coCd);
	    System.out.println("���젆 李얠� 媛믪� : " + searchPjt.toString());
	    return ResponseEntity.ok(searchPjt);
	}
	
	@PostMapping("/pjtData/condition/")
	public ResponseEntity<List> condtionPjtSelect(@RequestBody Pjt pjt){
		return null;
	}
}
