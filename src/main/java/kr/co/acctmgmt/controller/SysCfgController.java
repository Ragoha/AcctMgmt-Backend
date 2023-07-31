package kr.co.acctmgmt.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.SysCfg;
import kr.co.acctmgmt.service.SysCfgService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SysCfgController {
	private final SysCfgService sysCfg;

	@PostMapping("/config/{option}/{optionValue}/{coCd}")
	public ResponseEntity<String> configCheck(@PathVariable("option") String option,
			@PathVariable("optionValue") String optionValue, @PathVariable("coCd") int coCd) {
		System.out.println("�ɼ� �� : " + option);
		System.out.println("���� �� : " + optionValue);
		System.out.println("ȸ���ڵ� : " + coCd);

		SysCfg sys = sysCfg.getConfig(coCd, option);
		sys.setSysYn(optionValue);
		Date now = new Date();
		sys.setModifyDt(now);

		sysCfg.updateConfig(sys);

		System.out.println("##############################################");
		System.out.println(sys.toString());
		System.out.println("##############################################");

		// option ������ �̿��Ͽ� �ش� ������ ���� ó���� �����մϴ�.
		// ó�� �۾��� �����ϰ� ����� ResponseEntity�� ��Ƽ� ��ȯ�մϴ�.
		return ResponseEntity.ok("�ɼ� �� : " + option + ", ���� �� : " + optionValue);
	}

	@PostMapping("/config/{coCd}")
	public ResponseEntity<String> config(@PathVariable("coCd") int coCd) {
		System.out.println("ȸ���ڵ��� �޾Ҵ�? : " + coCd);
		List<SysCfg> sys = sysCfg.getConfigList(coCd);
		System.out.println("�� ã�Ҵ�?" + sys);
		return null;
		
	}

}