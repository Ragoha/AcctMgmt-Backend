package kr.co.acctmgmt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Employee;
import kr.co.acctmgmt.domain.User;

public interface EmployeeMapper {

	public String getTime();

	public Employee getEmployee(String id);

	public List<Employee> getEmployeeList();

	public void insertEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(String id);

	public Employee loginEmployee(@Param("empId") String empId, @Param("empPs") String empPs);

	public Employee findByEmail(String email);
	
	public Employee findByEmails(String email);

	public void save(Employee Employee);

	public Long getIdByEmail(String email);
}
