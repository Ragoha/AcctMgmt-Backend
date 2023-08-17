package kr.co.acctmgmt.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Co;
import kr.co.acctmgmt.domain.SysCfg;
import kr.co.acctmgmt.service.CoService;
import kr.co.acctmgmt.service.SysCfgService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SysCfgController {
	private final SysCfgService sysCfg;
	private final CoService coService;
	
	@PostMapping("/config/{option}/{optionValue}/{settingvalue}/{coCd}")
	public ResponseEntity<String> configCheck(@PathVariable("option") String option,
			@PathVariable("optionValue") String optionValue, @PathVariable("settingvalue") String settingvalue, @PathVariable("coCd") int coCd) {
		System.out.println("option: " + option);
		System.out.println("optionValue : " + optionValue);
		System.out.println("settingValue:" + settingvalue);
		System.out.println("coCd : " + coCd);
		
		SysCfg sys = sysCfg.getConfig(coCd, option);
		sys.setSysYn(optionValue);
		sys.setCfgvalue(settingvalue);
		Date now = new Date();
		sys.setModifyDt(now);
		sys.setCoCd(coCd);
		
		
		sysCfg.updateConfig(sys);

		System.out.println("##############################################");
		System.out.println(sys.toString());
		System.out.println("##############################################");

		// option ������ �̿��Ͽ� �ش� ������ ���� ó���� �����մϴ�.
		// ó�� �۾��� �����ϰ� ����� ResponseEntity�� ��Ƽ� ��ȯ�մϴ�.
		return ResponseEntity.ok("ȸ���ڵ� : "+coCd+"�ɼ� �� : " + option + ", ���� �� : " + optionValue);
	}

	@PostMapping("/config/{coCd}")
	public ResponseEntity<String> config(@PathVariable("coCd") int coCd) {
		System.out.println("ȸ���ڵ��� �޾Ҵ�? : " + coCd);
		List<SysCfg> sys = sysCfg.getConfigList(coCd);
		System.out.println("�� ã�Ҵ�?" + sys);
		
		Co co = coService.getCo(coCd);
		System.out.println("ȸ��� �������:"+co.getCoNm());
		
		
		return ResponseEntity.ok(co.getCoNm());
		
	}

	@GetMapping("/configdate/{coCd}")
	public ResponseEntity<List> configData(@PathVariable("coCd") int coCd){
		
		System.out.println("���� �� �������");
		List<SysCfg> sys = sysCfg.getConfigList(coCd);
		System.out.println(sys.toString());
		return ResponseEntity.ok(sys);
	}
}