package kr.co.acctmgmt.mapper;

import kr.co.acctmgmt.domain.User;

public interface UserMapper {

	public User findByEmail(String email);
	
	public void save(User user);
	
	public Long getIdByEmail(String email);
}
