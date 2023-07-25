package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Employee;
import kr.co.acctmgmt.domain.User;

public interface EmployeeService {

	Employee getEmployee(String id);

	List<Employee> getEmployeeList();

	void insertEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(String id);

	Employee loginEmployee(String id, String ps);

	public Employee findByEmail(String email);

	public void save(Employee employee);
}