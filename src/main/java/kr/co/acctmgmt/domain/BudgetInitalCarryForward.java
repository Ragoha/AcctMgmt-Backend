package kr.co.acctmgmt.domain;

import java.util.Date;

public class BudgetInitalCarryForward {

	private String coCd;		//회사 코드
	private String gisu;		//기수
	private String coNm;		//회사 이름
	private String sq;			//순번
	private String divCd;		//사업장 코드
	private String deptCd;		//부서 코드
	private String mgtCd;		//프로젝트(통제)부서
	private String bgtCd;		//예산 코드
	private String bgtFg;		//예산 구분
	private String bgtCnt;		//예산 차수
	private String bottomCd;	//하위사업코드
	private Long carrAm;		//이월 금액
	private Long carrAm1;		//사고이월금액
	private Long carrAm2;		//명시이월금액
	private Long carrAm3;		//예비비이월금액
//	private Long bjYn;			//예산배정사용여부
//	private Long fillDt;		//승인날짜
	private String empCd;		//사원코드
	private String remDc;		//적요
	private String bgtTy;		//금액반영 구분 1.전기이월, 2.직접입력
	private String insertId;	//등록자
	private Date insertDt;		//등록일자
	private String insertIp;	//등록자 IP
	
}
