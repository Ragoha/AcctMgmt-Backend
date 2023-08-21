package kr.co.acctmgmt.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class BgtICFDTO {

	private String coCd = "";
    private String divCd = "";
    private String deptCd = "";
    private int gisu = 0;
    private int sq = 0;
    private String mgtCd = "";
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
    private String groupCd = "";
    
    private String mgtNm = "";
    private String empName = "";
    private List<String> sqList = new ArrayList();
}
