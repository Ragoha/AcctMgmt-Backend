package kr.co.acctmgmt.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acctmgmt.domain.BgtICF;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class BgtICFMapperTest {

	@Autowired
	private BgtICFMapper bgticfMapper;
	
//	@Test
	public void getBgtICFListTest() {
		
		List<BgtICF> bgticfList = bgticfMapper.getBgtICFList();
		
		bgticfList.forEach(bgticf -> {
			System.out.println(bgticf.toString());
		});
	}
	
//	@Test
	public void insertBgtICFTest() {
		BgtICF bgticf = BgtICF.builder()
	            .coCd("MNO")
	            .gisu(456)
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

	    bgticfMapper.insertBgtICF(bgticf);
	    
	    getBgtICFListTest();
	}

    
//	@Test
	public void updateBgtICFTest() {
	    BgtICF bgticf = BgtICF.builder()
	            .coCd("MNO")
	            .gisu(456)
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
	            .remDc("Dummy description 11111")
	            .bgtTy("A")
	            .insertId("ID005")
	            .insertDt(new Date())
	            .insertIp("127.0.0.1")
	            .modifyId("ID005")
	            .modifyDt(new Date())
	            .modifyIp("127.0.0.1")
	            .build();

	    bgticfMapper.updateBgtICF(bgticf);
	    
	    // 업데이트 후 데이터 조회
	    getBgtICFListTest();
	}
    
//    @Test
    public void deleteBgticfTest() {
    	BgtICF bgticf = BgtICF.builder()
        		.coCd("MNO")
        		.gisu(456)
        		.build();
        
        bgticfMapper.deleteBgtICF(bgticf);
        
        getBgtICFListTest();
    }
}