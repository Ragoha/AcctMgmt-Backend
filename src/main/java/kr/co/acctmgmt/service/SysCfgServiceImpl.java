package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.SysCfg;
import kr.co.acctmgmt.mapper.SysCfgMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SysCfgServiceImpl implements SysCfgService{

	private final SysCfgMapper configMapper;
	
	@Override
	public List<SysCfg> getConfigList(String coCd) {
		return configMapper.getConfigList(coCd);
	}

	@Override
	public void updateConfig(SysCfg config) {
		// TODO Auto-generated method stub
		configMapper.updateConfig(config);
	}

}
