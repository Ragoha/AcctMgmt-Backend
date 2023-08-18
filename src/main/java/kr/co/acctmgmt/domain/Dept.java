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
public class Dept {
	private String coCd;  //ȸ���ڵ�
	private String divCd;  //������ڵ�
	private String deptCd;  //�μ��ڵ�
	private String deptNm;  //�μ���
	private String deptZip;  //�����ȣ
	private String deptAddr;  //�ּ�
	private String deptAddr1;  //���ּ�
	private int parentDeptCd;  //�����μ��ڵ�
	private int deptLevel;		//�μ�����
	private String insertId;  //�����
	private Date insertDt = new Date();  //����� 
	private String insertIp;  //����� ip
	private String modifyId;  //������
	private Date modifyDt = new Date();  //������
	private String modifyIp;  //���� ip

	private String keyword; //�ӽð˻�����
}
