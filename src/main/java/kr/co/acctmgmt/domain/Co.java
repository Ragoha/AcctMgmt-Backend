package kr.co.acctmgmt.domain;

import lombok.Data;

@Data
public class Co {
	private int coCd;  //ȸ���ڵ�
	private String coNm;  //ȸ���
	private int gisu;    //���
	private String frDt;  //��� ������
	private String toDt;  //��� ������
	private String insertId;  //�����
	private String insertDt;  //�����  String???
	private String insertIp;  //����� ip
	private String modifyId;  //������
	private String modifyDt;  //������
	private String modifyIp;  //���� ip
	private String jongmok;  //����
	private String businessType;  //����
	private String coNb;  //����ڹ�ȣ
	private String ceoNm;  //��ǥ�ڸ�
	private String coZip;  //�����ȣ
	private String coAddr;  //�ּ�
	private String coAddr1;  //���ּ�
	
}
