package kr.co.acctmgmt.converter;

import java.util.List;
import java.util.stream.Collectors;

import kr.co.acctmgmt.domain.Divs;
import kr.co.acctmgmt.dto.DivsDTO;

public class DivsConverter {
	
	public static DivsDTO convertToDto(Divs divs) {
		
		DivsDTO divsDTO = DivsDTO.builder()
				.coCd(divs.getCoCd())
				.divCd(divs.getDivCd())
				.divNm(divs.getDivNm())
				.jongmok(divs.getJongmok())
				.businessType(divs.getBusinessType())
				.divNb(divs.getDivNb())
				.ceoNm(divs.getCeoNm())
				.toNb(divs.getToNb())
				.divZip(divs.getDivZip())
				.divAddr(divs.getDivAddr())
				.divAddr1(divs.getDivAddr1())
				.insertId(divs.getInsertId())
				.insertDt(divs.getInsertDt())
				.insertIp(divs.getInsertIp())
				.modifyId(divs.getModifyId())
				.modifyDt(divs.getModifyDt())
				.modifyIp(divs.getModifyIp())
				.keyword(divs.getKeyword())
				.build();
		
		return divsDTO;
				
	}
	
	public static Divs convertToModel(DivsDTO divsDTO) {
		
		Divs divs = Divs.builder()
				.coCd(divsDTO.getCoCd())
				.divCd(divsDTO.getDivCd())
				.divNm(divsDTO.getDivNm())
				.jongmok(divsDTO.getJongmok())
				.businessType(divsDTO.getBusinessType())
				.divNb(divsDTO.getDivNb())
				.ceoNm(divsDTO.getCeoNm())
				.toNb(divsDTO.getToNb())
				.divZip(divsDTO.getDivZip())
				.divAddr(divsDTO.getDivAddr())
				.divAddr1(divsDTO.getDivAddr1())
				.insertId(divsDTO.getInsertId())
				.insertDt(divsDTO.getInsertDt())
				.insertIp(divsDTO.getInsertIp())
				.modifyId(divsDTO.getModifyId())
				.modifyDt(divsDTO.getModifyDt())
				.modifyIp(divsDTO.getModifyIp())
				.keyword(divsDTO.getKeyword())
				.build();
		
		return divs;
				
	}
	
	public static List<DivsDTO> convertToDtoList(List<Divs> DivsList){
		return DivsList.stream().map(DivsConverter::convertToDto).collect(Collectors.toList());
	}

}
