package kr.co.acctmgmt.controller;

import java.util.Collections;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.config.jwt.JwtAuthenticationProvider;
import kr.co.acctmgmt.domain.User;
import kr.co.acctmgmt.dto.UserDTO;
import kr.co.acctmgmt.mapper.UserMapper;

@RestController
public class UserAPI {

    @Autowired private UserMapper userMapper;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtAuthenticationProvider jwtAuthenticationProvider;

    @PostMapping("/join")
    public void join(@RequestBody UserDTO user){
    	System.out.println("조인");
        userMapper.save(User.builder()
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .roles(Collections.singletonList("ROLE_USER"))
                .build());

    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody UserDTO user, HttpServletResponse response) {
    	
    	System.out.println("로그인");
        User rUser = userMapper.findByEmail(user.getEmail());
                
		if (rUser == null) {
            throw new IllegalArgumentException("가입되지 않은 E-MAIL 입니다.");
        }
        if (!passwordEncoder.matches(user.getPassword(), rUser.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        String token = jwtAuthenticationProvider.createToken(rUser.getUsername(), rUser.getRoles());
        response.setHeader("X-AUTH-TOKEN", token);

        Cookie cookie = new Cookie("X-AUTH-TOKEN", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        response.addCookie(cookie);
        System.out.println("로그인 성공");

        return new UserDTO(rUser);
    }
//
//    @PostMapping("/logout")
//    public void logout(HttpServletResponse response){
//        Cookie cookie = new Cookie("X-AUTH-TOKEN", null);
//        cookie.setHttpOnly(true);
//        cookie.setSecure(false);
//        cookie.setMaxAge(0);
//        cookie.setPath("/");
//        response.addCookie(cookie);
//    }
//
//    @GetMapping("/info")
//    public UserDto getInfo(){
//        Object details = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(details != null && !(details instanceof  String)) return new UserDto((User) details);
//        return null;
//    }

}
