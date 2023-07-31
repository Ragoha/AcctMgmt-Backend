package kr.co.acctmgmt.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class BgtCD {
	int coCd =0; //COCD;
	String bgtCd=""; //BGTCD;
	int gisu=0; //GISU;
	String bgtNm=""; //BGTNM;
	String divFg=""; //DIVFG;
	String defNm="";
	String ctlFg=""; //CTLFG;
	String bgajustFg=""; //BGAJUSTFG;
	Date toDt=new Date(); //TODT;
	String bottomFg=""; //BOTTOMFG;
	String bizFg=""; //BIZFG;
	String groupCd = "";
	String grFg = "";
	String insertId=""; //입력자
	Date insertDt=new Date() ; //입력일
	String insertIp=""; //입력IP
	String modifyId=""; //수정
	Date modifyDt= new Date(); //수정 일_
	String modifyIp="";
	int MultiCk= 0;  //중복여부
	int MultiNum; //중복이 Y일때 몇번재 중복인가 .
	String dataPath="";
}