package kr.co.acctmgmt.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
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
