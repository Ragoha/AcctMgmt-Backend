package kr.co.acctmgmt.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class BgtICFDTO {

    private String coCd = "";
    private int gisu = 0;
    private int sq = 0;
    private String divCd = "";
    private String deptCd = "";
    private String mgtCd = "";
    private String bgtCd = "";
    private String bgtFg = "";
    private String bgtCnt = "";
    private String bottomCd ="";
    private Long carrAm = 0L;
    private Long carrAm1 = 0L;;
    private Long carrAm2 = 0L;;
    private Long carrAm3 = 0L;;
    private String empCd = "";
    private String remDc = "";
    private String bgtTy = "";
    private String insertId = "";
    private Date insertDt = new Date();
    private String insertIp = "127.0.0.1";
    private String modifyId = "";
    private Date modifyDt = new Date();
    private String modifyIp = "127.0.0.1";
    
	
}