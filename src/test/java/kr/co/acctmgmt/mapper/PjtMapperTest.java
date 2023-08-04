package kr.co.acctmgmt.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acctmgmt.domain.Pjt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class PjtMapperTest {

	@Autowired
	private PjtMapper pjtMapper;
	
	@Test
	public void getPjtList()
	{
		int coCd=2000;
		List<Pjt> pjtList = pjtMapper.getPjtList(coCd);
		
		pjtList.forEach(pjt ->{
			System.out.println(pjt.toString());
		});
	}
}
