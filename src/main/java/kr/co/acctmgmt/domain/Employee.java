package kr.co.acctmgmt.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements UserDetails {

	private Long id = 0L;

	private String coCd;
	private String empId;
	private String empPw;
	private String empEmail;
	private String empTel;
	private String empName;
	private String empSx;
	private String divCd;
	private String deptOd;
	private String empOd;
	
	private String empAuth;
	private int empCd;
	
	private String accessToken;
	private String refreshToken;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<String> empAuths = new ArrayList<>();
		empAuths.add(this.empAuth);
		// TODO Auto-generated method stub
		return empAuths.stream()
		.map(SimpleGrantedAuthority::new)
		.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return empPw;
	}

	@Override
	public String getUsername() {
		return empName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public Employee updateInfo(Employee userDto){
        this.empId = userDto.getEmpId();
        this.empPw = userDto.getEmpPw();
        this.empTel = userDto.getEmpTel();
        this.empName = userDto.getEmpName();
        return this;
    }


}
