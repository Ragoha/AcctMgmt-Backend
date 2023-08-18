package kr.co.acctmgmt.domain;

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
public class BgtCD {
	String coCd =""; //COCD;
	String bgtCd=""; //BGTCD;
	String parentCd="";//
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
	String dataPath;
	
	String keyword="";
	List<String> bgtGrCdList = new ArrayList();
	String bgtGrNm="";
	String divCd="";
	String divNm="";
	int carrAm=0;
}