package kr.co.acctmgmt.service;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserMapper userMapper;

	@Override
	public String getTime() {
		
		return userMapper.getTime();
	}
	
}
