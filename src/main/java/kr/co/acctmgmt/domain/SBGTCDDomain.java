package kr.co.acctmgmt.domain;

import java.util.Date;

import lombok.Data;

@Data
public class SBGTCDDomain {
	String coCd; //CO_CD;
	String bgtCd; //BGT_CD;
	int gisu; //GISU;
	String bgtNm; //BGT_NM;
	String divFg; //DIV_FG;
	String ctlFg; //CTL_FG;
	String bgajustFg; //BGAJUST_FG;
	String toDt; //TO_DT;
	String bottomFg; //BOTTOM_FG;
	String bizFg; //BIZ_FG;
}