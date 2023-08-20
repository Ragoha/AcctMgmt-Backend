package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.Pgr;
import kr.co.acctmgmt.mapper.PgrMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PgrSerivceImpl implements PgrService{
	private final PgrMapper pgrMapper;

	@Override
	public List<Pgr> findPgrByCoCd(String coCd) {
		return pgrMapper.findPgrByCoCd(coCd);
	}


	@Override
	public void deletePgr(Pgr gisu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePgr(Pgr gisu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertPgr(Pgr gisu) {
		// TODO Auto-generated method stub
		
	}

}
