package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.converter.GisuConverter;
import kr.co.acctmgmt.domain.Gisu;
import kr.co.acctmgmt.dto.GisuDTO;
import kr.co.acctmgmt.mapper.GisuMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GisuServiceImpl implements GisuService{

	
	private final GisuMapper gisuMapper;
	
	
	@Override
	public List<GisuDTO> findGisuByCoCd(GisuDTO gisuDTO) {
		
		System.out.println(gisuDTO.toString());
		
		Gisu gisu = GisuConverter.convertToModel(gisuDTO);
		
		List<Gisu> rGisuList = gisuMapper.findGisuByCoCd(gisu);
		
		System.out.println(rGisuList.toString());
		
		return GisuConverter.convertToDtoList(rGisuList);
	}


	@Override
	public void deleteGisu(GisuDTO gisuDTO) {
		
		Gisu gisu = GisuConverter.convertToModel(gisuDTO);
		
		gisuMapper.deleteGisu(gisu);
		
	}

}
