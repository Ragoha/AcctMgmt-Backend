package kr.co.acctmgmt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.SBGTCDDomain;
import kr.co.acctmgmt.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	private final UserService userService;
	
	@RequestMapping("/time")
	public String getTime() {
		System.out.println("Controller�� time �޼ҵ� ");
		return userService.getTime();
	}
	//DataGrid�� ������ �ִ� �޼ҵ� 
	@RequestMapping("/SBGTCD")
	public List<SBGTCDDomain> getDataGridData() {
		System.out.println(">>��Ʈ�ѷ��� getDataGridData<<");
		List<SBGTCDDomain> sbgtcd= userService.getDataGridData();
		String a = sbgtcd.toString();
		System.out.println(">>>>>>>>>>>getDataGridData���� ������" + a);
		return sbgtcd ;
	}
	
}

























