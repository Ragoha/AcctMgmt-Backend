package kr.co.acctmgmt.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Config {
	private String coCd;		//ȸ���ڵ�
	private String mpCd;		//����ȣ
	private String sysCd;		//�ɼǹ�ȣ
	private String sysNm;		//�ɼǸ�
	private String sysYn;		//������
	private String fgTy;		//������(����)
}	
