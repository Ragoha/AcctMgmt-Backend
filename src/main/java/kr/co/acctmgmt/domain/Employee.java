package kr.co.acctmgmt.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	private String coCd;
	private String empId;
	private String empPs;
	private String empEmail;
	private String empTel;
	private String empName;
	private String empSx;
	private String empCd;
	private String empOd;
	private String empAuth;
}
