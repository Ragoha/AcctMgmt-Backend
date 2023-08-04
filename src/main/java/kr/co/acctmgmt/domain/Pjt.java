package kr.co.acctmgmt.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pjt {
	
	private int coCd;		//ȸ���ڵ�
	private int pgrCd ;		//������Ʈ�׷� �ڵ�
	private String pgrNm; 	//������Ʈ�׷� �̸�
	private String pjtCd;	//������Ʈ�ڵ�
	private String pjtNM;   //������Ʈ�̸�
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prDt= new Date(); //������Ʈ ������
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date toDt= new Date();//������Ʈ ������
	private String progFg; //������Ʈ �������
	private String apjtNm; //������Ʈ ���Ӹ�
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date stDt= new Date();//������Ʈ ������2
	
}
