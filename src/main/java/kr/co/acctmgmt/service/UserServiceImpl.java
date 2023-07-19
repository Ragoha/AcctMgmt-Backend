package kr.co.acctmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.SBGTCDDomain;
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

	@Override
	public List<SBGTCDDomain> getDataGridData() {
		// TODO Auto-generated method stub
		System.out.println("userService Impl ÀÇ getDataGridData==1");
		List<SBGTCDDomain> sbgtcd =userMapper.getDataGridData();
		return sbgtcd;
	}
	
	
}
