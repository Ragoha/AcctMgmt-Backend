package kr.co.acctmgmt.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pjt {
	
	private int coCd;		//회사코드
	private int pgrCd ;		//프로젝트그룹 코드
	private String pgrNm; 	//프로젝트그룹 이름
	private String pjtCd;	//프로젝트코드
	private String pjtNM;   //프로젝트이름
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prDt= new Date(); //프로젝트 시작일
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date toDt= new Date();//프로젝트 종료일
	private String progFg; //프로젝트 진행상태
	private String apjtNm; //프로젝트 줄임말
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date stDt= new Date();//프로젝트 시작일2
	
}
