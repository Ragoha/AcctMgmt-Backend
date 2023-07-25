package kr.co.acctmgmt.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acctmgmt.domain.BgtGr;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class BgtGrMapperTest {

	@Autowired
	private BgtGrMapper bgtGrMapper;
	
	@Test
	public void findBgtGrCdAndBgtGrNmByCoCdTest() {
		
		List<BgtGr> bgtGrList = bgtGrMapper.findBgtGrCdAndBgtGrNmByCoCd(1);
		
		bgtGrList.forEach(bgtGr -> {
			System.out.println(bgtGr.toString());
		});
	}
}
