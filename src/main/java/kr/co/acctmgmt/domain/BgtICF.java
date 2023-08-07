package kr.co.acctmgmt.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class BgtICF {

    private int coCd = 0;
    private int divCd = 0;
    private int deptCd = 0;
    private int gisu = 0;
    private int sq = 0;
    private int mgtCd = 0;
    private String bgtCd = "";
    private int bgtFg = 0;
    private String bottomNm ="";
    private Long carrAm = 0L;
    private Long carrAm1 = 0L;;
    private Long carrAm2 = 0L;;
    private Long carrAm3 = 0L;;
    private int empCd = 0;
    private String remDc = "";
    private String bgtTy = "";
    private String insertId = "";
    private Date insertDt = new Date();
    private String insertIp = "127.0.0.1";
    private String modifyId = "";
    private Date modifyDt = new Date();
    private String modifyIp = "127.0.0.1";
    
}
