package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtICF;

public interface BgtICFMapper {

	BgtICF getBgtICF(String coCd);

	List<BgtICF> getBgtICFList(BgtICF bgtICF);

	void insertBgtICF(BgtICF bgticf);

	void updateBgtICF(BgtICF bgticf);

	void deleteBgtICF(BgtICF bgticf);
	
	double getSumBgtICFByCoCdAndBgtCd(BgtCD bgtCD);
}
