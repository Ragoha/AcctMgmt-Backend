package kr.co.acctmgmt.service;

import java.util.List;

import kr.co.acctmgmt.domain.Gisu;
import kr.co.acctmgmt.dto.GisuDTO;

public interface GisuService {
	
	public List<GisuDTO> findGisuByCoCd(GisuDTO gisuDTO);

	public void deleteGisu(GisuDTO gisuDTO);

	public void updateGisu(GisuDTO gisuDTO);

	public void insertGisu(GisuDTO gisuDTO);
	
}
