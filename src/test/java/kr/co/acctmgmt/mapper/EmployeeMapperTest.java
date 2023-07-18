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
		
		String dId = "yhy0704";
		
		Employee employee = employeeMapper.getEmployee(dId);
		
		System.out.println(employee.toString());
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
				  .coCode("COMP")
				  .dId("employee4")
				  .dPs("password4")
				  .dEmail("employee4@example.com")
				  .dTel("987654321")
				  .dName("Jane Doe")
				  .dBday("1993-03-03")
				  .dAdr("789 Maple St")
				  .dZp("54321")
				  .dSx("F")
				  .dBcd("BCD4")
				  .dCd("CD4")
				  .dOd("OD4")
				  .build();

		
		employeeMapper.insertEmployee(employee);
		
		getEmployeeList();
	}
	
//	@Test
	public void updateEmployee() {
		
		String dId = "employee4";
		
		Employee employee = employeeMapper.getEmployee(dId);
		
		employee.setDPs("change");
		
		employeeMapper.updateEmployee(employee);
		
		getEmployeeList();
	}
	
	@Test
	public void deleteEmployee() {
		String dId = "employee4";
		
		employeeMapper.deleteEmployee(dId);
		
		
		getEmployeeList();
	}

}
