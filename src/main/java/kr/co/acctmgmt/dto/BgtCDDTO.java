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
	
	String coCd =""; //COCD;
	String bgtCd=""; //BGTCD;
	int gisu=0; //GISU;
	String bgtNm=""; //BGTNM;
	String divFg=""; //DIVFG;
	String defNm="";
	String ctlFg=""; //CTLFG;
	String bgajustFg=""; //BGAJUSTFG;
	Date toDt= new Date(); //TODT; `````
	String bottomFg=""; 
	String bizFg=""; 
	String groupCd="";
	String grFg = "";
	String insertId=""; 
	Date insertDt=new Date() ; 
	String insertIp="";
	String modifyId=""; 
	Date modifyDt= new Date(); 
	String modifyIp="";
	int MultiCk= 0;  
	int MultiNum=0; 
	String dataPath="";
	
	String keyword="";
	String bgtGrNm="";
	int divCd=0;
	String divNm="";
	int carrAm=0;
	
}
