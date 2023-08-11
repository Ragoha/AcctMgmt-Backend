package kr.co.acctmgmt.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import kr.co.acctmgmt.dto.PjtDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pjt {
	
//	private int coCd;		//�쉶�궗肄붾뱶
//	private int pgrCd;		//�봽濡쒖젥�듃洹몃９ 肄붾뱶
//	private String pgrNm; 	//�봽濡쒖젥�듃洹몃９ �씠由�
//	private String pjtCd;	//�봽濡쒖젥�듃肄붾뱶
//	private String pjtNm;   //�봽濡쒖젥�듃�씠由�
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date prDt= new Date(); //�봽濡쒖젥�듃 �떆�옉�씪
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date toDt= new Date();//�봽濡쒖젥�듃 醫낅즺�씪
//	private String progFg; //�봽濡쒖젥�듃 吏꾪뻾�긽�깭
//	private String apjtNm; //�봽濡쒖젥�듃 以꾩엫留�
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date stDt= new Date();//�봽濡쒖젥�듃 �떆�옉�씪2
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

	    
	    private String keyword;



}
