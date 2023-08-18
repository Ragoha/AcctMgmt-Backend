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
public class Dept {
	private String coCd;  //회사코드
	private String divCd;  //사업장코드
	private String deptCd;  //부서코드
	private String deptNm;  //부서명
	private String deptZip;  //우편번호
	private String deptAddr;  //주소
	private String deptAddr1;  //상세주소
	private int parentDeptCd;  //상위부서코드
	private int deptLevel;		//부서레벨
	private String insertId;  //등록자
	private Date insertDt = new Date();  //등록일 
	private String insertIp;  //등록자 ip
	private String modifyId;  //수정자
	private Date modifyDt = new Date();  //수정일
	private String modifyIp;  //수정 ip

	private String keyword; //임시검색변수
}
