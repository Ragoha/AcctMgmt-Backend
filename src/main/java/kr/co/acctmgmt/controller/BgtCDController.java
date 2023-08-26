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
	/*-------------------------------bgtcd-------------*/
//	@GetMapping("/bgtcd") 
//	public List<BgtCD> getGridData(@RequestParam String coCd ,String gisu,String groupCd) {
//		System.out.println("controller -getGridData");
//		List<BgtCD> list = service.getBGTCDData(coCd,gisu,groupCd);
//		return list;
//	}
	@GetMapping("/bgtcd")
	public List<BgtCD> getSearchData(@RequestParam String coCd,String gisu, String groupCd, String keyword){
		return service.getSearchData(coCd,gisu,groupCd,keyword);
	}
	@DeleteMapping("/bgtcd") 
	public int deleteRow(@RequestParam String bgtCd ,String coCd) {
		System.out.println("controller - deleteRow");
		return service.deleteRow(bgtCd,coCd);
	}
	@PostMapping("/bgtcd")
	public void insertAddRow(@RequestBody BgtCD bgtcd,String coCd) {
		System.out.println("controller - insertAddRow");
		service.insertAddRow(bgtcd);
	}
	@PutMapping("/bgtcd") 
	public void updateBgtNm(@RequestBody BgtCD bgtcd) {
		System.out.println("controller - updateBgtNm");
		String coCd  = bgtcd.getCoCd();
		String bgtCd = bgtcd.getBgtCd();
		String bgtNm = bgtcd.getBgtNm();
		System.out.println(bgtcd.toString());
		service.updateBgtNm(bgtcd);
	}
	@GetMapping("/bgtcd/getbgtcdlikesearch")
	public List<BgtCD> getBgtCdLikeSearch(@RequestParam String coCd , String keyword){
		System.out.println("controller - getbgtcdlike search");
		return service.getBgtCdLikeSearch(coCd,keyword);
	}
	
	
	
	/*---------------------------------detailinfo---*/
	@GetMapping("/bgtcd/detailinfo")//getDetailInfo
	public ResponseEntity<List<BgtCD>> getDetailInfo(@RequestParam String bgtCd) {
		System.out.println("controller - getdetailinfo");
		List<BgtCD> list = service.getDetailInfo(bgtCd);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@PutMapping("/bgtcd/detailinfo")//updateDetailInfo
	public void updateDetailInfo(@RequestBody BgtCD updateData) {
		System.out.println("controller - updatedetailinfo");
		System.out.println(updateData.toString());
		service.updateDetailInfo(updateData);
	}
	
	/*---------------------------------bgtcdterm---*/
	@GetMapping("/bgtcd/bgtcdterm")
	public List<BgtCDTermDTO> getBgtCDTerm(@RequestParam String CO_CD){
		System.out.println("controller - getbgtcdterm");
		List<BgtCDTermDTO> list = service.getBgtCDTerm(CO_CD);
		return list;
	}
	@PutMapping("/bgtcd/bgtcdterm")
	public List<BgtCDTermDTO> updateBgtCDTerm(@RequestBody List<BgtCDTermDTO> dataList) {
		return service.updateBgtCDTerm(dataList);
	}
	@GetMapping("/bgtcd/getdefnmfrombgtcdterm")
	public String getDefNmFromBGTCD_TERM(@RequestParam String coCd, String divFg) {
		int a = Integer.parseInt(divFg);
		a= a+1;
		String b = Integer.toString(a);
		b =service.getDefNmFromBGTCD_TERM(coCd,b);
		return b;
	}
	
	
	/*---------------------------bgtgr---*/
//	@GetMapping("/bgtcd/bgtgr")
//	public List<BgtGr> getBgtGrData(@RequestParam String coCd) {
//		System.out.println("controller - getbgtgrdata");
//		List<BgtGr> bgtGr = service.getBgtGrData(coCd);
//		return bgtGr;
//	}
//	@PutMapping("/bgtcd/bgtgr")
//	public void insertBgtGr(@RequestBody List<BgtGr> dataList) {
//		service.insertBgtGr(dataList);
//	}
//	
	@GetMapping("/bgtcd/getinitbgtgrsearch")
	public List<BgtGr> getinitBgtGrSearch(@RequestParam String coCd, String keyword){
		return service.getinitBgtGrSearch(coCd,keyword);
	}
	@GetMapping("/bgtcd/getbgtgrsearch")
	public List<BgtGr> getBgtGrSearch(@RequestParam String coCd, String keyword){
		return service.getBgtGrSearch(coCd, keyword);
	}
	@GetMapping("/bgtcd/getbgtgrsearchkeyworddata")
	public List<BgtGr> getbgtGrSearchKeywordData(@RequestParam String coCd, String keyword) {
		return service.getbgtGrSearchKeywordData(coCd,keyword);
	}
//	
	
	/*-------------------common----*/
	@GetMapping("/bgtcd/getpath")
	public String getPath(@RequestParam String bgtCd) {
		System.out.println("controller - getpath");
		return service.getPath(bgtCd);
	}
	
	@GetMapping("/bgtcd/bgtcddialog")
	public List<BgtCD> getBgtCDdialog(@RequestParam String coCd,String keyword){
		System.out.println("controller - getbgtcddialog");
		return service.getBgtCDdialog(coCd, keyword);
	}
	@GetMapping("/bgtcd/getaddrowdata") //[230808]make new AddRow data 
	public BgtCD getAddRowData(@RequestParam String bgtCd , String coCd,String gisu, String groupCd) {
		String[] str = groupCd.split("\\.");
		groupCd = str[0];
		BgtCD info =  service.addRowData(bgtCd , coCd, gisu, groupCd);
		return info;
	}
	@GetMapping("/bgtcd/gisu")//getinitgisulist
	public List<Gisu> getinitGisuList(@RequestParam String coCd){
		return service.getinitGisuList(coCd);
	}
	@GetMapping("/bgtcd/checktopdata")
	public BgtCD checkTopData(@RequestParam String coCd, String gisu,String tDataPath,String keyword) {
		return service.checkTopData(coCd,gisu,tDataPath,keyword);
	}

	
	
	
	
}