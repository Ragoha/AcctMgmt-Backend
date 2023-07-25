package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.converter.DivsConverter;
import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.dto.DivsDTO;
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

	@Override
	public List<DivsDTO> findDivCdAndDivNmByCoCdAndKeyword(DivsDTO divsDTO) {
		
		Divs divs = DivsConverter.convertToModel(divsDTO);
		
		List<Divs> divsList = divsMapper.findDivCdAndDivNmByCoCdAndKeyword(divs);
		
		List<DivsDTO> divsDTOList = DivsConverter.convertToDtoList(divsList);
		return divsDTOList;
	}

}
