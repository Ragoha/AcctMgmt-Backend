package kr.co.acctmgmt.converter;

import java.util.List;
import java.util.stream.Collectors;

import kr.co.acctmgmt.domain.BgtICF;
import kr.co.acctmgmt.domain.Employee;
import kr.co.acctmgmt.dto.BgtICFDTO;

public class BgtICFConverter {

public static BgtICFDTO convertToDto(BgtICF bgtICF) {
		
	BgtICFDTO bgtICFDTO = BgtICFDTO.builder()
			.coCd(bgtICF.getCoCd())
			.gisu(bgtICF.getGisu())
			.sq(bgtICF.getSq())
			.divCd(bgtICF.getDivCd())
			.deptCd(bgtICF.getDeptCd())
			.mgtCd(bgtICF.getMgtCd())
			.bgtCd(bgtICF.getBgtCd())
			.bgtFg(bgtICF.getBgtFg())
			.bgtCnt(bgtICF.getBgtCnt())
			.bottomCd(bgtICF.getBottomCd())
			.carrAm(bgtICF.getCarrAm())
			.carrAm1(bgtICF.getCarrAm1())
			.carrAm2(bgtICF.getCarrAm2())
			.carrAm3(bgtICF.getCarrAm3())
			.empCd(bgtICF.getEmpCd())
			.remDc(bgtICF.getRemDc())
			.bgtTy(bgtICF.getBgtTy())
			.insertId(bgtICF.getInsertId())
			.insertDt(bgtICF.getInsertDt())
			.insertId(bgtICF.getInsertIp())
			.modifyId(bgtICF.getModifyId())
			.modifyDt(bgtICF.getModifyDt())
			.modifyIp(bgtICF.getModifyIp())
			.build();
		
		return bgtICFDTO;
	}
	
	public static BgtICF convertToModel(BgtICFDTO bgtICFDTO) {
		BgtICF bgtICF = BgtICF.builder()
				.coCd(bgtICFDTO.getCoCd())
				.gisu(bgtICFDTO.getGisu())
				.sq(bgtICFDTO.getSq())
				.divCd(bgtICFDTO.getDivCd())
				.deptCd(bgtICFDTO.getDeptCd())
				.mgtCd(bgtICFDTO.getMgtCd())
				.bgtCd(bgtICFDTO.getBgtCd())
				.bgtFg(bgtICFDTO.getBgtFg())
				.bgtCnt(bgtICFDTO.getBgtCnt())
				.bottomCd(bgtICFDTO.getBottomCd())
				.carrAm(bgtICFDTO.getCarrAm())
				.carrAm1(bgtICFDTO.getCarrAm1())
				.carrAm2(bgtICFDTO.getCarrAm2())
				.carrAm3(bgtICFDTO.getCarrAm3())
				.empCd(bgtICFDTO.getEmpCd())
				.remDc(bgtICFDTO.getRemDc())
				.bgtTy(bgtICFDTO.getBgtTy())
				.insertId(bgtICFDTO.getInsertId())
				.insertDt(bgtICFDTO.getInsertDt())
				.insertId(bgtICFDTO.getInsertIp())
				.modifyId(bgtICFDTO.getModifyId())
				.modifyDt(bgtICFDTO.getModifyDt())
				.modifyIp(bgtICFDTO.getModifyIp())
				.build();
		
		return bgtICF;
	}
	
	public static List<BgtICFDTO> convertToDtoList(List<BgtICF> bgtICFs){
		return bgtICFs.stream().map(BgtICFConverter::convertToDto).collect(Collectors.toList());
	}
}
