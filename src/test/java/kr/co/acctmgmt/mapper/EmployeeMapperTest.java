package kr.co.acctmgmt.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acctmgmt.domain.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class EmployeeMapperTest {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
//	@Test
	public void getEmployee() {
		
		String empId = "yhy0704";
		
		Employee employee = employeeMapper.getEmployee(empId);
		
		System.out.println(employee.getEmpId());
	}
	
//	@Test
	public void getEmployeeList() {
		
		List<Employee> employeeList = employeeMapper.getEmployeeList();
		
		employeeList.forEach(employee -> {
	        System.out.println(employee.toString());
	    });
		
	}
	
//	@Test
	public void insertEmployee() {
		Employee employee = Employee.builder()
				  .coCd("COMP")
				  .empId("employee4")
				  .empPs("password4")
				  .empEmail("employee4@example.com")
				  .empTel("987654321")
				  .empName("Jane Doe")
				  .empSx("F")
				  .empCd("CD4")
				  .empOd("OD4")
				  .build();

		
		employeeMapper.insertEmployee(employee);
		
		getEmployeeList();
	}
	
//	@Test
	public void updateEmployee() {
		
		String dId = "employee4";
		
		Employee employee = employeeMapper.getEmployee(dId);
		
		employee.setEmpPs("change");
		
		employeeMapper.updateEmployee(employee);
		
		getEmployeeList();
	}
	
//	@Test
	public void deleteEmployee() {
		String dId = "employee4";
		
		employeeMapper.deleteEmployee(dId);
		
		
		getEmployeeList();
	} 
	
	@Test
	public void loginEmployee() {
		String empId = "yhy0704";
		String empPs = "hohb0704!!";
		Employee employee = employeeMapper.loginEmployee(empId, empPs);
		System.out.println(employee.toString());
	}

}
