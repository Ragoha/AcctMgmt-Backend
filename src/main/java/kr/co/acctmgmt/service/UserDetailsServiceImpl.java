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
        // 데이터베이스에서 사용자 정보를 조회합니다.
        Employee employee = employeeService.getEmployee(userid);

        if (employee == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + userid);
        }
        System.out.println("실행이 언제되니?");
        // Spring Security에서 사용하는 UserDetails 객체를 생성하여 반환합니다.
        // 여기서는 간단히 Spring Security에서 제공하는 User 클래스를 사용합니다.
        // 필요에 따라 사용자 정보를 변환하여 UserDetails 객체를 생성할 수 있습니다.
        return org.springframework.security.core.userdetails.User.builder()
                .username(employee.getEmpId())
                .password(employee.getEmpPs()) // 이 부분은 암호화를 해야하지만 예시로 간단히 사용합니다.
                .roles(employee.getEmpAuth()) // 사용자의 권한 정보를 설정합니다.
                .build();
    }
}
