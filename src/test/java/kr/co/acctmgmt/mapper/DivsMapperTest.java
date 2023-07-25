package kr.co.acctmgmt.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acctmgmt.domain.Divs;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DivsMapperTest {

	@Autowired
	private DivsMapper divsMapper;
	
//	@Test
	public void findDivCdAndDivNmByCoCdTest() {
		
		List<Divs> divsList = divsMapper.findDivCdAndDivNmByCoCd(1); 
		divsList.forEach(divs -> {
			System.out.println(divs.toString());
		});
	}
	
	@Test
	public void findDivCdAndDivNmByKeywordTest() {
	    List<String> keywords = new ArrayList<>();
	    keywords.add("101");
	    keywords.add("È¸»ç");
	    
	    Divs divs = Divs.builder()
	            .coCd(1)
	            .keyword(keywords)
	            .build();
	    
	    List<Divs> divsList = divsMapper.findDivCdAndDivNmByKeyword(divs); 
	    divsList.forEach(div -> {
	        System.out.println(div.toString());
	    });
	}

}
