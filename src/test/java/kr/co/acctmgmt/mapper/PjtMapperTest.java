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
		String coCd = "2000";
		List<Pjt> pjtList = pjtMapper.getPjtList(coCd);

		pjtList.forEach(pjt -> {
			System.out.println(pjt.toString());
		});
	}

//	@Test
	public void getSelPjtList() {
		String coCd = "2000";
//		String pjtCd = "100";
//		List<Pjt> pjtList = pjtMapper.getSelPjtList(pjtCd, coCd);
//
//		System.out.println("what? : " + pjtList.toString());
	}

//	@Test
	public void updatePjt() {
		String coCd = "2000";
		String pjtCd = "100";

		Pjt pjt = pjtMapper.getSelPjt(coCd, pjtCd);
		System.out.println(pjt.toString());
		pjt.setProgFg("2.�Ϸ�");
		pjt.setPjtNm("���̸�");
//		pjtMapper.updatePjt(pjt);

		getSelPjtList();
	}

//	@Test
	public void findPjtByCoCdAndKeywordTest() {
		Pjt pjt = Pjt.builder().coCd("1000").build();

		List<Pjt> rPjtList = pjtMapper.findPjtByCoCdAndKeyword(pjt);

		System.out.println(rPjtList.toString());
	}

//	@Test
	public void progPjtSelect() {

		Pjt pjt = new Pjt();
		pjt.setCoCd("1000");
		pjt.setProgFg("1.진행중");
//        pjt.setPrDt("2023-07-01");
//        pjt.setToDt("2025-08-15");

		String keyword = "100. 테스트";
		String keyword2 = "123. 테스트";

		List<Pjt> results = pjtMapper.conditionPjtSelect(pjt, keyword, keyword2);

		for (Pjt result : results) {
			System.out.println(result);
		}
	}

//	@Test
	public void insert() {
		Pjt pjt = new Pjt();
		String a = "2000";
		pjt.setPjtCd("1500");
		pjt.setPjtNm("테에스트");
		pjt.setProgFg("완료");
		pjt.setPgrNm("hh");
		pjt.setPgrCd("4242");
		pjtMapper.insertPjt(pjt, a);

		List<Pjt> pjtList = pjtMapper.getPjtList(a);

		System.out.println("what? : " + pjtList.toString());
	}
	@Test
	public void getPgrBy() {
		
		String keyword = "12";
//		pjt.setCoCd(1000);
		
//		List<Pjt> pjt = pjtMapper.getPgrBy(keyword, "2000");
//		System.out.println("찾았니 ? " + pjt.toString());
	}
}
