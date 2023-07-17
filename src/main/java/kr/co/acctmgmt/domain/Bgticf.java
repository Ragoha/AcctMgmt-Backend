package kr.co.acctmgmt.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bgticf{

	private String coCd;		//ȸ�� �ڵ�
	private String gisu;		//���
	private int sq;			//����
	private String divCd;		//����� �ڵ�
	private String deptCd;		//�μ� �ڵ�
	private String mgtCd;		//������Ʈ(����)�μ�
	private String bgtCd;		//���� �ڵ�
	private String bgtFg;		//���� ����
	private String bgtCnt;		//���� ����
	private String bottomCd;	//��������ڵ�
	private Long carrAm;		//�̿� �ݾ�
	private Long carrAm1;		//����̿��ݾ�
	private Long carrAm2;		//����̿��ݾ�
	private Long carrAm3;		//������̿��ݾ�
//		private Long bjYn;			//���������뿩��
//		private Long fillDt;		//���γ�¥
	private String empCd;		//����ڵ�
	private String remDc;		//����
	private String bgtTy;		//�ݾ׹ݿ� ���� 1.�����̿�, 2.�����Է�
	private String insertId;	//�����
	private Date insertDt;		//�������
	private String insertIp;	//����� IP
	private String modifyId;	//������
	private Date modifyDt;	//��������
	private String modifyIp;	//������ IP

}
