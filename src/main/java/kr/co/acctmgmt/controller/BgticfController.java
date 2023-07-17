package kr.co.acctmgmt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.dto.BgticfDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BgticfController {

	@PostMapping("/budget")
//	public void getBGT(@RequestBody Budget budget) {
	public ResponseEntity<List<BgticfDTO>> getBGT(@RequestBody Map<String, String> budget) {
		
		System.out.println(budget.toString());
		
		List<BgticfDTO> bgtList = new ArrayList<>();

        // BgtDTO ��ü ���� �� ����Ʈ�� �߰�
        BgticfDTO bgt1 = new BgticfDTO();
        bgt1.setId("1");
        bgt1.setBgtCd("BGT001");
        bgt1.setBgtFg("A");
        bgt1.setBgtNm("����1");
        bgt1.setAmount(1000000L);
        bgtList.add(bgt1);

        BgticfDTO bgt2 = new BgticfDTO();
        bgt2.setId("2");
        bgt2.setBgtCd("BGT002");
        bgt2.setBgtFg("B");
        bgt2.setBgtNm("����2");
        bgt2.setAmount(2000000L);
        bgtList.add(bgt2);

        BgticfDTO bgt3 = new BgticfDTO();
        bgt3.setId("3");
        bgt3.setBgtCd("BGT003");
        bgt3.setBgtFg("C");
        bgt3.setBgtNm("����3");
        bgt3.setAmount(3000000L);
        bgtList.add(bgt3);

        BgticfDTO bgt4 = new BgticfDTO();
        bgt4.setId("4");
        bgt4.setBgtCd("BGT004");
        bgt4.setBgtFg("D");
        bgt4.setBgtNm("����4");
        bgt4.setAmount(4000000L);
        bgtList.add(bgt4);

        BgticfDTO bgt5 = new BgticfDTO();
        bgt5.setId("5");
        bgt5.setBgtCd("BGT005");
        bgt5.setBgtFg("E");
        bgt5.setBgtNm("����5");
        bgt5.setAmount(5000000L);
        bgtList.add(bgt5);
        
        System.out.println(bgtList.toString());
		
		return new ResponseEntity<List<BgticfDTO>>(bgtList, HttpStatus.OK); 
	}
}