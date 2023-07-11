package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Employee;

public interface EmployeeMapper {

	public String getTime();
	
	public Employee getEmployee(String id);
	
	public List<Employee> getEmployeeList();
	
	public void insertEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(String id);
}
