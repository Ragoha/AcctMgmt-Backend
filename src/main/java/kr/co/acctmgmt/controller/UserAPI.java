package kr.co.acctmgmt.controller;

import java.util.Collections;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kr.co.acctmgmt.config.jwt.ExpiredRefreshTokenService;
import kr.co.acctmgmt.config.jwt.JwtUtil;
import kr.co.acctmgmt.domain.Employee;
import kr.co.acctmgmt.dto.EmployeeDTO;
import kr.co.acctmgmt.dto.UserLoginReq;
import kr.co.acctmgmt.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserAPI {

	private final EmployeeService userService;
	private final PasswordEncoder passwordEncoder;
	private final ExpiredRefreshTokenService expiredRefreshTokenService;
	private final JwtUtil jwtUtil;

	@PostMapping("/join")
	public void join(@RequestBody Employee user) {
		
		System.out.println("����");
		System.out.println(user.toString());
		userService.save(Employee.builder().empId(user.getEmpId()).empPw(passwordEncoder.encode(user.getEmpPw()))
				.empName(user.getEmpName()).empTel(user.getEmpTel()).empEmail(user.getEmpEmail()).empSx(user.getEmpSx())
				.coCd(user.getCoCd()).empOd(user.getEmpOd()).empAuth("ROLE_USER").build());
	}

	@GetMapping("/emp/idcheck/{checkId}")
	public ResponseEntity<String> idCheck(@PathVariable String checkId) {
		System.out.println(checkId);
		String id = checkId;
		try {
		    Employee employee = userService.getEmployee(id);
		    if (employee == null) {
		    	System.out.println("�ߺ� �� ���̵� �ƴմϴ�.");
			    return new ResponseEntity<String>("savc", HttpStatus.OK);
		    } else {
		    	 System.out.println("�ߺ�! �ߺ�!");
		    }
		} catch (NullPointerException e) {
		    // NullPointerException ���� �߻� �� ó�� ����
		    System.out.println("NullPointerException�� �߻��߽��ϴ�.");
		    // ��: �⺻�� �Ǵ� ���� ������ ��
		}
		
	    return new ResponseEntity<String>("savce", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/login")
	public ResponseEntity<Employee> login(@RequestBody(required = false) @Valid Employee emp,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α���");
		System.out.println(emp.toString());
		Employee user = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("�������1");
		if (authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
			user = (Employee) authentication.getPrincipal();
			System.out.println("�������2");

		} else {
			if (emp != null) {
				user = userService.findByEmail(emp.getEmpId());
				System.out.println("�������3");
				System.out.println(user.getPassword());
				if (!passwordEncoder.matches(emp.getPassword(), user.getPassword())) {
					// ���̵� ��й�ȣ ����ġ �� ó���� ����
					System.out.println("�߸��� ��й�ȣ �Դϴ�.!!");
					return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
				}
			}
			System.out.println("�������4");
		}
		System.out.println("11");
		if (user == null) {
			// ������ü�� ����� �ҷ����� ���Ҷ� ó���� ����
		}
		System.out.println(user.toString());
		System.out.println("�������5");
		String expiredToken = jwtUtil.resolveRefreshToken(request);
		if (expiredToken != null && !expiredToken.isBlank()) {
			expiredRefreshTokenService.addExpiredToken(expiredToken);
			System.out.println("�������6");
		}
		System.out.println("�ѹ��� : " + user.toString());
		String accessToken = jwtUtil.createAccessToken(user.getEmpEmail(), user.getEmpAuth());
		String refreshToken = jwtUtil.createRefreshToken(user.getEmpEmail(), user.getEmpAuth());
		System.out.println("�������7");
		Cookie refreshTokenCookie = new Cookie("refresh-token", refreshToken);
		response.setHeader("access-token", accessToken);
		response.addCookie(refreshTokenCookie);
		user.setAccessToken(accessToken);
		user.setRefreshToken(refreshToken);
		
		System.out.println("22");
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/logouta")
	public void logout(HttpServletResponse response) {
		System.out.println("logout");

		// access-token ����
		response.setHeader("access-token", null);

		// refresh-token ����
		Cookie refreshTokenCookie = new Cookie("refresh-token", null);
		refreshTokenCookie.setHttpOnly(true);
		refreshTokenCookie.setSecure(false);
		refreshTokenCookie.setMaxAge(0);
		refreshTokenCookie.setPath("/");
		response.addCookie(refreshTokenCookie);
	}

	@GetMapping("/info")
	public EmployeeDTO getInfo() {

		Object details = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("details : "+details);
		System.out.println("details.toString : "+details.toString());
		if (details != null && !(details instanceof String)) {
			System.out.println("hihi:" + details.toString());
			return new EmployeeDTO((Employee) details);
		}
		return null;
	}

}
