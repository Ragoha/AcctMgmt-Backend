package kr.co.acctmgmt.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SysCfg {
	private String coCd;		//회사코드
	private String moCd;		//모듈번호
	private String sysCd;		//옵션번호
	private String sysNm;		//옵션명
	private String sysYn;		//설정값
	private String modifyId; 	//수정자
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modifyDt= new Date();
	private String modifyIp; //
	private String cfgvalue;
}	
