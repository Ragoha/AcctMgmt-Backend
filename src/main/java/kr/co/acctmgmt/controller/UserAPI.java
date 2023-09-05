package kr.co.acctmgmt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kr.co.acctmgmt.config.jwt.ExpiredRefreshTokenService;
import kr.co.acctmgmt.config.jwt.JwtUtil;
import kr.co.acctmgmt.domain.Employee;
import kr.co.acctmgmt.domain.Pjt;
import kr.co.acctmgmt.dto.EmployeeDTO;
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

	public int generateMemberCode(int coCd) {
		int lastMemberCode = userService.findByEmpCd(coCd);
		System.out.println("최근 사원번호 : " + lastMemberCode);
		int memberCode=0;
		if (lastMemberCode == 0) {
			memberCode = (coCd * 10000) + (lastMemberCode);
		}
		else
		{
			memberCode = (1000 + lastMemberCode);
		}
		return memberCode;
	}

	
	@PostMapping("/join")
	public void join(@RequestBody Employee user) {

		System.out.println("회원가입");
		System.out.println(user.toString());
		
		userService.save(Employee.builder().empId(user.getEmpId()).empPw(passwordEncoder.encode(user.getEmpPw()))
				.empName(user.getEmpName()).empTel(user.getEmpTel()).empEmail(user.getEmpEmail()).empSx(user.getEmpSx())
				.coCd(user.getCoCd()).empOd(user.getEmpOd()).empAuth(user.getEmpAuth())
				.empCd(generateMemberCode(Integer.parseInt(user.getCoCd()))).build());
	}

	@GetMapping("/emp/id/{checkId}")
	public ResponseEntity<String> idCheck(@PathVariable String checkId) {
		System.out.println(checkId);
		String id = checkId;
		try {
			Employee employee = userService.getEmployee(id);
			if (employee == null) {
				return new ResponseEntity<String>("savc", HttpStatus.OK);
			} else {
			}
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}

		return new ResponseEntity<String>("savce", HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/emp/email")
	public ResponseEntity<String> email(@RequestParam String email){
		System.out.println("email : " + email);
		String emails = email;
		try {
			Employee employee = userService.findByEmail(emails);
			if (employee == null) {
				return new ResponseEntity<String>("savc", HttpStatus.OK);
			} else {
			}
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}
		return new ResponseEntity<String>("savce", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/login")
	public ResponseEntity<Employee> login(@RequestBody(required = false) @Valid Employee emp,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("1");
		System.out.println(emp.toString());
		Employee user = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("1");
		if (authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
			user = (Employee) authentication.getPrincipal();
			System.out.println("2");

		} else {
			if (emp != null) {
				user = userService.findByEmails(emp.getEmpId());
				System.out.println("user??: " + user.toString());
				System.out.println("3");
				System.out.println(user.getPassword());
				if (!passwordEncoder.matches(emp.getPassword(), user.getPassword())) {
					// ���̵� ��й�ȣ ����ġ �� ó���� ����
					System.out.println("password fail");
					return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
				}
			}
			System.out.println("4");
		}
		if (user == null) {
			// ������ü�� ����� �ҷ����� ���Ҷ� ó���� ����
		}
		System.out.println(user.toString());
		System.out.println("5");
		String expiredToken = jwtUtil.resolveRefreshToken(request);
		if (expiredToken != null && !expiredToken.isBlank()) {
			expiredRefreshTokenService.addExpiredToken(expiredToken);
			System.out.println("6");
		}
		System.out.println(" : " + user.toString());
		String accessToken = jwtUtil.createAccessToken(user.getEmpEmail(), user.getEmpAuth());
		String refreshToken = jwtUtil.createRefreshToken(user.getEmpEmail(), user.getEmpAuth());
		System.out.println("7");
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

	@GetMapping("/message")
	public ResponseEntity<Map<String, String>> refreshAccessToken(HttpServletRequest request,
			HttpServletResponse response) {
		// ���� �������� ��ū ��������
		String refreshToken = jwtUtil.resolveRefreshToken(request);
		
		System.out.println(refreshToken);

		// �������� ��ū ����
		if (jwtUtil.validateRefreshToken(refreshToken)) {
			// �������� ��ū���� ����� ���� ��������
			String email = jwtUtil.getUserPk(refreshToken);
			Employee user = userService.findByEmail(email);

			// ���ο� ������ ��ū ����
			String newAccessToken = jwtUtil.createAccessToken(user.getEmpEmail(), user.getEmpAuth());

			// ���� ����� ���ο� ������ ��ū ����
			response.setHeader("access-token", newAccessToken);

			// �������� ���ο� ������ ��ū�� �������� ��ū�� �����ϴ�.
			Map<String, String> tokens = new HashMap<>();
			tokens.put("access-token", newAccessToken);
			tokens.put("refresh-token", refreshToken);
			return new ResponseEntity<>(tokens, HttpStatus.OK);
		} else {
			// �������� ��ū�� ��ȿ���� ���� ��� ���� ����
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

//	@GetMapping(path = "/message", headers = "Authorization")
	public ResponseEntity<String> messageForHeader(@RequestHeader HttpHeaders header) {

		return ResponseEntity.ok().body(header.getFirst("Authorization"));
	}

	@GetMapping("/info")
	public ResponseEntity<Object> getInfo() {
		Authentication details = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("details.toString : " + details.toString());
		System.out.println("details : " + details);
		if (details != null && (details.isAuthenticated())) {
			System.out.println("hihi:" + details.toString());
			return new ResponseEntity<>(details, HttpStatus.OK);
		}
		// ���� ���� Ȯ��
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		System.out.println("$$$$$$$" + authentication);
//		System.out.println("$$$$$$$" + authentication.toString());
//		if (authentication != null && authentication.isAuthenticated()) {
//		    System.out.println("����� �̸�: " + authentication.getName());
//
//		    authentication.getAuthorities().forEach(authority -> System.out.println("����� ����:22 " + authority.getAuthority()));
//		} else {
//		    System.out.println("����ڰ� �������� �ʾҽ��ϴ�.");
//		    return null;
//		}
//		
//		boolean isAuthenticated = authentication.isAuthenticated();
//
//		if (isAuthenticated) {
//		    Object principal2 = authentication.getPrincipal();
//		    
//		    if (principal2 instanceof UserDetails) {
//		        // ������ ������� ���� ��������
//		        UserDetails userDetails = (UserDetails) principal2;
//		        String username = userDetails.getUsername();
//		        // �߰������� ������� ���� ������ ������ �� �ֽ��ϴ�.
//		        // List<GrantedAuthority> authorities = (List<GrantedAuthority>) userDetails.getAuthorities();
//
//		        // ������ ���� Ȱ�� ����
//		        System.out.println("����� �̸�: " + username);
//		        // ���� ���� ��� ����
//		        // authorities.forEach(authority -> System.out.println("����� ����: " + authority.getAuthority()));
//		    } else {
//		        // UserDetails�� �ƴ� �ٸ� Ÿ���� ��ü�� ��� ó���� �۾�
//		        System.out.println("UserDetails ��ü�� �ƴ� Ÿ���� ��ü�Դϴ�.");
//		    }
//		} else {
//		    // �������� ���� ������� ��� ó���� �۾�
//		    System.out.println("����ڰ� �������� �ʾҽ��ϴ�.");
//		}
		return null;

//		return new ResponseEntity<String>(authentication, HttpStatus.OK);
	}
//	}
//	@GetMapping("/info")
//	public ResponseEntity<EmployeeDTO> getInfo() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication == null || !(authentication instanceof UsernamePasswordAuthenticationToken)) {
//			// ���� �������� ���� ��쿡�� ������ ��ȯ�ϰų� ó���� �� �ֽ��ϴ�.
//			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//		}
//
//		String userEmail = ((UserDetails) authentication.getPrincipal()).getUsername();
//		Employee user = userService.findByEmail(userEmail);
//
//		if (user != null) {
//			EmployeeDTO employeeDTO = new EmployeeDTO(user);
//			return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
}