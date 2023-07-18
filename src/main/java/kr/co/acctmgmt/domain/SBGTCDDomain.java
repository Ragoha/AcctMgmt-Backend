package kr.co.acctmgmt.domain;

import java.util.Date;

import lombok.Data;

@Data
public class SBGTCDDomain {
	String co_Cd; //CO_CD;
	String bgt_Cd; //BGT_CD;
	int gisu; //GISU;
	String bgt_Nm; //BGT_NM;
	String div_Fg; //DIV_FG;
	String ctl_Fg; //CTL_FG;
	String bgajust_Fg; //BGAJUST_FG;
	String to_Dt; //TO_DT;
	String bottom_Fg; //BOTTOM_FG;
	String biz_Fg; //BIZ_FG;
}