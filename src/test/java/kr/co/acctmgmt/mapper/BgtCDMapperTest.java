package kr.co.acctmgmt.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acctmgmt.domain.BgtCD;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class BgtCDMapperTest {
	
	@Autowired
	private BgtCDMapper bgtCDMapper;
	
//	@Test
    public void findBgcCDByKeywordTest() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date toDt = null;
        try {
            toDt = dateFormat.parse("1900-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        BgtCD bgtCD = BgtCD.builder()
                .coCd(1)
                .groupCd("101")
//                .toDt(toDt)
                .keyword("¿¹")
                .build();

        List<BgtCD> bgtCDList = bgtCDMapper.findBgcCDByGroupCdAndToDtAndKeyword(bgtCD);

        System.out.println(bgtCDList.toString());
    }
	
	@Test
	public void findBgtCdByGisuAndGroupCdAndGrFgAndBgtCdTest() {
		BgtCD bgtCD = BgtCD.builder()
				.coCd(1)
				.gisu(1)
				.divCd(1001)
				.groupCd("101")
				.grFg("0")
//				.bgtCd("B003")
				.build();
		List<BgtCD> bgtCDList = bgtCDMapper.findBgtCdByGisuAndGroupCdAndGrFgAndBgtCd(bgtCD);
		bgtCDList.forEach(rBgtCD -> {
		    System.out.println(rBgtCD.getDataPath());
		});
		
//		System.out.println(bgtCDList.toString());
	}

}
