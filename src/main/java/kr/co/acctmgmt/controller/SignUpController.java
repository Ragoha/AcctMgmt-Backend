package kr.co.acctmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final EmployeeService employeeService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpController(EmployeeService employeeService, PasswordEncoder passwordEncoder) {
        this.employeeService = employeeService;
        this.passwordEncoder = passwordEncoder;
    }
	@PostMapping("/signUp")
	public ResponseEntity<String> sign(@RequestBody Employee signUpData) {

		String id = signUpData.getEmpId();
        String password = signUpData.getEmpPw();
        System.out.println("sign값은? : " + signUpData.toString());
        System.out.println("password @@@@: " + password);

        // 패스워드 암호화
        String encodedPassword = passwordEncoder.encode(password);
        signUpData.setEmpPw(encodedPassword);

        // 회원가입 로직
        Employee employee = employeeService.getEmployee(id);
        if (employee != null) {
            // 이미 존재하는 아이디인 경우
        	System.out.println("회원가입 실패입니다!!!!!!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("중복된 아이디입니다.");
        } else {
            // 회원가입 성공
        	System.out.println("회원가입 성공입니다!!!!!!");
            employeeService.insertEmployee(signUpData);
            String response = "{\"email\":\"" + id + "\",\"password\":\"" + password + "\"}";
            return ResponseEntity.ok(response);
        }
	}
}
