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
import kr.co.acctmgmt.dto.BgtCDTermDTO;
import kr.co.acctmgmt.dto.BgtICFDTO;
import kr.co.acctmgmt.service.BgtCDService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BgtCDController {

	private final BgtCDService service;

	/*��ȸ start*/
	// http://localhost:8080/acctmgmt/bgt/sbgtcd/getGridData?groupcd=GROUP1
	@GetMapping("/bgt/bgtcd/getGridData") // groupcd 
	public List<BgtCD> getGridData(@RequestParam String coCd) {
		System.out.println("groupcd�� ã�ƾ���");
		List<BgtCD> list = service.getBGTCDData(coCd);
		System.out.println("���Ʒ� ������ defNmã�ƺ���");
		System.out.println(list.toString());
		return list;
	}

	@GetMapping("/bgt/bgtcd/getDetailInfo")
	public ResponseEntity<List<BgtCD>> getDetailInfo(@RequestParam String bgtCd) {
		System.out.println("getDetailINfo �Դϴ� : " + bgtCd);
		List<BgtCD> list = service.getDetailInfo(bgtCd);
		System.out.println("�Ʒ��� contorller���� ������ ���� ��");
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
		System.out.println("����� BgtGr Controller");
		List<BgtGr> bgtGr = service.getBgtGrData(coCd);
		System.out.println(bgtGr.toString());
		return bgtGr;
	}
	/*��ȸend*/
	
	
	/*������Ʈ start */
	@PutMapping("/bgt/bgtcd/updateDetailInfo")
	public void updateDetailInfo(@RequestBody BgtCD updateData) {//@RequestParam SBGTCDDomain updateData
		System.out.println("��������������");
		System.out.println(updateData.toString());
		service.updateDetailInfo(updateData);
	}
	@PutMapping("/bgt/bgtcd/updateBgtCDTerm")
	public List<BgtCDTermDTO> updateBgtCDTerm(@RequestBody List<BgtCDTermDTO> dataList) {//2�߹迭�� ������ front���� params : {data:data} �κ����°� �ƴ϶� ��� �ڿ� �ٷ� axios.pust(/path  ,  data) �� ������
		
		System.out.println("���� ��Ʈ�ѷ� updateBgtCDTerm");
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
	/*������Ʈ end */
	/*���� start */
	@PostMapping("/bgt/bgtcd/insertAddRow")
	public BgtCD insertAddRow(@RequestBody BgtCD bgtcd) {
		System.out.println("===insertAddRow start ===");
		service.insertAddRow(bgtcd);
		System.out.println("===insertAddRow end ===");
		return null;
	}
	
	/*���� end*/
	
	
	/*���� start */
	@DeleteMapping("/bgt/bgtcd/deleteRow")
	public int deleteRow(@RequestParam String bgtCd) {
		
		System.out.println("���Ⱑ ����Ʈ�� ~"+bgtCd+"<<<<");
		System.out.println();
		return service.deleteRow(bgtCd);
	}
	
}