package kr.co.acctmgmt.dto;

import java.util.ArrayList;
import java.util.List;

import kr.co.acctmgmt.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO {

	private Long id;

    private String email;
    private String password;
    private String phoneNumber;
    private String name;
    
    private List<String> roles = new ArrayList<>();
    
    public UserDTO(User user) {
    	this.id = user.getId();
    	this.email = user.getEmail();
    	this.password = user.getPassword();
    	this.phoneNumber = user.getPhoneNumber();
    	this.name = user.getName();
    }
}
