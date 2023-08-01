package kr.co.acctmgmt.converter;

import java.util.List;
import java.util.stream.Collectors;

import kr.co.acctmgmt.domain.Gisu;
import kr.co.acctmgmt.dto.GisuDTO;

public class GisuConverter {
	public static GisuDTO convertToDto(Gisu gisu) {
		
		GisuDTO gisuDTO = GisuDTO.builder()
				.coCd(gisu.getCoCd())
				.gisu(gisu.getGisu())
				.frDt(gisu.getFrDt())
				.toDt(gisu.getToDt())
				.insertId(gisu.getInsertId())
				.insertDt(gisu.getInsertDt())
				.insertId(gisu.getInsertIp())
				.modifyId(gisu.getModifyId())
				.modifyDt(gisu.getModifyDt())
				.modifyIp(gisu.getModifyIp())
				.build();
		
		return gisuDTO;
	}
	
	
	public static Gisu convertToModel(GisuDTO gisuDTO) {
		Gisu gisu = Gisu.builder()
				.coCd(gisuDTO.getCoCd())
				.gisu(gisuDTO.getGisu())
				.frDt(gisuDTO.getFrDt())
				.toDt(gisuDTO.getToDt())
				.insertId(gisuDTO.getInsertId())
				.insertDt(gisuDTO.getInsertDt())
				.insertId(gisuDTO.getInsertIp())
				.modifyId(gisuDTO.getModifyId())
				.modifyDt(gisuDTO.getModifyDt())
				.modifyIp(gisuDTO.getModifyIp())
				.build();
                
        return gisu;
    }
	
	public static List<GisuDTO> convertToDtoList(List<Gisu> gisuList){
		return gisuList.stream().map(GisuConverter::convertToDto).collect(Collectors.toList());
	}
}
