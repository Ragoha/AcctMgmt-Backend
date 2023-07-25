package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.dto.BgtGrDTO;

public interface BgtGrService {
	public List<BgtGrDTO> findBgtGrCdAndBgtGrNmByCoCd(BgtGrDTO bgtGrDTO);
}
