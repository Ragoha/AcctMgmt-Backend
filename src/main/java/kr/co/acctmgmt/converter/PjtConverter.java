package kr.co.acctmgmt.converter;

import java.util.List;
import java.util.stream.Collectors;

import kr.co.acctmgmt.domain.Pjt;
import kr.co.acctmgmt.dto.PjtDTO;

public class PjtConverter {
	
	public static PjtDTO convertToDto(Pjt pjt) {
		
		PjtDTO pjtDTO = PjtDTO.builder()
				.coCd(pjt.getCoCd())
				.pgrCd(pjt.getPgrCd())
				.pgrNm(pjt.getPgrNm())
				.pjtCd(pjt.getPjtCd())
				.pjtNm(pjt.getPjtNm())
				.prDt(pjt.getPrDt())
				.toDt(pjt.getToDt())
				.progFg(pjt.getProgFg())
				.apjtNm(pjt.getApjtNm())
				.startDt(pjt.getStartDt())
				.note(pjt.getNote())
				.keyword(pjt.getKeyword())
				.build();
		
		return pjtDTO;
	}
	
	
	public static Pjt convertToModel(PjtDTO pjtDTO) {
		Pjt pjt = Pjt.builder()
				.coCd(pjtDTO.getCoCd())
				.pgrCd(pjtDTO.getPgrCd())
				.pgrNm(pjtDTO.getPgrNm())
				.pjtCd(pjtDTO.getPjtCd())
				.pjtNm(pjtDTO.getPjtNm())
				.prDt(pjtDTO.getPrDt())
				.toDt(pjtDTO.getToDt())
				.progFg(pjtDTO.getProgFg())
				.apjtNm(pjtDTO.getApjtNm())
				.startDt(pjtDTO.getStartDt())
				.note(pjtDTO.getNote())
				.keyword(pjtDTO.getKeyword())
				.build();
                
        return pjt;
    }
	
	public static List<PjtDTO> convertToDtoList(List<Pjt> pjtList){
		return pjtList.stream().map(PjtConverter::convertToDto).collect(Collectors.toList());
	}
}
