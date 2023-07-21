package kr.co.acctmgmt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SysCfgController {
	
	@PostMapping("/config/{option}/{optionValue}")
    public ResponseEntity<String> configCheck(@PathVariable("option") String option, @PathVariable("optionValue") String optionValue
    		) {
		System.out.println("�ɼ� �� : " + option);
        System.out.println("���� �� : " + optionValue);
        
        // option ������ �̿��Ͽ� �ش� ������ ���� ó���� �����մϴ�.
        // ó�� �۾��� �����ϰ� ����� ResponseEntity�� ��Ƽ� ��ȯ�մϴ�.
        return ResponseEntity.ok("�ɼ� �� : " + option + ", ���� �� : " + optionValue);
    }
}

