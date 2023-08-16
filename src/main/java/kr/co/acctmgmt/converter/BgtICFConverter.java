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
			.divCd(bgtICF.getDivCd())
			.deptCd(bgtICF.getDeptCd())
			.gisu(bgtICF.getGisu())
			.sq(bgtICF.getSq())
			.mgtCd(bgtICF.getMgtCd())
			.bgtCd(bgtICF.getBgtCd())
			.bgtFg(bgtICF.getBgtFg())
			.bottomNm(bgtICF.getBottomNm())
			.carrAm(bgtICF.getCarrAm())
			.carrAm1(bgtICF.getCarrAm1())
			.carrAm2(bgtICF.getCarrAm2())
			.carrAm3(bgtICF.getCarrAm3())
			.empCd(bgtICF.getEmpCd())
			.remDc(bgtICF.getRemDc())
			.bgtTy(bgtICF.getBgtTy())
			.insertId(bgtICF.getInsertId())
			.insertDt(bgtICF.getInsertDt())
			.insertIp(bgtICF.getInsertIp())
			.modifyId(bgtICF.getModifyId())
			.modifyDt(bgtICF.getModifyDt())
			.modifyIp(bgtICF.getModifyIp())
			.mgtNm(bgtICF.getMgtNm())
			.empName(bgtICF.getEmpName())
			.build();
	

		return bgtICFDTO;
	}
	
	public static BgtICF convertToModel(BgtICFDTO bgtICFDTO) {
		System.out.println("ÄÁ¹öÅÍ");
		System.out.println(bgtICFDTO.toString());
		BgtICF bgtICF = BgtICF.builder()
				.coCd(bgtICFDTO.getCoCd())
				.divCd(bgtICFDTO.getDivCd())
				.deptCd(bgtICFDTO.getDeptCd())
				.gisu(bgtICFDTO.getGisu())
				.sq(bgtICFDTO.getSq())
				.mgtCd(bgtICFDTO.getMgtCd())
				.bgtCd(bgtICFDTO.getBgtCd())
				.bgtFg(bgtICFDTO.getBgtFg())
				.bottomNm(bgtICFDTO.getBottomNm())
				.carrAm(bgtICFDTO.getCarrAm())
				.carrAm1(bgtICFDTO.getCarrAm1())
				.carrAm2(bgtICFDTO.getCarrAm2())
				.carrAm3(bgtICFDTO.getCarrAm3())
				.empCd(bgtICFDTO.getEmpCd())
				.remDc(bgtICFDTO.getRemDc())
				.bgtTy(bgtICFDTO.getBgtTy())
				.insertId(bgtICFDTO.getInsertId())
				.insertDt(bgtICFDTO.getInsertDt())
				.insertIp(bgtICFDTO.getInsertIp())
				.modifyId(bgtICFDTO.getModifyId())
				.modifyDt(bgtICFDTO.getModifyDt())
				.modifyIp(bgtICFDTO.getModifyIp())
				.mgtNm(bgtICFDTO.getMgtNm())
				.empName(bgtICFDTO.getEmpName())
				.build();
		
		return bgtICF;
	}
	
	public static List<BgtICFDTO> convertToDtoList(List<BgtICF> bgtICFs){
		return bgtICFs.stream().map(BgtICFConverter::convertToDto).collect(Collectors.toList());
	}
}
