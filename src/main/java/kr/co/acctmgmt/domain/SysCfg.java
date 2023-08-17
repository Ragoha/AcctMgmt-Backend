package kr.co.acctmgmt.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SysCfg {
	private String coCd;		//ȸ���ڵ�
	private String moCd;		//����ȣ
	private String sysCd;		//�ɼǹ�ȣ
	private String sysNm;		//�ɼǸ�
	private String sysYn;		//������
	private String modifyId; 	//������
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modifyDt= new Date();
	private String modifyIp; //
	private String cfgvalue;
}	
