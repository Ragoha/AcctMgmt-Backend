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
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.domain.BgtGr;
import kr.co.acctmgmt.domain.Gisu;
import kr.co.acctmgmt.dto.BgtCDTermDTO;
import kr.co.acctmgmt.dto.BgtICFDTO;
import kr.co.acctmgmt.service.BgtCDService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BgtCDController {

	private final BgtCDService service;
//	@GetMapping("/bgtcd")
//	public String testest(@RequestParam String coCd) {
//		System.out.println("testest  : " + coCd);
//		return null;
//	}
	
	/*議고쉶 start*/
	// http://localhost:8080/acctmgmt/bgt/sbgtcd/getGridData?groupcd=GROUP1
	@GetMapping("/bgtcd/getGridData") // groupcd 
	public List<BgtCD> getGridData(@RequestParam String coCd ,String gisu,String groupCd) {
		List<BgtCD> list = service.getBGTCDData(coCd,gisu,groupCd);
		return list;
	}

	@GetMapping("/bgtcd/getDetailInfo")
	public ResponseEntity<List<BgtCD>> getDetailInfo(@RequestParam String bgtCd) {
		List<BgtCD> list = service.getDetailInfo(bgtCd);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("/bgtcd/getBgtCDTerm")
	public List<BgtCDTermDTO> getBgtCDTerm(@RequestParam String CO_CD){
		List<BgtCDTermDTO> list = service.getBgtCDTerm(CO_CD);
		return list;
	}
	@GetMapping("/bgtcd/getPath")
	public String getPath(@RequestParam String bgtCd) {
		return service.getPath(bgtCd);
	}
	@GetMapping("/bgtcd/getBgtGrData")
	public List<BgtGr> getBgtGrData(@RequestParam String coCd) {
		List<BgtGr> bgtGr = service.getBgtGrData(coCd);
		return bgtGr;
	}
	@GetMapping("/bgtcd/getBgtCDdialog")
	public List<BgtCD> getBgtCDdialog(@RequestParam String coCd,String keyword){
		return service.getBgtCDdialog(coCd, keyword);
	}
	@GetMapping("/bgtcd/getBgtCdLikeSearch")
	public List<BgtCD> getBgtCdLikeSearch(@RequestParam String coCd , String keyword){
		return service.getBgtCdLikeSearch(coCd,keyword);
		 
	}
	@GetMapping("/bgtcd/getSearchData")
	public List<BgtCD> getSearchData(@RequestParam String coCd,String gisu, String groupCd, String keyword){
		return service.getSearchData(coCd,gisu,groupCd,keyword);
		
	}
	@GetMapping("/bgtcd/getinitGisuList")
	public List<Gisu> getinitGisuList(@RequestParam String coCd){
		return service.getinitGisuList(coCd);
	}
	@GetMapping("/bgtcd/getinitBgtGrSearch")
	public List<BgtGr> getinitBgtGrSearch(@RequestParam String coCd, String keyword){
		return service.getinitBgtGrSearch(coCd,keyword);
	}
	
	
	@GetMapping("/bgtcd/getBgtGrSearch")
	public List<BgtGr> getBgtGrSearch(@RequestParam String coCd, String keyword){
		
		return service.getBgtGrSearch(coCd,keyword);
	}
 
	@GetMapping("/bgtcd/getDefNmFromBGTCD_TERM")
	public String getDefNmFromBGTCD_TERM(@RequestParam String coCd, String divFg) {
		int a = Integer.parseInt(divFg);
		a= a+1;
		String b = Integer.toString(a);
		b =service.getDefNmFromBGTCD_TERM(coCd,b);
		return b;
	}
	@GetMapping("/bgtcd/updateBgtNm")
	public void updateBgtNm(@RequestParam String coCd,  String bgtCd , String bgtNm) {
		service.updateBgtNm(coCd,bgtCd,bgtNm);
	}
	@GetMapping("/bgtcd/getbgtGrSearchKeywordData")
	public List<BgtGr> getbgtGrSearchKeywordData(@RequestParam String coCd, String keyword) {
		return service.getbgtGrSearchKeywordData(coCd,keyword);
	}
	/*select  end*/
	
	
	/*update start */
	@PutMapping("/bgtcd/updateDetailInfo")
	public void updateDetailInfo(@RequestBody BgtCD updateData) {//@RequestParam SBGTCDDomain updateData
		service.updateDetailInfo(updateData);
	}
	@PutMapping("/bgtcd/updateBgtCDTerm")
	public List<BgtCDTermDTO> updateBgtCDTerm(@RequestBody List<BgtCDTermDTO> dataList) {
		return service.updateBgtCDTerm(dataList);
	}
	
	@GetMapping("/bgtcd/getAddRowData") //[230808]make new AddRow data 
	public BgtCD getAddRowData(@RequestParam String bgtCd , String coCd,String gisu, String groupCd) {
		String[] str = groupCd.split("\\.");
		groupCd = str[0];
		BgtCD info =  service.addRowData(bgtCd , coCd, gisu, groupCd);
		return info;
	}
	@PutMapping("/bgtcd/insertBgtGr")
	public void insertBgtGr(@RequestBody List<BgtGr> dataList) {
		service.insertBgtGr(dataList);
	}
	
	@GetMapping("/bgtcd/checkTopData")
	public BgtCD checkTopData(@RequestParam String coCd, String gisu,String tDataPath,String keyword) {
		return service.checkTopData(coCd,gisu,tDataPath,keyword);
	}
	
	
	/*select end */
	/*insert start */
	@PostMapping("/bgtcd/insertAddRow")
	public void insertAddRow(@RequestBody BgtCD bgtcd,String coCd) {
		service.insertAddRow(bgtcd);
//		return null; return BgtCD
	}
	
	/*insert end*/
	
	
	/*delete start */
	@DeleteMapping("/bgtcd/deleteRow")
	public int deleteRow(@RequestParam String bgtCd ,String coCd) {
		return service.deleteRow(bgtCd,coCd);
	}
	
}