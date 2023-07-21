package kr.co.acctmgmt.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acctmgmt.domain.Co;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class CoMapperTest {
	
	@Autowired
	private CoMapper coMapper;
	
	@Test
	public void getCo(){
		int coCd = 0;
		
		List<Co> sco= coMapper.getCo(coCd);
		System.out.println(sco.toString());
	}

}
