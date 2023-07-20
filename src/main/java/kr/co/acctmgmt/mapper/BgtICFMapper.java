package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.BgtICF;

public interface BgtICFMapper {

	BgtICF getBgtICF(BgtICF bgtICF);

	List<BgtICF> getBgtICFList();

	void insertBgtICF(BgtICF bgticf);

	void updateBgtICF(BgtICF bgticf);

	void deleteBgtICF(BgtICF bgticf);
}
