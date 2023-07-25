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
	
	@Test
	public void test() {
		
		User user = userMapper.findByEmail("test1");
		System.out.println(user.toString());
	}
	
//	@Test
	public void save() {
		
		User user = User.builder()
				.email("test99")
				.password("password")
				.phoneNumber("010")
				.name("Å×½ºÆ®")
				.build();
		
		userMapper.save(user);
		
		System.out.println(user.getId());
		
		User user1 = userMapper.findByEmail("test");
		System.out.println(user1.toString());
	}

}
