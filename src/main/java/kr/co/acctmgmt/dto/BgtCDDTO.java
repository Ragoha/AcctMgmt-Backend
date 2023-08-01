package kr.co.acctmgmt.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class BgtCDDTO {
	
	int coCd =0; //COCD;
	String bgtCd=""; //BGTCD;
	int gisu=0; //GISU;
	String bgtNm=""; //BGTNM;
	String divFg=""; //DIVFG;
	String defNm="";
	String ctlFg=""; //CTLFG;
	String bgajustFg=""; //BGAJUSTFG;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date toDt= new Date(); //TODT;
	String bottomFg=""; //BOTTOMFG;
	String bizFg=""; //BIZFG;
	String groupCd="";
	String insertId=""; //입력자
	Date insertDt=new Date() ; //입력일
	String insertIp=""; //입력IP
	String modifyId=""; //수정
	Date modifyDt= new Date(); //수정 일_
	String modifyIp="";
	
	String keyword="";
	String bgtCDMark="";
	String bgtGrNm="";
	
}
