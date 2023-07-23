package kr.co.acctmgmt.service;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.User;
import kr.co.acctmgmt.domain.UserRole;
import kr.co.acctmgmt.mapper.UserMapper;
import kr.co.acctmgmt.mapper.UserRoleMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;
	private final UserRoleMapper userRoleMapper; 
	@Override
	public User findByEmail(String email) {
		
		User user = userMapper.findByEmail(email);
		
		user.setRoles(userRoleMapper.getRoleById(user.getId()));
		
		return user; 
	}
	
	public void save(User user) {
		
		userMapper.save(user);
		
		Long id = userMapper.getIdByEmail(user.getEmail());
		
		UserRole userRole = UserRole.builder()
				.userId(id)
				.role("ROLE_USER")
				.build();
		
		userRoleMapper.save(userRole);
	}

}
