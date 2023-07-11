package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployeeList();
	
	public Employee getEmployee();

}
