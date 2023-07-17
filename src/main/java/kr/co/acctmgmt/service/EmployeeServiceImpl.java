package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.Employee;
import kr.co.acctmgmt.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeMapper employeeMapper;

	@Override
	public Employee getEmployee(String id) {
		return employeeMapper.getEmployee(id);
	}

	@Override
	public List<Employee> getEmployeeList() {
		return employeeMapper.getEmployeeList();
	}

	@Override
	public void insertEmployee(Employee employee) {
		employeeMapper.insertEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeMapper.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(String id) {
		employeeMapper.deleteEmployee(id);
	}
}