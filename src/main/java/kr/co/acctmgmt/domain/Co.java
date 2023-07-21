package kr.co.acctmgmt.domain;

import lombok.Data;

@Data
public class Co {
	private int coCd;  //회사코드
	private String coNm;  //회사명
	private int gisu;    //기수
	private String frDt;  //기수 시작일
	private String toDt;  //기수 종료일
	private String insertId;  //등록자
	private String insertDt;  //등록일  String???
	private String insertIp;  //등록자 ip
	private String modifyId;  //수정자
	private String modifyDt;  //수정일
	private String modifyIp;  //수정 ip
	private String jongmok;  //종목
	private String businessType;  //업태
	private String coNb;  //사업자번호
	private String ceoNm;  //대표자명
	private String coZip;  //우편번호
	private String coAddr;  //주소
	private String coAddr1;  //상세주소
	
}
