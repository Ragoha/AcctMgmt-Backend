package kr.co.acctmgmt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Employee;
import kr.co.acctmgmt.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SignUpController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/signUp")
	public ResponseEntity<String> sign(@RequestBody Map<String, String> signData) {
		Employee employee = Employee.builder().coCd(signData.get("company")).empId(signData.get("id"))
				.empPs(signData.get("password")).empEmail(signData.get("email")).empSx(signData.get("gender"))
				.empTel(signData.get("phone")).empName(signData.get("name")).empOd(signData.get("position")).build();

		Employee employee2 = employeeService.getEmployee(signData.get("id"));

		if (employee2 != null) {
		    // 중복된 아이디인 경우
		    System.out.println("중복! 중복!");
		    return ResponseEntity.status(HttpStatus.CONFLICT).body("중복된 아이디입니다.");
		  } else {
		    System.out.println("회원가입 성공");
		    employeeService.insertEmployee(employee);
		    String response = "{\"email\":\"" + signData.get("id") + "\",\"password\":\"" + signData.get("password") + "\"}";
		    return ResponseEntity.ok(response);
		  }
	}
}
