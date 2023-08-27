package kr.co.acctmgmt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/bgtcd/{coCd}")
	public List<BgtCD> getSearchData(@PathVariable("coCd") String coCd,String gisu, String groupCd, String keyword){
		return service.getSearchData(coCd,gisu,groupCd,keyword);
	}
	
	@PostMapping("/bgtcd")
	public void insertAddRow(@RequestBody BgtCD bgtcd) {
		System.out.println("controller - insertAddRow");
		service.insertAddRow(bgtcd);
	}
	

	


	@GetMapping("/bgtcd/getbgtcdlikesearch")
	public List<BgtCD> getBgtCdLikeSearch(@RequestParam String coCd , String keyword){
		System.out.println("controller - getbgtcdlike search");
		return service.getBgtCdLikeSearch(coCd,keyword);
	}
	
	
	@PutMapping("/bgtcd/bgtnm/{coCd}/{bgtCd}") 
	public void updateBgtNm(@PathVariable("coCd") String coCd, @PathVariable("bgtCd") String bgtCd, @RequestBody BgtCD bgtCD) {

		bgtCD.setCoCd(coCd);
		bgtCD.setBgtCd(bgtCd);
		service.updateBgtNm(bgtCD);
	}
	
	@DeleteMapping("/bgtcd/{coCd}/{bgtCd}") 
	public int deleteRow(@PathVariable("bgtCd") String bgtCd, @PathVariable("coCd") String coCd) {
		System.out.println("controller - deleteRow");
		return service.deleteRow(bgtCd,coCd);
	}
	
	
	/*---------------------------------detailinfo---*/
	@GetMapping("/bgtcd/{coCd}/{bgtCd}")//getDetailInfo
	public ResponseEntity<List<BgtCD>> getDetailInfo(@PathVariable("coCd") String coCd,@PathVariable("bgtCd") String bgtCd) {
		System.out.println("controller - getdetailinfo");
		List<BgtCD> list = service.getDetailInfo(bgtCd);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@PutMapping("/bgtcd/{coCd}/{bgtCd}")//updateDetailInfo
	public void updateDetailInfo(@PathVariable("coCd") String coCd,@PathVariable("bgtCd") String bgtCd, @RequestBody BgtCD updateData) {
		System.out.println("controller - updatedetailinfo");
		System.out.println(updateData.toString());
		updateData.setCoCd(coCd);
		updateData.setBgtCd(bgtCd);
		service.updateDetailInfo(updateData);
	}
	
	/*---------------------------------bgtcdterm---*/
	@GetMapping("/dialog/bgtcdterm/{coCd}")
	public List<BgtCDTermDTO> getBgtCDTerm(@PathVariable("coCd") String coCd){
		System.out.println("controller - getbgtcdterm");
		System.out.println(coCd);
		List<BgtCDTermDTO> list = service.getBgtCDTerm(coCd);
		return list;
	}
	@PutMapping("/dialog/bgtcdterm/{coCd}")
	public List<BgtCDTermDTO> updateBgtCDTerm(@PathVariable("coCd") String coCd, @RequestBody List<BgtCDTermDTO> dataList) {
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

	@GetMapping("/bgtcd/checktopdata")
	public BgtCD checkTopData(@RequestParam String coCd, String gisu,String tDataPath,String keyword) {
		return service.checkTopData(coCd,gisu,tDataPath,keyword);
	}

	
	
	
	
}