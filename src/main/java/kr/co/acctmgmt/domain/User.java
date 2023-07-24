package kr.co.acctmgmt.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kr.co.acctmgmt.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails{
	
	private Long id= 0L;

    private String email = "";
    private String password ="";
    private String phoneNumber ="";
    private String name ="";
    
    private List<String> role = new ArrayList<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.role.stream()
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	public void setRole(String role) {
		this.role.add(role);
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public User updateInfo(UserDTO userDto){
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.phoneNumber = userDto.getPhoneNumber();
        this.name = userDto.getName();
        return this;
    }

}
