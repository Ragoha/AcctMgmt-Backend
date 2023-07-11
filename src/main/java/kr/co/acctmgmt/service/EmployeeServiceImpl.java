package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.Employee;
import kr.co.acctmgmt.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeMapper employeeMapper;
	
	@Override
	public List<Employee> getEmployeeList() {
		
		return employeeMapper.getEmployeeList();
	}

	@Override
	public Employee getEmployee() {
		return employeeMapper.getEmployee("employee1");
	}

}
