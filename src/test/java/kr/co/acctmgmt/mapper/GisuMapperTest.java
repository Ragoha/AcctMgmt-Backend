//package kr.co.acctmgmt.mapper;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import kr.co.acctmgmt.domain.Gisu;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
//public class GisuMapperTest {
//
//	@Autowired
//	private GisuMapper gisuMapper;
//	
//	
//	@Test
//	public void findByCoCdTest() {
//		
//		Gisu gisu = Gisu.builder()
//				.coCd(1)
//				.build();
//		
//		List<Gisu> gisuList = gisuMapper.findGisuByCoCd(gisu);
//		
//		System.out.println(gisuList.toString());
//	}
//}
