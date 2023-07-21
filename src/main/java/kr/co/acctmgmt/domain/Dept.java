package kr.co.acctmgmt.domain;

import java.util.Date;

public class Dept {
	private int coCd;  //회사코드
	private int divCd;  //사업장코드
	private int deptCd;  //부서코드
	private String deptNm;  //부서명
	private int parentDeptCd;  //상위부서코드
	private int deptLevel;		//부서레벨
	private String insertId;  //등록자
	private Date insertDt = new Date();  //등록일 
	private String insertIp;  //등록자 ip
	private String modifyId;  //수정자
	private Date modifyDt = new Date();  //수정일
	private String modifyIp;  //수정 ip

}
