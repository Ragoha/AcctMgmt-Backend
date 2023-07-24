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

	@Test
	public void getConfigList() {
		String coCd ="dz";
		List<SysCfg> configList = configMapper.getConfigList(coCd);
		
		configList.forEach(config ->{
			System.out.println(config.toString());
		});
	}
	
	
}
