package kr.co.acctmgmt.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Co {
	private int coCd;  //회사코드
	private String coNm;  //회사명
	private int gisu = 0;    //기수
	private Date frDt = new Date();  //기수 시작일
	private Date toDt = new Date();  //기수 종료일
	private String insertId;  //등록자
	private Date insertDt = new Date();  //등록일  
	private String insertIp;  //등록자 ip
	private String modifyId;  //수정자
	private Date modifyDt = new Date();  //수정일
	private String modifyIp;  //수정 ip
	private String jongmok;  //종목
	private String businessType;  //업태
	private String coNb;  //사업자번호
	private String ceoNm;  //대표자명
	private String coZip;  //우편번호
	private String coAddr;  //주소
	private String coAddr1;  //상세주소
	
	private String keyword; //임시검색변수
}
