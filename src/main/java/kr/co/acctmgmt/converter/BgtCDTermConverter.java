package kr.co.acctmgmt.converter;

import java.util.List;
import java.util.stream.Collectors;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.domain.BgtICF;
import kr.co.acctmgmt.dto.BgtCDDTO;
import kr.co.acctmgmt.dto.BgtCDTermDTO;
import kr.co.acctmgmt.dto.BgtICFDTO;

public class BgtCDTermConverter {
	public static BgtCDTermDTO convertToDto(BgtCDTerm bgtCDTerm) {
		BgtCDTermDTO bgtCDDTO = BgtCDTermDTO.builder()
				.coCd(bgtCDTerm.getCoCd())
				.divFg(bgtCDTerm.getDivFg())
				.defNm(bgtCDTerm.getDefNm())
				.build();
		return bgtCDDTO;
	}
	public static BgtCDTerm convertToModel(BgtCDTermDTO bgtCDTermDTO) {
		BgtCDTerm bgtCDTerm = BgtCDTerm.builder()
				.coCd(bgtCDTermDTO.getCoCd())
				.divFg(bgtCDTermDTO.getDivFg())
				.defNm(bgtCDTermDTO.getDefNm())
				.build();
		
		return bgtCDTerm;
	}
	public static List<BgtCDTermDTO> convertToDtoList(List<BgtCDTerm> bgtCDTerms){
		return bgtCDTerms.stream().map(BgtCDTermConverter::convertToDto).collect(Collectors.toList());
	}
}
