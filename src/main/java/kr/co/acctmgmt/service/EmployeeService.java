package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Employee;

public interface EmployeeService {

	Employee getEmployee(String id);

	List<Employee> getEmployeeList();

	void insertEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(String id);
}