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

	/*議고쉶 start*/
	// http://localhost:8080/acctmgmt/bgt/sbgtcd/getGridData?groupcd=GROUP1
	@GetMapping("/bgt/bgtcd/getGridData") // groupcd 
	public List<BgtCD> getGridData(@RequestParam String coCd ,String gisu,String groupcd) {
		List<BgtCD> list = service.getBGTCDData(coCd,gisu,groupcd);
		System.out.println(list.toString());
		return list;
	}

	@GetMapping("/bgt/bgtcd/getDetailInfo")
	public ResponseEntity<List<BgtCD>> getDetailInfo(@RequestParam String bgtCd) {
		List<BgtCD> list = service.getDetailInfo(bgtCd);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("/bgt/bgtcd/getBgtCDTerm")
	public List<BgtCDTermDTO> getBgtCDTerm(@RequestParam String CO_CD){
		List<BgtCDTermDTO> list = service.getBgtCDTerm(CO_CD);
		return list;
	}
	@GetMapping("/bgt/bgtcd/getPath")
	public String getPath(@RequestParam String bgtCd) {
		return service.getPath(bgtCd);
	}
	@GetMapping("/bgt/bgtcd/getBgtGrData")
	public List<BgtGr> getBgtGrData(@RequestParam String coCd) {
		List<BgtGr> bgtGr = service.getBgtGrData(coCd);
		System.out.println(bgtGr.toString());
		return bgtGr;
	}
	@GetMapping("/bgt/bgtcd/getBgtCDdialog")
	public List<BgtCD> getBgtCDdialog(@RequestParam String coCd){
		return service.getBgtCDdialog(coCd);
	}
	@GetMapping("bgt/bgtcd/getBgtCdLikeSearch")
	public List<BgtCD> getBgtCdLikeSearch(@RequestParam String coCd , String keyword){
		System.out.println(coCd +" / "+ keyword);
		return service.getBgtCdLikeSearch(coCd,keyword);
		 
	}
	@GetMapping("bgt/bgtcd/getSearchData")
	public List<BgtCD> getSearchData(@RequestParam String coCd,String gisu, String groupCd, String keyword){
		return service.getSearchData(coCd,gisu,groupCd,keyword);
		
	}
	@GetMapping("bgt/bgtcd/getinitGisuList")
	public List<Gisu> getinitGisuList(@RequestParam String coCd){
		return service.getinitGisuList(coCd);
	}
	@GetMapping("bgt/bgtcd/getinitBgtGrSearch")
	public List<BgtGr> getinitBgtGrSearch(@RequestParam String coCd){
		return service.getinitBgtGrSearch(coCd);
	}
	
	
	@GetMapping("bgt/bgtcd/getBgtGrSearch")
	public List<BgtGr> getBgtGrSearch(@RequestParam String coCd, String keyword){
		
		return service.getBgtGrSearch(coCd,keyword);
	}
 
	@GetMapping("/bgt/bgtcd/getDefNmFromBGTCD_TERM")
	public String getDefNmFromBGTCD_TERM(@RequestParam String coCd, String divFg) {
		int a = Integer.parseInt(divFg);
		a= a+1;
		String b = Integer.toString(a);
		b =service.getDefNmFromBGTCD_TERM(coCd,b);
		return b;
	}
	@GetMapping("/bgt/bgtCd/updateBgtNm")
	public void updateBgtNm(@RequestParam String coCd, String bgtCd,String bgtNm) {
		System.out.println("안녕 ");
		service.updateBgtNm(coCd,bgtCd,bgtNm);
	}
	/*select  end*/
	
	
	/*update start */
	@PutMapping("/bgt/bgtcd/updateDetailInfo")
	public void updateDetailInfo(@RequestBody BgtCD updateData) {//@RequestParam SBGTCDDomain updateData
		System.out.println(updateData.toString());
		service.updateDetailInfo(updateData);
	}
	@PutMapping("/bgt/bgtcd/updateBgtCDTerm")
	public List<BgtCDTermDTO> updateBgtCDTerm(@RequestBody List<BgtCDTermDTO> dataList) {
		return service.updateBgtCDTerm(dataList);
	}
	
	@GetMapping("/bgt/bgtcd/getAddRowData") //[230808]make new AddRow data 
	public BgtCD getAddRowData(@RequestParam String bgtCd , String coCd) {
		System.out.println("getAddRowData");
		System.out.println("bgtcd : "+bgtCd);
		System.out.println("coCd : "+coCd);
		
		BgtCD info =  service.addRowData(bgtCd , coCd);
		return info;
	}
	@PutMapping("/bgt/bgtcd/insertBgtGr")
	public void insertBgtGr(@RequestBody List<BgtGr> dataList) {
		service.insertBgtGr(dataList);
	}
	
	@GetMapping("/bgt/bgtcd/checkTopData")
	public BgtCD checkTopData(@RequestParam String coCd, String gisu,String tDataPath,String keyword) {
		System.out.println("start");
		return service.checkTopData(coCd,gisu,tDataPath,keyword);
	}
	
	
	/*select end */
	/*insert start */
	@PostMapping("/bgt/bgtcd/insertAddRow")
	public BgtCD insertAddRow(@RequestBody BgtCD bgtcd) {
		System.out.println(bgtcd.getGroupCd()); 
		service.insertAddRow(bgtcd);
		return null;
	}
	
	/*insert end*/
	
	
	/*delete start */
	@DeleteMapping("/bgt/bgtcd/deleteRow")
	public int deleteRow(@RequestParam String bgtCd) {
		return service.deleteRow(bgtCd);
	}
	
}