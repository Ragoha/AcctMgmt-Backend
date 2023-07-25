package kr.co.acctmgmt.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DivsDTO {

	private int coCd;  //회사코드
	private int divCd;  //사업장코드
	private String divNm;  //사업장명
	private String jongmok;  //종목
	private String businessType;  //업태
	private String divNb;  //사업자번호
	private String ceoNm;  //대표자명
	private String toNb;    //관할세무서 번호
	private String divZip;  //우편번호
	private String divAddr;  //주소
	private String divAddr1;  //상세주소
	private String insertId;  //등록자
	private Date insertDt = new Date();  //등록일 
	private String insertIp;  //등록자 ip
	private String modifyId;  //수정자
	private Date modifyDt = new Date();  //수정일
	private String modifyIp;  //수정 ip
	
	
	private String keyword;
}
