package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.converter.PjtConverter;
import kr.co.acctmgmt.domain.Pjt;
import kr.co.acctmgmt.dto.PjtDTO;
import kr.co.acctmgmt.mapper.PjtMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PjtServiceImpl implements PjtService {

	private final PjtMapper pjtMapper;
	

	@Override
	public void insertPjt(Pjt pjt, int coCd) {
	    pjtMapper.insertPjt(pjt, coCd);

	}

	@Override
	public Pjt getPjt(int coCd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pjt> getPjtList(int coCd) {
		// TODO Auto-generated method stub
		return pjtMapper.getPjtList(coCd);
	}

	@Override
	public void deletePjt(Pjt pjt) {	
		pjtMapper.deletePjt(pjt);
	}

	@Override
	public void updatePjt(Pjt pjt, int coCd) {
	    pjtMapper.updatePjt(pjt, coCd);
	}

	@Override
	public List<Pjt> getPjtList() {
		// TODO Auto-generated method stub
		return pjtMapper.getPjtList();
	}

	@Override
	public List<Pjt> getSelPjtList(String pjtCd, int coCd) {
		// TODO Auto-generated method stub
		return pjtMapper.getSelPjtList(pjtCd, coCd);
	}

	@Override
	public Pjt getSelPjt(int coCd, String pjtCd) {
		// TODO Auto-generated method stub
		return pjtMapper.getSelPjt(coCd, pjtCd);
	}

	@Override
	public List<Pjt> getPjtBy(String keyword, int coCd) {
		// TODO Auto-generated method stub
		return pjtMapper.getPjtBy(keyword, coCd);
	}

	@Override
	public Pjt getPgrBy(String keyword, int coCd) {
		// TODO Auto-generated method stub
		return pjtMapper.getPgrBy(keyword, coCd);
	}
	public List<PjtDTO> findPjtByCoCdAndKeyword(PjtDTO pjtDTO) {
	
		Pjt pjt = PjtConverter.convertToModel(pjtDTO);
		
		System.out.println(pjt.toString());
		
		List<Pjt> rPjtList = pjtMapper.findPjtByCoCdAndKeyword(pjt);
	
		
		return PjtConverter.convertToDtoList(rPjtList);
	}

	@Override
	public List<Pjt> selPjtBy(Pjt pjt) {
		// TODO Auto-generated method stub
		return pjtMapper.selPjtBy(pjt);
	}

}
