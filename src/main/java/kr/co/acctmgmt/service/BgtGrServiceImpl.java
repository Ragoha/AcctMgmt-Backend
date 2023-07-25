package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.converter.BgtGrConverter;
import kr.co.acctmgmt.domain.BgtGr;
import kr.co.acctmgmt.dto.BgtGrDTO;
import kr.co.acctmgmt.mapper.BgtGrMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BgtGrServiceImpl implements BgtGrService {
	
	private final BgtGrMapper bgtGrMapper;
	
	@Override
	public List<BgtGrDTO> findBgtGrCdAndBgtGrNmByCoCd(BgtGrDTO bgtGrDTO) {
		
		List<BgtGr> rBgtGrList = bgtGrMapper.findBgtGrCdAndBgtGrNmByCoCd(bgtGrDTO.getCoCd());
		
		List<BgtGrDTO> rBgtGrDTOList = BgtGrConverter.convertToDtoList(rBgtGrList);
		
		return rBgtGrDTOList;
	}

}
