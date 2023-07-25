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
        System.out.println("sign����? : " + signUpData.toString());
        System.out.println("password @@@@: " + password);

        // �н����� ��ȣȭ
        String encodedPassword = passwordEncoder.encode(password);
        signUpData.setEmpPw(encodedPassword);

        // ȸ������ ����
        Employee employee = employeeService.getEmployee(id);
        if (employee != null) {
            // �̹� �����ϴ� ���̵��� ���
        	System.out.println("ȸ������ �����Դϴ�!!!!!!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("�ߺ��� ���̵��Դϴ�.");
        } else {
            // ȸ������ ����
        	System.out.println("ȸ������ �����Դϴ�!!!!!!");
            employeeService.insertEmployee(signUpData);
            String response = "{\"email\":\"" + id + "\",\"password\":\"" + password + "\"}";
            return ResponseEntity.ok(response);
        }
	}
}
