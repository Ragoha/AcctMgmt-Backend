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
	
//	private int coCd;		//회사코드
//	private int pgrCd;		//프로젝트그룹 코드
//	private String pgrNm; 	//프로젝트그룹 이름
//	private String pjtCd;	//프로젝트코드
//	private String pjtNm;   //프로젝트이름
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date prDt= new Date(); //프로젝트 시작일
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date toDt= new Date();//프로젝트 종료일
//	private String progFg; //프로젝트 진행상태
//	private String apjtNm; //프로젝트 줄임말
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date stDt= new Date();//프로젝트 시작일2
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

	    // Getter와 Setter 메서드 생략

}
