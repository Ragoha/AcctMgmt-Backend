package kr.co.acctmgmt.converter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.dto.BgtCDDTO;
import kr.co.acctmgmt.dto.BgtCDTermDTO;

public class BgtCDConverter {
	
	public static BgtCDDTO convertToDto(BgtCD bgtcdDomain) { /////
		BgtCDDTO bgtCDDTO = BgtCDDTO.builder()
				.coCd(bgtcdDomain.getCoCd())
				.bgtCd(bgtcdDomain.getBgtCd())
				.gisu(bgtcdDomain.getGisu())
				.bgtNm(bgtcdDomain.getBgtNm())
				.divFg(bgtcdDomain.getDivFg())
				.ctlFg(bgtcdDomain.getCtlFg())
				.bgajustFg(bgtcdDomain.getBgajustFg())
				.defNm(bgtcdDomain.getDefNm())
				.toDt(bgtcdDomain.getToDt())
				.bottomFg(bgtcdDomain.getBottomFg())
				.bizFg(bgtcdDomain.getBizFg())
				.groupCd(bgtcdDomain.getGroupCd())
				.grFg(bgtcdDomain.getGrFg())
				.insertId(bgtcdDomain.getInsertId())
				.insertDt(bgtcdDomain.getInsertDt())
				.insertIp(bgtcdDomain.getInsertIp())
				.modifyId(bgtcdDomain.getModifyId())
				.modifyDt(bgtcdDomain.getModifyDt())
				.modifyIp(bgtcdDomain.getModifyIp())
				.bgtGrNm(bgtcdDomain.getBgtGrNm())
				.dataPath(bgtcdDomain.getDataPath())
				.carrAm(bgtcdDomain.getCarrAm())
				.divCd(bgtcdDomain.getDivCd())
				.divNm(bgtcdDomain.getDivNm())
				.bgtGrCdList(bgtcdDomain.getBgtGrCdList())
				.build();
		return bgtCDDTO;
	}
	public static BgtCD convertToModel(BgtCDDTO bgtcdDTO) {
        BgtCD bgtCDDomain = BgtCD.builder()
                .coCd(bgtcdDTO.getCoCd())
                .bgtCd(bgtcdDTO.getBgtCd())
                .gisu(bgtcdDTO.getGisu())
                .bgtNm(bgtcdDTO.getBgtNm())
                .divFg(bgtcdDTO.getDivFg())
                .defNm(bgtcdDTO.getDefNm())
                .ctlFg(bgtcdDTO.getCtlFg())
                .bgajustFg(bgtcdDTO.getBgajustFg())
                .toDt(bgtcdDTO.getToDt())
                .bottomFg(bgtcdDTO.getBottomFg())
                .bizFg(bgtcdDTO.getBizFg())
                .groupCd(bgtcdDTO.getGroupCd())
                .grFg(bgtcdDTO.getGrFg())
                .insertId(bgtcdDTO.getInsertId())
                .insertDt(bgtcdDTO.getInsertDt())
                .insertIp(bgtcdDTO.getInsertIp())
                .modifyId(bgtcdDTO.getModifyId())
                .modifyDt(bgtcdDTO.getModifyDt())
                .modifyIp(bgtcdDTO.getModifyIp())
				.keyword(bgtcdDTO.getKeyword())
				.bgtGrNm(bgtcdDTO.getBgtGrNm())
				.dataPath(bgtcdDTO.getDataPath())
				.carrAm(bgtcdDTO.getCarrAm())
				.divCd(bgtcdDTO.getDivCd())
				.divNm(bgtcdDTO.getDivNm())
				.bgtGrCdList(bgtcdDTO.getBgtGrCdList())
                .build();

        return bgtCDDomain;
    }
	
	public static List<BgtCDDTO> convertToDtoList(List<BgtCD> bgtCDList){
		return bgtCDList.stream().map(BgtCDConverter::convertToDto).collect(Collectors.toList());
	}
}
