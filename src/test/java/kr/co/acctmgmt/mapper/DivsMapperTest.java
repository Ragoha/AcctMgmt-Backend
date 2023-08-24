//package kr.co.acctmgmt.mapper;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import kr.co.acctmgmt.domain.Dept;
//import kr.co.acctmgmt.domain.Divs;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
//public class DivsMapperTest {
//
//	@Autowired
//	private DivsMapper divsMapper;
//	
//	@Autowired DeptMapper deptMapper;
//	
////	@Test
//	public void findDivsByCoCdAndKeywordTest() {
//		
//		Divs divs1 = Divs.builder()
//				.coCd("1")
//				.build();
//		
//		Divs divs2 = Divs.builder()
//				.coCd("1")
//				.keyword("·ì1")
//				.build();
//		
//		
//		List<Divs> divsList1 = divsMapper.findDivByCoCdAndKeyword(divs1);
//		List<Divs> divsList2 = divsMapper.findDivByCoCdAndKeyword(divs2);
//		
//		System.out.println(divsList1);
//		System.out.println();
//		System.out.println(divsList2);
//		
//		
//		
//	}
//	
//	@Test
//	public void findDivsByCoCdTest() {
//		
//		List<Divs> rDivsList = divsMapper.findDivByCoCd("1000");
//		
//		rDivsList.forEach(rDivs -> {
//			System.out.println(rDivs.getDivCd());
//			Dept dept = Dept.builder().coCd("1000").divCd(rDivs.getDivCd()).build();
//			
//			List<Dept> rDeptList = deptMapper.findDeptByCoCd(dept);
//			
//			rDeptList.forEach(rDept -> {
//				System.out.println(rDept.toString());
//			});
//		});
//	}
//
//}
