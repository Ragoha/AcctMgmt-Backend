package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.dto.BgtCDTermDTO;

public interface BgtCDService {
	//GroupCD로 데이터 조회 => 임시값 넣어서 떄우는 중 ..[230727]
	public List<BgtCD> getBGTCDData(String groupcd);

	//GroupCD로 데이터를 조회하기 전ㅇ 

//	public String getDefNmFromBGTCD_TERM(int divFg);

	public List<BgtCD> getDetailInfo(String bgt_Cd);

	public void updateDetailInfo(BgtCD updateData);

	public void deleteRow(String bgtCd);

	public List<BgtCDTermDTO> getBgtCDTerm(String CO_CD);

	public List<BgtCDTermDTO> updateBgtCDTerm(List<BgtCDTermDTO> dataList);

}
