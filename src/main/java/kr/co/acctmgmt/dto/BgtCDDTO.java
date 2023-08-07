package kr.co.acctmgmt.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class BgtCDDTO {
	
	int coCd =0; //COCD;
	String bgtCd=""; //BGTCD;
	int gisu=0; //GISU;
	String bgtNm=""; //BGTNM;
	String divFg=""; //DIVFG;
	String defNm="";
	String ctlFg=""; //CTLFG;
	String bgajustFg=""; //BGAJUSTFG;
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
	int MultiCk= 0;  //중복여부
	int MultiNum=0; //중복이 Y일때 몇번재 중복인가 .
	String dataPath="";
	
	String keyword="";
	String bgtGrNm="";
	
}
