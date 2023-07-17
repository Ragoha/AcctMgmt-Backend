//package kr.co.acctmgmt.controller;
//
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import kr.co.acctmgmt.domain.Employee;
//import kr.co.acctmgmt.service.EmployeeService;
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequiredArgsConstructor
//public class EmployeeController {
//
//	private final EmployeeService employeeService;
//	
//	@RequestMapping("/employee")
//	public ResponseEntity<Employee> getEmployee() {
//		
////		return new ResponseEntity<Employee>(employeeService.getEmployee(), HttpStatus.OK);
//	}
//	
//	@RequestMapping("/employees")
//	public ResponseEntity<List<Employee>> getEmployeeList(){
//		
//		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeList(), HttpStatus.OK);
//	}
//}
