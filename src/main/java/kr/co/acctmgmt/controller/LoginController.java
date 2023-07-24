//package kr.co.acctmgmt.controller;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import kr.co.acctmgmt.config.CustomAuthenticationSuccessHandler;
//import kr.co.acctmgmt.domain.Employee;
//import kr.co.acctmgmt.service.EmployeeService;
//import kr.co.acctmgmt.service.UserDetailsServiceImpl;
//
//@RestController
//@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:3000")
//public class LoginController {
//	
//	@Autowired
//	UserDetailsServiceImpl userService;
//	@Autowired
//	private EmployeeService employeeService;
//	@Autowired
//    private CustomAuthenticationSuccessHandler authenticationSuccessHandler;
//	@PostMapping("/login")
//	public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
//		String email = loginData.get("email");
//		String password = loginData.get("password");
//		System.out.println(email);
//		System.out.println(password);
//		
//		Employee employee = employeeService.loginEmployee(email, password);
//		System.out.println("boolean? : " + employee.getEmpPs().equals(password));
//		
//		userService.loadUserByUsername(email);
//		if(employee.getEmpId().equals(null)) {
//			System.out.println("��ϵ��� ���� ���̵� �Դϴ�.");
//		}
//		else if(employee.getEmpPs().equals(null))
//		{
//			System.out.println("�н����尡 �޶��");
//		}
//		else {
////			HttpSession session = request.getSession(true);
////            session.setAttribute("employee", employee);
////			System.out.println(employee.getEmpId()+" : �α��� ����!!");
//		}
//		//���� �����͸� �ٽ� JSON �������� ��ȯ
//		
//		String response = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}";
//		return ResponseEntity.ok(response);
//	}
//	
//	@GetMapping("/logout")
//    public String logout(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.invalidate();
//        }
//        return "redirect:/";
//
//    }
//	
//	@GetMapping("/emp/idcheck/{checkId}")
//	public ResponseEntity<String> idCheck(@PathVariable String checkId){
//		System.out.println(checkId);
//		String id = checkId;
//		Employee employee = employeeService.getEmployee(id);
//		
//
//		if(employee.getEmpId().equals(id))
//		System.out.println("�ߺ�! �ߺ�!");
//		else 
//			System.out.println("�ߺ� �� ���̵� �ƴմϴ�.");
//		
//		
//		String response = "{\"id\" : \"" + checkId + "\")}";
//		return ResponseEntity.ok(response);
//	}
//}
