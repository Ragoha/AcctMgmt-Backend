package kr.co.acctmgmt.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SysCfg {
	private String coCd;		//ȸ���ڵ�
	private String mpCd;		//����ȣ
	private String sysCd;		//�ɼǹ�ȣ
	private String sysNm;		//�ɼǸ�
	private String sysYn;		//������
	private String fgTy;		//������(����)
//	private String modifyId; 	//������
//	private Date modifyDt= new Date();
//	private String modifyIp = "127.0.0.1";
}	
