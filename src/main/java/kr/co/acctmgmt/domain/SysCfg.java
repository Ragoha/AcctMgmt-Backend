package kr.co.acctmgmt.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SysCfg {
	private String coCd;		//회사코드
	private String mpCd;		//모듈번호
	private String sysCd;		//옵션번호
	private String sysNm;		//옵션명
	private String sysYn;		//설정값
	private String fgTy;		//설정값(보조)
//	private String modifyId; 	//수정자
//	private Date modifyDt= new Date();
//	private String modifyIp = "127.0.0.1";
}	
