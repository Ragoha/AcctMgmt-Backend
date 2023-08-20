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
	public void insertPjt(Pjt pjt, String coCd) {
	    pjtMapper.insertPjt(pjt, coCd);

	}

	@Override
	public Pjt getPjt(String coCd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pjt> getPjtList(String coCd) {
		// TODO Auto-generated method stub
		return pjtMapper.getPjtList(coCd);
	}

	@Override
	public void deletePjt(Pjt pjt) {	
		pjtMapper.deletePjt(pjt);
	}

	@Override
	public void updatePjt(Pjt pjt, String coCd) {
	    pjtMapper.updatePjt(pjt, coCd);
	}

	@Override
	public List<Pjt> getPjtList() {
		// TODO Auto-generated method stub
		return pjtMapper.getPjtList();
	}

	@Override
	public List<Pjt> getSelPjtList(String pjtCd, String coCd) {
		// TODO Auto-generated method stub
		return pjtMapper.getSelPjtList(pjtCd, coCd);
	}

	@Override
	public Pjt getSelPjt(String coCd, String pjtCd) {
		// TODO Auto-generated method stub
		return pjtMapper.getSelPjt(coCd, pjtCd);
	}

	@Override
	public List<Pjt> getPjtBy(String keyword, String coCd) {
		// TODO Auto-generated method stub
		return pjtMapper.getPjtBy(keyword, coCd);
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

	@Override
	public List<Pjt> getSelPgrList(String pgrCd, String coCd) {
		// TODO Auto-generated method stub
		return pjtMapper.getSelPgrList(pgrCd, coCd);
	}

	@Override
	public List<Pjt> getPgrtBy(String keyword, String coCd) {
		// TODO Auto-generated method stub
		return pjtMapper.getPgrBy(keyword, coCd);
	}

	@Override
	public List<Pjt> selPgrBy(Pjt pjt) {
		// TODO Auto-generated method stub
		return pjtMapper.selPgrBy(pjt);
	}

	@Override
	public List<Pjt> conditionPjtSelect(Pjt pjt, String keyword, String keyword2) {
		// TODO Auto-generated method stub
		return pjtMapper.conditionPjtSelect(pjt, keyword, keyword2);
	}

	@Override
	public List<Pjt> getGroupPjt(Pjt pjt) {
		// TODO Auto-generated method stub
		return pjtMapper.getGroupPjt(pjt);
	}

}
