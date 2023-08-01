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
	String insertId=""; //�Է���
	Date insertDt=new Date() ; //�Է���
	String insertIp=""; //�Է�IP
	String modifyId=""; //����
	Date modifyDt= new Date(); //���� ��_
	String modifyIp="";
	
	String keyword="";
	String bgtCDMark="";
	String bgtGrNm="";
	
}
