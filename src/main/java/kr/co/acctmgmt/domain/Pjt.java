package kr.co.acctmgmt.domain;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pjt {
	


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
		private Date insertDt;
		
//	    public void setPrDt(String prDtString) {
//            LocalDate localDate = LocalDate.parse(prDtString);
//            this.prDt = java.sql.Date.valueOf(localDate);
//        }
//
//        public void setToDt(String toDtString) {
//            LocalDate localDate = LocalDate.parse(toDtString);
//            this.toDt = java.sql.Date.valueOf(localDate);
//        }
//	    
	    private String keyword;



}
