package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.Config;
import kr.co.acctmgmt.mapper.ConfigMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConfigServiceImpl implements ConfigService{

	private final ConfigMapper configMapper;
	
	@Override
	public List<Config> getConfigList(String coCd) {
		return configMapper.getConfigList(coCd);
	}

	@Override
	public void updateConfig(Config config) {
		// TODO Auto-generated method stub
		configMapper.updateConfig(config);
	}

}
