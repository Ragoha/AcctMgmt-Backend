package kr.co.acctmgmt.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Gisu {

    private int coCd;
    private int gisu;
    private Date frDt;
    private Date toDt;
    private String insertId;
    private Date insertDt;
    private String insertIp;
    private String modifyId;
    private Date modifyDt;
    private String modifyIp;
    
}
