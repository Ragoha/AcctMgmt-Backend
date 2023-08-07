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
		
		bgtICFMapper.insertBgtICF(BgtICFConverter.convertToModel(bgtICFDTO));
		
	}

	@Override
	public void updateBgtICF(BgtICFDTO bgtICFDTO) {
		
		Long sum = bgtICFDTO.getCarrAm() + bgtICFDTO.getCarrAm1();
		bgtICFDTO.setCarrAm2(sum);
		
		BgtICF bgtICF = BgtICFConverter.convertToModel(bgtICFDTO);
		
		bgtICFMapper.updateBgtICF(BgtICFConverter.convertToModel(bgtICFDTO));
		
	}

	@Override
	public void deleteBgtICF(BgtICFDTO bgtICFDTO) {
		
		bgtICFMapper.deleteBgtICF(BgtICFConverter.convertToModel(bgtICFDTO));
		
	}

}
