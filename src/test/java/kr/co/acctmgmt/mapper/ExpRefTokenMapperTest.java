package kr.co.acctmgmt.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acctmgmt.domain.ExpRefToken;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ExpRefTokenMapperTest {

	@Autowired
	private ExpRefTokenMapper expRefTokenMapper;
	
//	@Test
	public void existsByTokenTest() {
		
		System.out.println(expRefTokenMapper.existsByToken("abcd"));
	}
	
	@Test
	public void saveTokenTest() {
		
		ExpRefToken expRefToken = ExpRefToken.builder()
				.token("abcd")
				.build();
		expRefTokenMapper.saveToken(expRefToken);
		
		existsByTokenTest();
	}
}
