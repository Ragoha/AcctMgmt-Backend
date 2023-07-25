package kr.co.acctmgmt.converter;

import java.util.List;
import java.util.stream.Collectors;

import kr.co.acctmgmt.domain.BgtGr;
import kr.co.acctmgmt.dto.BgtGrDTO;

public class BgtGrConverter {

	public static BgtGrDTO convertToDto(BgtGr bgtGr) {
		
		BgtGrDTO bgtGrDTO = BgtGrDTO.builder()
				.coCd(bgtGr.getCoCd())
				.bgtGrCd(bgtGr.getBgtGrCd())
				.useYn(bgtGr.getUseYn())
				.bgtGrNm(bgtGr.getBgtGrNm())
				.insertId(bgtGr.getInsertId())
				.insertDt(bgtGr.getInsertDt())
				.insertId(bgtGr.getInsertIp())
				.modifyId(bgtGr.getModifyId())
				.modifyDt(bgtGr.getModifyDt())
				.modifyIp(bgtGr.getModifyIp())
				.build();
		
		return bgtGrDTO;
	}
	
	public static BgtGr convertToModel(BgtGrDTO bgtGrDTO) {
		
		BgtGr bgtGr = BgtGr.builder()
				.coCd(bgtGrDTO.getCoCd())
				.bgtGrCd(bgtGrDTO.getBgtGrCd())
				.useYn(bgtGrDTO.getUseYn())
				.bgtGrNm(bgtGrDTO.getBgtGrNm())
				.insertId(bgtGrDTO.getInsertId())
				.insertDt(bgtGrDTO.getInsertDt())
				.insertId(bgtGrDTO.getInsertIp())
				.modifyId(bgtGrDTO.getModifyId())
				.modifyDt(bgtGrDTO.getModifyDt())
				.modifyIp(bgtGrDTO.getModifyIp())
				.build();
		
		return bgtGr;
	}
	
	public static List<BgtGrDTO> convertToDtoList(List<BgtGr> bgtGrList){
		return bgtGrList.stream().map(BgtGrConverter::convertToDto).collect(Collectors.toList());
	}
	
	
}
