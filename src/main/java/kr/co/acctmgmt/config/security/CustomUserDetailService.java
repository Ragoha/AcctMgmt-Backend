package kr.co.acctmgmt.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.User;
import kr.co.acctmgmt.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println("users@@@@@@@@");
		return null;
	}

//	private final UserMapper userMapper;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User rUser= userMapper.findByEmail(username);
//        
//		if (rUser == null) {
//            throw new IllegalArgumentException("가입되지 않은 E-MAIL 입니다.");
//        }
//		return rUser;
//	}

}
