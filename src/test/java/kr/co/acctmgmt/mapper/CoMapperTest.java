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
	
//	@Test
	public void getCo(){
		int coCd = 1;
		
//		List<Co> sco= coMapper.getCo(coCd);
//		System.out.println(sco.toString());
	}
	
//	@Test
	public void getNum() {
		int num = coMapper.getNum();
		System.out.println(num);
	}
	

//	public void deleteCo() {
//		int coCd = 2;
//		
//		coMapper.deleteCo("coCd");
//	}

	
//	@Test
//	public void updateCo() {
//		int coCd = 1007;
//		String coAddr="¼­ÃÊ±¸";
//		coMapper.updateCo(coCd);
//	}

}
