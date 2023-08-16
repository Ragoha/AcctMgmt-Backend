package kr.co.acctmgmt.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Co {
	private int coCd;  //ȸ���ڵ�
	private String coNm;  //ȸ���
	private int gisu = 0;    //���
	private Date frDt = new Date();  //��� ������
	private Date toDt = new Date();  //��� ������
	private String insertId;  //�����
	private Date insertDt = new Date();  //�����  
	private String insertIp;  //����� ip
	private String modifyId;  //������
	private Date modifyDt = new Date();  //������
	private String modifyIp;  //���� ip
	private String jongmok;  //����
	private String businessType;  //����
	private String coNb;  //����ڹ�ȣ
	private String ceoNm;  //��ǥ�ڸ�
	private String coZip;  //�����ȣ
	private String coAddr;  //�ּ�
	private String coAddr1;  //���ּ�
	
	private String keyword; //�ӽð˻�����
}
