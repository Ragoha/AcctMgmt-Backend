package kr.co.acctmgmt.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@Builder
public class Pjt {
	
//	private int coCd;		//ȸ���ڵ�
//	private int pgrCd;		//������Ʈ�׷� �ڵ�
//	private String pgrNm; 	//������Ʈ�׷� �̸�
//	private String pjtCd;	//������Ʈ�ڵ�
//	private String pjtNm;   //������Ʈ�̸�
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date prDt= new Date(); //������Ʈ ������
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date toDt= new Date();//������Ʈ ������
//	private String progFg; //������Ʈ �������
//	private String apjtNm; //������Ʈ ���Ӹ�
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date stDt= new Date();//������Ʈ ������2
//	private String note;

	    private int coCd;
	    private int pgrCd;
	    private String pgrNm;
	    private String pjtCd;
	    private String pjtNm;
	    private Date prDt;
	    private Date toDt;
	    private String progFg;
	    private String apjtNm;
	    private Date startDt;
	    private String note;
		public void setFormattedPrDt(String formattedPrDt) {
			// TODO Auto-generated method stub
			
		}

	    // Getter�� Setter �޼��� ����

}
