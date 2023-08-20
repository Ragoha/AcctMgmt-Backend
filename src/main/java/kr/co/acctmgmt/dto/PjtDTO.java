package kr.co.acctmgmt.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PjtDTO {

		private String coCd;
	    private String pgrCd;
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
