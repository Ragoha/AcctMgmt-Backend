package kr.co.acctmgmt.converter;

import java.util.Date;

import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.dto.BgtCDDTO;

public class BgtCDConverter {
	
	public static BgtCDDTO convertToDto(BgtCD bgtcdDomain) {
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
				.insertId(bgtcdDomain.getInsertId())
				.insertDt(bgtcdDomain.getInsertDt())
				.insertIp(bgtcdDomain.getInsertIp())
				.modifyId(bgtcdDomain.getModifyId())
				.modifyDt(bgtcdDomain.getModifyDt())
				.modifyIp(bgtcdDomain.getModifyIp())
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
                .insertId(bgtcdDTO.getInsertId())
                .insertDt(bgtcdDTO.getInsertDt())
                .insertIp(bgtcdDTO.getInsertIp())
                .modifyId(bgtcdDTO.getModifyId())
                .modifyDt(bgtcdDTO.getModifyDt())
                .modifyIp(bgtcdDTO.getModifyIp())
                .build();

        return bgtCDDomain;
    }
}
