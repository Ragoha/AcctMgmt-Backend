package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.BgtGr;
import kr.co.acctmgmt.dto.BgtGrDTO;

public interface BgtGrService {
	
	public List<BgtGrDTO> findBgtGrCdAndBgtGrNmByCoCd(BgtGrDTO bgtGrDTO);
	
	public List<BgtGrDTO> findBgtGrByCoCdAndKeyword(BgtGrDTO bgtGrDTO);

	public List<BgtGrDTO> findBgtGrByCoCd(BgtGrDTO bgtGrDTO);

	public void deleteBgtGr(BgtGrDTO bgtGrDTO);

	public void updateBgtGr(BgtGrDTO bgtGrDTO);

	public void insertBgtGr(BgtGrDTO bgtGrDTO);
}
