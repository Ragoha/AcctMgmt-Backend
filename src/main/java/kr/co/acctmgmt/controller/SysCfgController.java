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
		System.out.println("옵션 명 : " + option);
		System.out.println("설정 값 : " + optionValue);
		System.out.println("설정 값 명:" + settingvalue);
		System.out.println("회사코드 : " + coCd);
		
		SysCfg sys = sysCfg.getConfig(coCd, option);
		sys.setSysYn(optionValue);
		sys.setCfgvalue(settingvalue);
		Date now = new Date();
		sys.setModifyDt(now);
		
		
		sysCfg.updateConfig(sys);

		System.out.println("##############################################");
		System.out.println(sys.toString());
		System.out.println("##############################################");

		// option 변수를 이용하여 해당 설정에 대한 처리를 수행합니다.
		// 처리 작업을 수행하고 결과를 ResponseEntity에 담아서 반환합니다.
		return ResponseEntity.ok("회사코드 : "+coCd+"옵션 명 : " + option + ", 설정 값 : " + optionValue);
	}

	@PostMapping("/config/{coCd}")
	public ResponseEntity<String> config(@PathVariable("coCd") int coCd) {
		System.out.println("회사코드잘 받았니? : " + coCd);
		List<SysCfg> sys = sysCfg.getConfigList(coCd);
		System.out.println("잘 찾았니?" + sys);
		
		Co co = coService.getCo(coCd);
		System.out.println("회사명 갖고오기:"+co.getCoNm());
		
		
		return ResponseEntity.ok(co.getCoNm());
		
	}

	@GetMapping("/configdate/{coCd}")
	public ResponseEntity<List> configData(@PathVariable("coCd") int coCd){
		
		System.out.println("설정 값 갖고오기");
		List<SysCfg> sys = sysCfg.getConfigList(coCd);
		System.out.println(sys.toString());
		return ResponseEntity.ok(sys);
	}
}