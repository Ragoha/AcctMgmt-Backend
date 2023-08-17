package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.converter.DivsConverter;
import kr.co.acctmgmt.domain.Co;
import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.dto.DivsDTO;
import kr.co.acctmgmt.mapper.DivsMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DivsServiceImpl implements DivsService{
	
	private final DivsMapper divsMapper;

	@Override
	public List<DivsDTO> findDivByCoCdAndKeyword(DivsDTO divsDTO) {
		Divs divs = DivsConverter.convertToModel(divsDTO);
		List<Divs> divsList = divsMapper.findDivByCoCdAndKeyword(divs);
		List<DivsDTO> divsDTOList = DivsConverter.convertToDtoList(divsList);
		return divsDTOList;
	}

	@Override
	public void insertDivs(Divs divs) {
		divsMapper.insertDivs(divs);
		
	}

	@Override
	public List<Divs> getDivsList() {
		List<Divs> divsList = divsMapper.getDivsList();
		return divsList;
	}

	@Override
	public List<Divs> getDivision(String coCd) {
		List<Divs> division = divsMapper.getDivision(coCd);
		return division;
	}

	@Override
	public void deleteDivs(String divCd) {
		divsMapper.deleteDivs(divCd);
	}

	@Override
	public void updateDivs(Divs divs) {
		divsMapper.updateDivs(divs);
	}

	@Override
	public List<Divs> getDivBydivCdAnddivNm(Divs divs) {
		List<Divs> searchDiv = divsMapper.getDivBydivCdAnddivNm(divs);
		return searchDiv;
	}

	@Override
	public List<Divs> getDiv(Divs divs) {
		List<Divs> division = divsMapper.getDiv(divs);
		return division;
	}

	@Override
	public Integer getCoCd(String divCd){
		Integer coCd = divsMapper.getCoCd(divCd);
		return coCd;
	}

	@Override
	public List<Divs> findDivByCoCd(String coCd) {
		
		return divsMapper.findDivByCoCd(coCd);
	}

}
