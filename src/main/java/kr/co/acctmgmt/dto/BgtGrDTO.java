package kr.co.acctmgmt.dto;

import java.util.Date;

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
public class BgtGrDTO {

	private int coCd;
	private int bgtGrCd;
	private String useYn;
	private String bgtGrNm;
    private String insertId;
    private Date insertDt;
    private String insertIp;
    private String modifyId;
    private Date modifyDt;
    private String modifyIp;
    
    private String keyword;
    
}
