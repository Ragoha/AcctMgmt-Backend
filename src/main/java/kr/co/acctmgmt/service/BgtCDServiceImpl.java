package kr.co.acctmgmt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.converter.BgtCDConverter;
import kr.co.acctmgmt.converter.BgtCDTermConverter;
import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtCDTerm;
import kr.co.acctmgmt.dto.BgtCDDTO;
import kr.co.acctmgmt.dto.BgtCDTermDTO;
import kr.co.acctmgmt.mapper.BgtCDMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BgtCDServiceImpl implements BgtCDService {

	private final BgtCDMapper mapper;

	@Override
	public List<BgtCD> getBGTCDData(String groupcd) {
		List<BgtCD> list = mapper.getBGTCDData(groupcd); // defNm�씠 �븘�슂�븿 .
		System.out.println("Service�쓽 getBGTCDData �떆�옉.");
		System.out.println("groupCd�뒗 ?" + groupcd);
		for (int i = 0; i < list.size(); i++) {
			// 蹂��닔�꽑�뼵
			String space = " ";
			String dataPath = "";
			// 1.�닔�엯�닔異쒖뿬遺� �솗�씤
			String inOut = list.get(i).getGrFg();
			// 2-1.�닔�엯�씠硫�..
			if (inOut.equals("0")) {
				dataPath = dataPath + "수입";
			// 2-2.�닔異쒖씠硫�..
			} else if (inOut.equals("1")) {
				dataPath = dataPath + "수출";
			} else {
				System.out.println("null�뱾�뼱�샂 臾몄젣�엳�쓬.");
			}
			// 3.path 寃쎈줈瑜� 媛��졇�삤�뒗 濡쒖쭅
			// 3-1. path �닽�옄
			int cycle = Integer.parseInt(list.get(i).getDivFg()); // 諛섎났�릺�뼱�빞 �븷 �닽�옄

			for (int j = 1; j < cycle + 1; j++) {
				BgtCD tempBgtCD = new BgtCD();
				String divFg = j + "lv";
				tempBgtCD.setDivFg(divFg); // list.get(0).setDivFg(j);
				tempBgtCD.setCoCd(list.get(i).getCoCd());
				String defNm = mapper.getDataPath(tempBgtCD);
				dataPath = dataPath + "," + defNm;
			}
			if(list.get(i).getMultiCk()==1) {
				for(int k=0 ;k<list.get(i).getMultiNum();k++) {
					dataPath=dataPath + space;
				}
			}
			list.get(i).setDataPath(dataPath);
		}
		return list;
	}
//
//	@Override
//	public String getDefNmFromBGTCD_TERM(int divFg) {
//		return mapper.getDefNmFromBGTCD_TERM(divFg);
//	}

	@Override
	public List<BgtCD> getDetailInfo(String bgt_Cd) {
		List<BgtCD> list = mapper.getDetailInfo(bgt_Cd);
		return list;
	}

	@Override
	public void updateDetailInfo(BgtCD updateData) {
		mapper.updateDetailInfo(updateData);
	}

	@Override
	public void deleteRow(String bgtCd) {
		mapper.deleteRow(bgtCd);

	}

	@Override
	public List<BgtCDTermDTO> getBgtCDTerm(String CO_CD) {
		System.out.println("Service�쓽 getBgtCDTerm");
		List<BgtCDTerm> list = mapper.getBgtCDTerm(CO_CD);
		return BgtCDTermConverter.convertToDtoList(list);
	}

	@Override
	public List<BgtCDTermDTO> updateBgtCDTerm(List<BgtCDTermDTO> dataList) {
		String coCD = Integer.toString(dataList.get(1).getCoCd());
		for (BgtCDTermDTO data : dataList) {
			System.out.println("for-each loop : " + data);
			BgtCDTerm temp = BgtCDTermConverter.convertToModel(data);
			mapper.updateBgtCDTerm(temp);
		}
		List<BgtCDTerm> list = mapper.getBgtCDTerm(coCD);

		return BgtCDTermConverter.convertToDtoList(list);
	}
  
	@Override
	public List<BgtCDDTO> findBgcCDByGroupCdAndToDtAndKeyword(BgtCDDTO bgtCDDTO) {
		
		System.out.println(bgtCDDTO.toString());
		
		BgtCD bgtCD = BgtCDConverter.convertToModel(bgtCDDTO);
		
		System.out.println(bgtCD.toString());
		
		List<BgtCD> bgtCDList = mapper.findBgcCDByGroupCdAndToDtAndKeyword(bgtCD);
		
		System.out.println(bgtCDList.toString());
		
		return BgtCDConverter.convertToDtoList(bgtCDList);
	}

}
