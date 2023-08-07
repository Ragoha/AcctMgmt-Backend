package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.dto.BgtICFDTO;

public interface BgtICFService {

	BgtICFDTO getBgtICF(BgtICFDTO bgtICFDTO);

	List<BgtICFDTO> getBgtICFList(BgtICFDTO bgtICFDTO);

	void insertBgtICF(BgtICFDTO bgtICFDTO);

	void updateBgtICF(BgtICFDTO bgtICFDTO);

	void deleteBgtICF(BgtICFDTO bgtICFDTO);
	
}
