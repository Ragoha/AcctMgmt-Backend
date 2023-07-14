package kr.co.acctmgmt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Employee;
import kr.co.acctmgmt.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
		String email = loginData.get("email");
		String password = loginData.get("password");
		System.out.println(email);
		System.out.println(password);
		
		Employee employee = employeeService.getEmployee(email);
//		
		if(employee.getDId().equals(null)) {
			System.out.println("등록되지 않은 아이디 입니다.");
		}
		else
			System.out.println(employee.getDId()+" : 로그인 성공!!");

		//받은 데이터를 다시 JSON 형식으로 반환
		String response = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}";
		
		return ResponseEntity.ok(response);
	}
	@GetMapping("/emp/idcheck/{checkId}")
	public ResponseEntity<String> idCheck(@PathVariable String checkId){
		System.out.println(checkId);
		String id = checkId;
		Employee employee = employeeService.getEmployee(id);
		

		if(employee.getDId().equals(id))
		System.out.println("중복! 중복!");
		else 
			System.out.println("중복 된 아이디가 아닙니다.");
		
		
		String response = "{\"id\" : \"" + checkId + "\")}";
		return ResponseEntity.ok(response);
	}
}
