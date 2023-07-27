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
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kr.co.acctmgmt.config.jwt.ExpiredRefreshTokenService;
import kr.co.acctmgmt.config.jwt.JwtUtil;
import kr.co.acctmgmt.domain.Employee;
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

	@PostMapping("/join")
	public void join(@RequestBody Employee user) {

		System.out.println("조인");
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
				System.out.println("중복 된 아이디가 아닙니다.");
				return new ResponseEntity<String>("savc", HttpStatus.OK);
			} else {
				System.out.println("중복! 중복!");
			}
		} catch (NullPointerException e) {
			// NullPointerException 예외 발생 시 처리 로직
			System.out.println("NullPointerException이 발생했습니다.");
			// 예: 기본값 또는 예외 던지기 등
		}

		return new ResponseEntity<String>("savce", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/login")
	public ResponseEntity<Employee> login(@RequestBody(required = false) @Valid Employee emp,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인");
		System.out.println(emp.toString());
		Employee user = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("여기까지1");
		if (authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
			user = (Employee) authentication.getPrincipal();
			System.out.println("여기까지2");

		} else {
			if (emp != null) {
				user = userService.findByEmail(emp.getEmpId());
				System.out.println("여기까지3");
				System.out.println(user.getPassword());
				if (!passwordEncoder.matches(emp.getPassword(), user.getPassword())) {
					// 아이디 비밀번호 미일치 시 처리할 로직
					System.out.println("잘못된 비밀번호 입니다.!!");
					return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
				}
			}
			System.out.println("여기까지4");
		}
		System.out.println("11");
		if (user == null) {
			// 유저객체를 제대로 불러오지 못할때 처리할 로직
		}
		System.out.println(user.toString());
		System.out.println("여기까지5");
		String expiredToken = jwtUtil.resolveRefreshToken(request);
		if (expiredToken != null && !expiredToken.isBlank()) {
			expiredRefreshTokenService.addExpiredToken(expiredToken);
			System.out.println("여기까지6");
		}
		System.out.println("한번더 : " + user.toString());
		String accessToken = jwtUtil.createAccessToken(user.getEmpEmail(), user.getEmpAuth());
		String refreshToken = jwtUtil.createRefreshToken(user.getEmpEmail(), user.getEmpAuth());
		System.out.println("여기까지7");
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
		
		// access-token 삭제
		response.setHeader("access-token", null);

		// refresh-token 삭제
		Cookie refreshTokenCookie = new Cookie("refresh-token", null);
		refreshTokenCookie.setHttpOnly(true);
		refreshTokenCookie.setSecure(false);
		refreshTokenCookie.setMaxAge(0);
		refreshTokenCookie.setPath("/");
		response.addCookie(refreshTokenCookie);
	}

	@GetMapping("/message")
	public ResponseEntity<Map<String, String>> refreshAccessToken(HttpServletRequest request, HttpServletResponse response) {
	    // 기존 리프레시 토큰 가져오기
	    String refreshToken = jwtUtil.resolveRefreshToken(request);
	    
	    // 리프레시 토큰 검증
	    if (jwtUtil.validateRefreshToken(refreshToken)) {
	        // 리프레시 토큰에서 사용자 정보 가져오기
	        String email = jwtUtil.getUserPk(refreshToken);
	        Employee user = userService.findByEmail(email);
	        
	        // 새로운 엑세스 토큰 생성
	        String newAccessToken = jwtUtil.createAccessToken(user.getEmpEmail(), user.getEmpAuth());
	        
	        // 응답 헤더에 새로운 엑세스 토큰 설정
	        response.setHeader("access-token", newAccessToken);
	        
	        // 응답으로 새로운 엑세스 토큰과 리프레시 토큰을 보냅니다.
	        Map<String, String> tokens = new HashMap<>();
	        tokens.put("access-token", newAccessToken);
	        tokens.put("refresh-token", refreshToken);
	        return new ResponseEntity<>(tokens, HttpStatus.OK);
	    } else {
	        // 리프레시 토큰이 유효하지 않은 경우 에러 응답
	        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	    }
	}

	
//	@GetMapping(path = "/message", headers = "Authorization")
	public ResponseEntity<String> messageForHeader(@RequestHeader HttpHeaders header) {
		
	    return ResponseEntity.ok().body(header.getFirst("Authorization"));
	}
	
	
	@GetMapping("/info")
	public EmployeeDTO getInfo() {
//	    Object details = SecurityContextHolder.getContext().getAuthentication().getName();
//	    System.out.println("details.toString : " + details.toString());
//	    System.out.println("details : " + details);
//	    if (details != null && !(details instanceof String)) {
//	        System.out.println("hihi:" + details.toString());
//	        return new EmployeeDTO((Employee) details);
//	    }
	 // 인증 여부 확인
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
		    System.out.println("사용자 이름: " + authentication.getName());

		    authentication.getAuthorities().forEach(authority -> System.out.println("사용자 권한: " + authority.getAuthority()));
		} else {
		    System.out.println("사용자가 인증되지 않았습니다.");
		}
		
//		boolean isAuthenticated = authentication.isAuthenticated();
//
//		if (isAuthenticated) {
//		    Object principal2 = authentication.getPrincipal();
//		    
//		    if (principal2 instanceof UserDetails) {
//		        // 인증된 사용자의 정보 가져오기
//		        UserDetails userDetails = (UserDetails) principal2;
//		        String username = userDetails.getUsername();
//		        // 추가적으로 사용자의 권한 정보도 가져올 수 있습니다.
//		        // List<GrantedAuthority> authorities = (List<GrantedAuthority>) userDetails.getAuthorities();
//
//		        // 가져온 정보 활용 예시
//		        System.out.println("사용자 이름: " + username);
//		        // 권한 정보 출력 예시
//		        // authorities.forEach(authority -> System.out.println("사용자 권한: " + authority.getAuthority()));
//		    } else {
//		        // UserDetails가 아닌 다른 타입의 객체인 경우 처리할 작업
//		        System.out.println("UserDetails 객체가 아닌 타입의 객체입니다.");
//		    }
//		} else {
//		    // 인증되지 않은 사용자의 경우 처리할 작업
//		    System.out.println("사용자가 인증되지 않았습니다.");
//		}
		return null;
	}
//	}
//	@GetMapping("/info")
//	public ResponseEntity<EmployeeDTO> getInfo() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication == null || !(authentication instanceof UsernamePasswordAuthenticationToken)) {
//			// 유저 인증되지 않은 경우에는 에러를 반환하거나 처리할 수 있습니다.
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