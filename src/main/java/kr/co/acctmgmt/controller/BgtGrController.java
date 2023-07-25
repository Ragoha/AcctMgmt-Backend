package kr.co.acctmgmt.controller;

import org.springframework.stereotype.Controller;

import kr.co.acctmgmt.service.BgtGrService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BgtGrController {
	
	private final BgtGrService bgtGrService;

}
