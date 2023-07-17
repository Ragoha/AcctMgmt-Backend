package kr.co.acctmgmt.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acctmgmt.domain.Bgticf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class BgticfMapperTest {

	@Autowired
	private BgticfMapper bgticfMapper;
	
	@Test
	public void getBgticfListTest() {
		
		List<Bgticf> bgticfList = bgticfMapper.getBgticfList();
		
		bgticfList.forEach(bgticf -> {
			System.out.println(bgticf.toString());
		});
	}
	
//	@Test
	public void insertBgticfTest() {
	    Bgticf bgticf = Bgticf.builder()
	            .coCd("MNO")
	            .gisu("456")
	            .sq(5)
	            .divCd("VWX")
	            .deptCd("PQR")
	            .mgtCd("MGT005")
	            .bgtCd("BGT005")
	            .bgtFg("FG005")
	            .bgtCnt("1")
	            .bottomCd("BT005")
	            .carrAm((long) 1900.65)
	            .carrAm1((long) 1600.65)
	            .carrAm2((long) 2400.55)
	            .carrAm3((long) 2100.75)
	            .empCd("EMP005")
	            .remDc("Dummy description 5")
	            .bgtTy("A")
	            .insertId("ID005")
	            .insertDt(new Date())
	            .insertIp("127.0.0.1")
	            .modifyId("ID005")
	            .modifyDt(new Date())
	            .modifyIp("127.0.0.1")
	            .build();

	    bgticfMapper.insertBgticf(bgticf);
	    
	    getBgticfListTest();
	}

    
//    @Test
    public void updateBgticfTest() {
        Bgticf bgticf = new Bgticf();
        // 설정 및 수정할 데이터 입력
        
        bgticfMapper.updateBgticf(bgticf);
    }
    
//    @Test
    public void deleteBgticfTest() {
        Bgticf bgticf = Bgticf.builder()
        		.coCd("MNO")
        		.gisu("456")
        		.build();
        
        bgticfMapper.deleteBgticf(bgticf);
        
        getBgticfListTest();
    }
}

