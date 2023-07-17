package kr.co.acctmgmt.dto;

import lombok.Data;

@Data
public class BgticfDTO {
	private String id;
	private String bgtCd;		//예산 코드
	private String bgtFg;		//예산 구분
	private String bgtNm;		//예산 과목명
	private Long amount;		//금액
	
}
