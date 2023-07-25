package kr.co.acctmgmt.service;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.User;
import kr.co.acctmgmt.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	@Override
	public User findByEmail(String email) {
		
		User user = userMapper.findByEmail(email);
		
		return user; 
	}
	
	public void save(User user) {
		
		userMapper.save(user);
		
		Long id = userMapper.getIdByEmail(user.getEmail());
		
	}

}
