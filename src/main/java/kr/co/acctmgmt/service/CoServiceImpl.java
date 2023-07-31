package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.Co;
import kr.co.acctmgmt.mapper.CoMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoServiceImpl implements CoService{
	
	private final CoMapper coMapper;

	@Override
	public List<Co> getCoList() {
		
		List<Co> coList = coMapper.getCoList();
		return coList;
	}

	@Override
	public void insertCo(Co co) {
		coMapper.insertCo(co);
	}

	@Override
	public Co getCo(int coCd) {
		Co co = coMapper.getCo(coCd);
		return co;
	}

	@Override
	public void deleteCo(int coCd) {
		coMapper.deleteCo(coCd);
		
	}

	@Override
	public void updateCo(Co co) {
		coMapper.updateCo(co);
		
	}

	@Override
	public List<Co> getCoBycoCdAndcoNm(Co co) {
		List<Co> searchCo = coMapper.getCoBycoCdAndcoNm(co);
		return searchCo;
	}

}
