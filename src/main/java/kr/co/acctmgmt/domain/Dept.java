package kr.co.acctmgmt.domain;

import java.util.Date;

public class Dept {
	private int coCd;  //ȸ���ڵ�
	private int divCd;  //������ڵ�
	private int deptCd;  //�μ��ڵ�
	private String deptNm;  //�μ���
	private int parentDeptCd;  //�����μ��ڵ�
	private int deptLevel;		//�μ�����
	private String insertId;  //�����
	private Date insertDt = new Date();  //����� 
	private String insertIp;  //����� ip
	private String modifyId;  //������
	private Date modifyDt = new Date();  //������
	private String modifyIp;  //���� ip

}
