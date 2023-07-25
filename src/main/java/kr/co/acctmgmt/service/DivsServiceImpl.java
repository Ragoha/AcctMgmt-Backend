package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.mapper.DivsMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DivsServiceImpl implements DivsService{
	
	
	private final DivsMapper divsMapper;

	@Override
	public List<Divs> findDivCdAndDivNmByCoCd(int coCd) {
		
		List<Divs> divss = divsMapper.findDivCdAndDivNmByCoCd(coCd);
		
		return divss;
	}

}
