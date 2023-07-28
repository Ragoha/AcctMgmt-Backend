package kr.co.acctmgmt.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acctmgmt.domain.SysCfg;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class SysCfgMapperTest {
	
	@Autowired
	private SysCfgMapper configMapper;

//	@Test
	public void getConfigList() {
		int coCd =2000;
		List<SysCfg> configList = configMapper.getConfigList(coCd);
		
		configList.forEach(config ->{
			System.out.println(config.toString());
		});
	}
	
	@Test
	public void updateConfig()
	{
		int coCd =2000;
		String sysCd="3";
		SysCfg config = configMapper.getConfig(coCd, sysCd);
		System.out.println(config.toString());
		
		config.setSysYn("5");
		
		configMapper.updateConfig(config);
		
		getConfigList();
	}
	
}
