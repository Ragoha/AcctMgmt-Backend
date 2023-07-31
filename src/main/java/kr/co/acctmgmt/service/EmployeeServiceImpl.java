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

	@Override
	public Employee loginEmployee(String id, String ps) {
		return employeeMapper.loginEmployee(id, ps);
	}

	@Override
	public Employee findByEmail(String email) {
		Employee employee = employeeMapper.findByEmail(email);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeMapper.save(employee);
		
		Long id = employeeMapper.getIdByEmail(employee.getEmpEmail());
		
	}

	@Override
	public Employee findByEmails(String email) {
		Employee employee = employeeMapper.findByEmails(email);
		return employee;
	}
}