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
	String grFg = "";
	String insertId=""; //�엯�젰�옄
	Date insertDt=new Date() ; //�엯�젰�씪
	String insertIp=""; //�엯�젰IP
	String modifyId=""; //�닔�젙
	Date modifyDt= new Date(); //�닔�젙 �씪_
	String modifyIp="";
	int MultiCk= 0;  //以묐났�뿬遺�
	int MultiNum=0; //以묐났�씠 Y�씪�븣 紐뉖쾲�옱 以묐났�씤媛� .
	String dataPath="";
	
	String keyword="";
	String bgtGrNm="";
	int divCd=0;
	int carrAm=0;
	
}
