package kr.co.acctmgmt.service;

import kr.co.acctmgmt.domain.User;

public interface UserService {
	public User findByEmail(String email);
	
	public void save(User user);
}
