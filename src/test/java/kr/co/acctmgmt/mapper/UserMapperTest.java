package kr.co.acctmgmt.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.acctmgmt.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
//	@Test
	public void test() {
		
		User user = userMapper.findByEmail("test");
		System.out.println(user.toString());
	}
	
	@Test
	public void save() {
		userMapper.save(User.builder()
				.email("test1")
				.password("password")
				.phoneNumber("010")
				.name("Å×½ºÆ®")
				.build());
		
		User user = userMapper.findByEmail("test");
		System.out.println(user.toString());
	}

}
