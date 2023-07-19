package kr.co.acctmgmt.converter;

import java.util.List;
import java.util.stream.Collectors;

import kr.co.acctmgmt.domain.BgtICF;
import kr.co.acctmgmt.domain.Employee;
import kr.co.acctmgmt.dto.BgtICFDTO;

public class BgtICFConverter {

public static BgtICFDTO convertToDto(BgtICF bgtICF) {
		
	BgtICFDTO bgtICFDTO = BgtICFDTO.builder()
				.build();
		
		return bgtICFDTO;
	}
	
	public static BgtICF convertToModel(BgtICFDTO bgtICFDTO) {
		BgtICF bgtICF = BgtICF.builder()
				.build();
		
		return bgtICF;
	}
	
	public static List<BgtICFDTO> convertToDtoList(List<BgtICF> bgtICFs){
		return bgtICFs.stream().map(BgtICFConverter::convertToDto).collect(Collectors.toList());
	}
}
