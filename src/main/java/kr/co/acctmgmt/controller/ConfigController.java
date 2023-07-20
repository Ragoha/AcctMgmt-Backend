package kr.co.acctmgmt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ConfigController {
	
	@PostMapping("/config/{option}/{optionValue}")
    public ResponseEntity<String> configCheck(@PathVariable("option") String option, @PathVariable("optionValue") String optionValue
    		) {
		System.out.println("옵션 명 : " + option);
        System.out.println("설정 값 : " + optionValue);
//        HttpSession session = request.getSession();
//        
//            System.out.println(session.getAttribute("employee").toString());
////        
        
        // option 변수를 이용하여 해당 설정에 대한 처리를 수행합니다.
        // 처리 작업을 수행하고 결과를 ResponseEntity에 담아서 반환합니다.
        return ResponseEntity.ok("옵션 명 : " + option + ", 설정 값 : " + optionValue);
    }
}

