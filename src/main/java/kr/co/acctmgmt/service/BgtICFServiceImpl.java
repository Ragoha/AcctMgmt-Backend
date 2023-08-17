package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.converter.BgtICFConverter;
import kr.co.acctmgmt.domain.BgtICF;
import kr.co.acctmgmt.dto.BgtICFDTO;
import kr.co.acctmgmt.mapper.BgtICFMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BgtICFServiceImpl implements BgtICFService{
	
	private final BgtICFMapper bgtICFMapper;

	@Override
	public BgtICFDTO getBgtICF(BgtICFDTO bgtICFDTO) {
		
		BgtICF bgtICF = BgtICFConverter.convertToModel(bgtICFDTO);

		BgtICF rBgtICF = bgtICFMapper.getBgtICF("ABC");

		
		return BgtICFConverter.convertToDto(rBgtICF);
	}

	@Override
	public List<BgtICFDTO> getBgtICFList(BgtICFDTO bgtICFDTO) {
		
		BgtICF bgtICF = BgtICFConverter.convertToModel(bgtICFDTO);
		
		System.out.println(bgtICF.toString());
		
		List<BgtICF> rBgtICF = bgtICFMapper.getBgtICFList(bgtICF);
		
		return BgtICFConverter.convertToDtoList(rBgtICF);
		
	}

	@Override
	public void insertBgtICF(BgtICFDTO bgtICFDTO) {
		
		bgtICFDTO.setCarrAm(bgtICFDTO.getCarrAm1() + bgtICFDTO.getCarrAm2() + bgtICFDTO.getCarrAm3());
		

		System.out.println(bgtICFDTO.toString());
		
		bgtICFMapper.insertBgtICF(BgtICFConverter.convertToModel(bgtICFDTO));
		
	}

	@Override
	public void updateBgtICF(BgtICFDTO bgtICFDTO) {
		
		Long sum = bgtICFDTO.getCarrAm1() + bgtICFDTO.getCarrAm2() + bgtICFDTO.getCarrAm3();
		bgtICFDTO.setCarrAm(sum);
		
		BgtICF bgtICF = BgtICFConverter.convertToModel(bgtICFDTO);
		System.out.println("¼öÁ¤Áß");
		System.out.println(bgtICF.toString());
		
		bgtICFMapper.updateBgtICF(BgtICFConverter.convertToModel(bgtICFDTO));
		
	}

	@Override
	public void deleteBgtICF(BgtICFDTO bgtICFDTO) {
		
		bgtICFMapper.deleteBgtICF(BgtICFConverter.convertToModel(bgtICFDTO));
		
	}

}
