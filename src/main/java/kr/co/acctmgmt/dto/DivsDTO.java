package kr.co.acctmgmt.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DivsDTO {

	private int coCd;  //ȸ���ڵ�
	private int divCd;  //������ڵ�
	private String divNm;  //������
	private String jongmok;  //����
	private String businessType;  //����
	private String divNb;  //����ڹ�ȣ
	private String ceoNm;  //��ǥ�ڸ�
	private String toNb;    //���Ҽ����� ��ȣ
	private String divZip;  //�����ȣ
	private String divAddr;  //�ּ�
	private String divAddr1;  //���ּ�
	private String insertId;  //�����
	private Date insertDt = new Date();  //����� 
	private String insertIp;  //����� ip
	private String modifyId;  //������
	private Date modifyDt = new Date();  //������
	private String modifyIp;  //���� ip
	
	
	private String keyword;
}
