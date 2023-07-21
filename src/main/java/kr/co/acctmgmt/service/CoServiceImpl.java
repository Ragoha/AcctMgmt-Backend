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
	public List<Co> getCo(int coCd) {
		List<Co> co = coMapper.getCo(coCd);
		return co;
	}

}