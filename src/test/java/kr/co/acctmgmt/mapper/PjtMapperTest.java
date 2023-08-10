package kr.co.acctmgmt.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acctmgmt.domain.Pjt;
import kr.co.acctmgmt.domain.SysCfg;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class PjtMapperTest {

	@Autowired
	private PjtMapper pjtMapper;

//	@Test
	public void getPjtList() {
		int coCd = 2000;
		List<Pjt> pjtList = pjtMapper.getPjtList(coCd);

		pjtList.forEach(pjt -> {
			System.out.println(pjt.toString());
		});
	}

//	@Test
	public void getSelPjtList() {
	    int coCd = 2000;
	    String pjtCd = "100";
	    List<Pjt> pjtList = pjtMapper.getSelPjtList(pjtCd, coCd);
	    
	    System.out.println("sibal : " + pjtList.toString());
	}
	
//	@Test
	public void updatePjt() {
		int coCd=2000;
		String pjtCd = "100";
		
		Pjt pjt = pjtMapper.getSelPjt(coCd, pjtCd);
		System.out.println(pjt.toString());
		pjt.setProgFg("2.완료");
		pjt.setPjtNm("파이리");
//		pjtMapper.updatePjt(pjt);
		
		getSelPjtList();
	}

	@Test
	public void findPjtByCoCdAndKeywordTest() {
		Pjt pjt = Pjt.builder().coCd(1000).build();
		
		List<Pjt> rPjtList = pjtMapper.findPjtByCoCdAndKeyword(pjt);
		
		System.out.println(rPjtList.toString());
	}
}
