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
	String insertId=""; //�Է���
	Date insertDt=new Date() ; //�Է���
	String insertIp=""; //�Է�IP
	String modifyId=""; //����
	Date modifyDt= new Date(); //���� ��_
	String modifyIp="";
	int MultiCk= 0;  //�ߺ�����
	int MultiNum; //�ߺ��� Y�϶� ����� �ߺ��ΰ� .
	String dataPath="";
	
	String keyword="";
}