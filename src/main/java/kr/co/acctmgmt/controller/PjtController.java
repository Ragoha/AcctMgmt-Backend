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

		System.out.println("프로젝트 값 갖고오기");
		List<Pjt> pjt = pjtService.getPjtList(coCd);
		System.out.println(pjt.toString());
		return ResponseEntity.ok(pjt);
	}
	
	@PostMapping("/pjtDate/pjtSel")
	public ResponseEntity<List> getSelPjtList(@RequestBody Pjt selData) {
	    System.out.println("프로젝트 값 갖고오기");
	    System.out.println("data : " + selData.toString());
		List<Pjt> pjt = pjtService.selPjtBy(selData);
		System.out.println("검색 값: 넣기?  :"+pjt.toString());
		return ResponseEntity.ok(pjt);
	}
	
	@GetMapping("/pjtSelDate/{pjtCd}/{coCd}")
	public ResponseEntity<List<Pjt>> getSelPjtList(@PathVariable("pjtCd") String pjtCd,
			@PathVariable("coCd") int coCd) {
		System.out.println("pjtcd : " + pjtCd + " / coCd: " + coCd);

		List<Pjt> pjtList = pjtService.getSelPjtList(pjtCd, coCd);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (Pjt pjt : pjtList) {
		    String formattedPrDtOrEmpty = ""; // 기본적으로 빈 칸으로 초기화

		    if (pjt.getPrDt() != null) {
		        formattedPrDtOrEmpty = dateFormat.format(pjt.getPrDt());
		    }

//		    pjt.setFormattedPrDt(formattedPrDtOrEmpty);
		}
		// 날짜 필드를 원하는 형식으로 가공하여 설정
		

		return ResponseEntity.ok(pjtList);
	}

	@PostMapping("/pjtDate/update/{coCd}")
	public ResponseEntity<?> updatePjt(@PathVariable("coCd") int coCd, @RequestBody Pjt pjt) {
		System.out.println("hih: " + coCd);
		System.out.println("업데이트 할 값 갖고오기");
		System.out.println("프론트에서 쏘아올린 값 : " + pjt.toString());


		System.out.println("가공된 데이터 : " + pjt.toString());

		pjtService.updatePjt(pjt, coCd);

		// 업데이트 작업 완료 후 새로운 Pjt 객체를 가져올 때 사용한 data 대신 pjt 객체를 사용합니다.
		Pjt pjtt = pjtService.getSelPjt(coCd, pjt.getPjtCd()); // 수정된 부분

		System.out.println("잘 반영 됐나? " + pjtt.toString());
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/pjtDate/insert/{coCd}")
	public ResponseEntity<?> insertPjt(@PathVariable("coCd") int coCd, @RequestBody Pjt pjt) {
		System.out.println("hih: " + coCd);
		System.out.println("인서트 할 값 갖고오기");
		System.out.println("프론트에서 쏘아올린 값 : " + pjt.toString());


		System.out.println("가공된 데이터 : " + pjt.toString());

		pjtService.insertPjt(pjt, coCd);

		// 업데이트 작업 완료 후 새로운 Pjt 객체를 가져올 때 사용한 data 대신 pjt 객체를 사용합니다.
		Pjt pjtt = pjtService.getSelPjt(coCd, pjt.getPjtCd()); // 수정된 부분

		System.out.println("잘 반영 됐나? " + pjtt.toString());
		return ResponseEntity.ok(null);

	}
	
	@PostMapping("/pjtDate/delete/")
	public ResponseEntity<?> deletePjt(@RequestBody Pjt pjt) {
		System.out.println("삭제할 값 갖고오기");
		System.out.println("프론트에서 쏘아올린 값 : " + pjt.toString());

		pjtService.deletePjt(pjt);
		System.out.println("삭제 컷");
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
	    System.out.println("뭐가 들어 있는걸 까? 키워드안에 : "+ keyword);
	    System.out.println("회사코드는 잘 갖고올까? : " + coCd );
	    
	    List<Pjt> searchPjt = pjtService.getPjtBy(keyword, coCd);
	    System.out.println("셀렉 찾은 값은 : " + searchPjt.toString());
	    return ResponseEntity.ok(searchPjt);
	}
}
