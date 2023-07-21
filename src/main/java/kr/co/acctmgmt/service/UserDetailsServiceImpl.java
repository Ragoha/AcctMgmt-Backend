package kr.co.acctmgmt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.Employee;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EmployeeService employeeService;


    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        // �����ͺ��̽����� ����� ������ ��ȸ�մϴ�.
        Employee employee = employeeService.getEmployee(userid);

        if (employee == null) {
            throw new UsernameNotFoundException("����ڸ� ã�� �� �����ϴ�: " + userid);
        }
        System.out.println("������ �����Ǵ�?");
        // Spring Security���� ����ϴ� UserDetails ��ü�� �����Ͽ� ��ȯ�մϴ�.
        // ���⼭�� ������ Spring Security���� �����ϴ� User Ŭ������ ����մϴ�.
        // �ʿ信 ���� ����� ������ ��ȯ�Ͽ� UserDetails ��ü�� ������ �� �ֽ��ϴ�.
        return org.springframework.security.core.userdetails.User.builder()
                .username(employee.getEmpId())
                .password(employee.getEmpPs()) // �� �κ��� ��ȣȭ�� �ؾ������� ���÷� ������ ����մϴ�.
                .roles(employee.getEmpAuth()) // ������� ���� ������ �����մϴ�.
                .build();
    }
}
