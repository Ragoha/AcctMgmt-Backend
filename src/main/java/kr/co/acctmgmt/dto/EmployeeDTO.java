package kr.co.acctmgmt.dto;

import java.util.ArrayList;
import java.util.List;

import kr.co.acctmgmt.domain.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class EmployeeDTO {
	private Long id;

    private String email;
    private String password;
    private String phoneNumber;
    private String name;
    
    private List<String> roles = new ArrayList<>();
    
    public EmployeeDTO(Employee employee) {
    	this.id = employee.getId();
    	this.email = employee.getEmpId();
    	this.password = employee.getEmpPw();
    	this.phoneNumber = employee.getEmpTel();
    	this.name = employee.getEmpName();
    }
}