package kr.co.acctmgmt.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acctmgmt.domain.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class EmployeeServiceTest {
	
	@Autowired
	private EmployeeService employeeService;

	@Test
	public void GetEmployee() {
		String dId = "yhy0704";
		Employee employee = employeeService.getEmployee(dId);
//		System.out.println(employee);
			
		System.out.println(employee.toString());
	}
}