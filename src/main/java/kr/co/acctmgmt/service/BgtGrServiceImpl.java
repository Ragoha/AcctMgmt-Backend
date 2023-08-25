package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.converter.BgtGrConverter;
import kr.co.acctmgmt.domain.BgtCD;
import kr.co.acctmgmt.domain.BgtGr;
import kr.co.acctmgmt.dto.BgtGrDTO;
import kr.co.acctmgmt.mapper.BgtGrMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BgtGrServiceImpl implements BgtGrService {
	
	private final BgtGrMapper bgtGrMapper;
	
	@Override
	public List<BgtGrDTO> findBgtGrCdAndBgtGrNmByCoCd(BgtGrDTO bgtGrDTO) {
		
		BgtGr bgtgr = BgtGrConverter.convertToModel(bgtGrDTO);
		
		List<BgtGr> rBgtGrList = bgtGrMapper.findBgtGrByCoCdAndKeyword(bgtgr);
		
		return BgtGrConverter.convertToDtoList(rBgtGrList);
	}

	@Override
	public List<BgtGrDTO> findBgtGrByCoCdAndKeyword(BgtGrDTO bgtGrDTO) {
		
		BgtGr bgtgr = BgtGrConverter.convertToModel(bgtGrDTO);
		
		List<BgtGr> rBgtGrList = bgtGrMapper.findBgtGrByCoCdAndKeyword(bgtgr);
		
		return BgtGrConverter.convertToDtoList(rBgtGrList);
	}

	@Override
	public List<BgtGrDTO> findBgtGrByCoCd(BgtGrDTO bgtGrDTO) {
		BgtGr bgtgr = BgtGrConverter.convertToModel(bgtGrDTO);
		
		List<BgtGr> rBgtGrList = bgtGrMapper.findBgtGrByCoCdAndKeyword(bgtgr);
		
		return BgtGrConverter.convertToDtoList(rBgtGrList);
	}

	@Override
	public void deleteBgtGr(BgtGrDTO bgtGrDTO) {
		BgtGr bgtgr = BgtGrConverter.convertToModel(bgtGrDTO);
		
		bgtGrMapper.deleteBgtGr(bgtgr);
		
	}

	@Override
	public void updateBgtGr(BgtGrDTO bgtGrDTO) {
		System.out.println("updateBgtGr===>서비스");
		BgtGr bgtgr = BgtGrConverter.convertToModel(bgtGrDTO);
		bgtGrMapper.updateBgtGr(bgtgr);
	}

	@Override
	public void insertBgtGr(BgtGrDTO bgtGrDTO) {
		BgtGr bgtgr = BgtGrConverter.convertToModel(bgtGrDTO);
		System.out.println("insertBgtGr==?==?==?");
		System.out.println(bgtgr.toString());
		String coCd= bgtgr.getCoCd();
		System.out.println("0.........................................");
		bgtGrMapper.insertBgtGr(bgtgr);
		
		String tBgtCd = bgtGrMapper.getMaxBgtCd(coCd); //현재 BGTCD 테이블의 값중 가장 큰 값 ex) 61110000
//		
	System.out.println("tbgtcd");
	System.out.println(tBgtCd);
		int value = 0;
		if(tBgtCd ==null) {
			value = 10000000;
		}else {
			 value = Integer.parseInt(tBgtCd);
		}
		int suip= ((value/10000000)+1)*10000000;
		int suchul = ((value/10000000)+2)*10000000;
		
		System.out.println("1...............................");
		BgtCD bgtCdInfo = new BgtCD();
		bgtCdInfo.setCoCd(coCd);
		bgtCdInfo.setBgtCd(Integer.toString(suip));
		bgtCdInfo.setParentCd(null);
		bgtCdInfo.setDivFg("1");
		bgtCdInfo.setCtlFg("0");
		bgtCdInfo.setBgajustFg("0");
		bgtCdInfo.setBizFg("0");
		bgtCdInfo.setBottomFg("1");
		bgtCdInfo.setGrFg("0");
		bgtCdInfo.setGroupCd(Integer.toString(bgtgr.getBgtGrCd()));
		bgtCdInfo.setInsertId(bgtgr.getInsertId());
		bgtCdInfo.setDataPath(null);
		bgtCdInfo.setGisu(bgtgr.getGisu());

		System.out.println("2...............................");
		bgtGrMapper.initBgtCd(bgtCdInfo);
		bgtCdInfo.setBgtCd(Integer.toString(suchul));
		bgtCdInfo.setGrFg("1");
		bgtGrMapper.initBgtCd(bgtCdInfo);
		System.out.println("3...............................");
	}

}
