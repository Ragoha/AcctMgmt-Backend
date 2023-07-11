package kr.co.acctmgmt.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
	private String coCode;
	private String dId;
	private String dPs;
	private String dEmail;
	private String dTel;
	private String dName;
	private String dBday;
	private String dAdr;
	private String dZp;
	private String dSx;
	private String dBcd;
	private String dCd;
	private String dOd;
}
