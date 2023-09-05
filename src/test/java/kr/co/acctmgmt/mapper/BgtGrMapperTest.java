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
	public void findBgtGrByCoCdOrKeywordTest() {
		
		BgtGr bgtGr1 = BgtGr.builder()
				.coCd("1")
				.build();
		
		BgtGr bgtGr2 = BgtGr.builder()
				.coCd("1")
				.keyword("·ì1")
				.build();
		
		List<BgtGr> bgtGrList1 = bgtGrMapper.findBgtGrByCoCdAndKeyword(bgtGr1);
		List<BgtGr> bgtGrList2 = bgtGrMapper.findBgtGrByCoCdAndKeyword(bgtGr2);
		
		System.out.println(bgtGrList1);
		System.out.println("");
		System.out.println(bgtGrList2);
		
	}
	
}
