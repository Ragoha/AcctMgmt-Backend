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
	public List<BgtCD> getGridData(@RequestParam String coCd ,String groupcd) {
		System.out.println("groupcd瑜� 李얠븘�빞�븿"+groupcd);
		List<BgtCD> list = service.getBGTCDData(coCd,groupcd);
		System.out.println("�뿬�븘�옒 媛믪뿉�꽌 defNm李얠븘蹂댁옄");
		System.out.println(list.toString());
		return list;
	}

	@GetMapping("/bgt/bgtcd/getDetailInfo")
	public ResponseEntity<List<BgtCD>> getDetailInfo(@RequestParam String bgtCd) {
		System.out.println("getDetailINfo �엯�땲�떎 : " + bgtCd);
		List<BgtCD> list = service.getDetailInfo(bgtCd);
		System.out.println("�븘�옒媛� contorller�뿉�꽌 蹂대궡湲� 吏곸쟾 媛�");
		System.out.println(list.toString());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("/bgt/bgtcd/getBgtCDTerm")
	public List<BgtCDTermDTO> getBgtCDTerm(@RequestParam String CO_CD){
		System.out.println("****Controller - getBgtCDTerm****");
		List<BgtCDTermDTO> list = service.getBgtCDTerm(CO_CD);
		System.out.println("****Controller - getBgtCDTerm END ****");
		return list;
	}
	@GetMapping("/bgt/bgtcd/getPath")
	public String getPath(@RequestParam String bgtCd) {
		System.out.println("controller: getPath");
		return service.getPath(bgtCd);
	}
	@GetMapping("/bgt/bgtcd/getBgtGrData")
	public List<BgtGr> getBgtGrData(@RequestParam String coCd) {
		System.out.println("�뿬湲곕뒗 BgtGr Controller");
		List<BgtGr> bgtGr = service.getBgtGrData(coCd);
		System.out.println(bgtGr.toString());
		return bgtGr;
	}
	@GetMapping("/bgt/bgtcd/getBgtCDdialog")
	public List<BgtCD> getBgtCDdialog(@RequestParam String coCd){
		System.out.println("===getBgtCDdialog===");
		return service.getBgtCDdialog(coCd);
	}
	@GetMapping("bgt/bgtcd/getBgtCdLikeSearch")
	public List<BgtCD> getBgtCdLikeSearch(@RequestParam String coCd , String keyword){
		System.out.println(coCd +" / "+ keyword);
		return service.getBgtCdLikeSearch(coCd,keyword);
		 
	}
	@GetMapping("bgt/bgtcd/getSearchData")
	public List<BgtCD> getSearchData(@RequestParam String coCd,String gisu, String groupCd, String keyword){
		System.out.println("==getSearchData.controller==");
		return service.getSearchData(coCd,gisu,groupCd,keyword);
		
	}
	@GetMapping("bgt/bgtcd/getinitGisuList")
	public List<Gisu> getinitGisuList(@RequestParam String coCd){
		System.out.println("===getinitGisuListgetinitGisuListgetinitGisuListgetinitGisuList===");
		return service.getinitGisuList(coCd);
	}
	@GetMapping("bgt/bgtcd/getinitBgtGrSearch")
	public List<BgtGr> getinitBgtGrSearch(@RequestParam String coCd){
		return service.getinitBgtGrSearch(coCd);
	}
	
	
	@GetMapping("bgt/bgtcd/getBgtGrSearch")
	public List<BgtGr> getBgtGrSearch(@RequestParam String coCd, String keyword){
		System.out.println("==>getBgtGrSearch");
		
		return service.getBgtGrSearch(coCd,keyword);
	}
 
	/*select  end*/
	
	
	/*�뾽�뜲�씠�듃 start */
	@PutMapping("/bgt/bgtcd/updateDetailInfo")
	public void updateDetailInfo(@RequestBody BgtCD updateData) {//@RequestParam SBGTCDDomain updateData
		System.out.println("updateDetailInfo");
		System.out.println(updateData.toString());
		service.updateDetailInfo(updateData);
	}
	@PutMapping("/bgt/bgtcd/updateBgtCDTerm")
	public List<BgtCDTermDTO> updateBgtCDTerm(@RequestBody List<BgtCDTermDTO> dataList) {//2以묐같�뿴�쓣 諛쏆쓣�븣 front�뿉�꽑 params : {data:data} 濡쒕낫�궡�뒗寃� �븘�땲�씪 寃쎈줈 �뮘�뿉 諛붾줈 axios.pust(/path  ,  data) 濡� 蹂대궦�떎
		
		System.out.println("updateBgtCDTerm");
		System.out.println(dataList.toString());
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
	/*select end */
	/*insert start */
	@PostMapping("/bgt/bgtcd/insertAddRow")
	public BgtCD insertAddRow(@RequestBody BgtCD bgtcd) {
		System.out.println("===insertAddRow start ===");
		System.out.println(bgtcd.getGroupCd()); 
		service.insertAddRow(bgtcd);
		System.out.println("===insertAddRow end ===");
		return null;
	}
	
	/*insert end*/
	
	
	/*delete start */
	@DeleteMapping("/bgt/bgtcd/deleteRow")
	public int deleteRow(@RequestParam String bgtCd) {
		
		System.out.println("�뿬湲곌� �뵜由ы듃�빞 ~"+bgtCd+"<<<<");
		System.out.println();
		return service.deleteRow(bgtCd);
	}
	
}