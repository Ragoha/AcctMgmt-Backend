package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.UserRole;

public interface UserRoleMapper {

	public void save(UserRole userRole);
	
	public List<String> getRoleById(Long userId);
}
