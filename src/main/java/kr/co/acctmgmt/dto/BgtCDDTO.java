package kr.co.acctmgmt.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
	List<String> bgtCdList = new ArrayList();
	List<String> bgtGrCdList = new ArrayList();
	String bgtGrNm="";
	String divCd="";
	String divNm="";
	int carrAm=0;
	
}
