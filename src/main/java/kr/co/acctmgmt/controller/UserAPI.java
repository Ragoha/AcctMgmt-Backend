package kr.co.acctmgmt.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kr.co.acctmgmt.config.jwt.ExpiredRefreshTokenService;
import kr.co.acctmgmt.config.jwt.JwtUtil;
import kr.co.acctmgmt.domain.User;
import kr.co.acctmgmt.dto.UserDTO;
import kr.co.acctmgmt.dto.UserLoginReq;
import kr.co.acctmgmt.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserAPI {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final ExpiredRefreshTokenService expiredRefreshTokenService;
    private final JwtUtil jwtUtil;

    @PostMapping("/join")
    public void join(@RequestBody UserDTO user){
    	System.out.println("조인");
    	userService.save(User.builder()
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .build());


    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody(required = false) @Valid UserLoginReq req,
        HttpServletRequest request,
        HttpServletResponse response) {
    	System.out.println("로그인");
        User user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            user = (User)authentication.getPrincipal();
        } else {
            if (req != null) {
                user = userService.findByEmail(req.getEmail());
                if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
                    //아이디 비밀번호 미일치 시 처리할 로직
                }
            }
        }
        System.out.println("11");
        if (user == null) {
            //유저객체를 제대로 불러오지 못할때 처리할 로직
        }

        String expiredToken = jwtUtil.resolveRefreshToken(request);
        if (expiredToken != null && !expiredToken.isBlank()) {
            expiredRefreshTokenService.addExpiredToken(expiredToken);
        }

        String accessToken = jwtUtil.createAccessToken(user.getEmail(), user.getRole().get(0));
        String refreshToken = jwtUtil.createRefreshToken(user.getEmail(), user.getRole().get(0));

        Cookie refreshTokenCookie = new Cookie("refresh-token", refreshToken);
        response.setHeader("access-token", accessToken);
        response.addCookie(refreshTokenCookie);

        System.out.println("22");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/logouta")
    public void logout(HttpServletResponse response){
        System.out.println("logout");
        
        // access-token 삭제
        response.setHeader("access-token", null);

        // refresh-token 삭제
        Cookie refreshTokenCookie = new Cookie("refresh-token", null);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setSecure(false);
        refreshTokenCookie.setMaxAge(0);
        refreshTokenCookie.setPath("/");
        response.addCookie(refreshTokenCookie);
    }

    @GetMapping("/info")
    public UserDTO getInfo(){

        Object details = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	System.out.println(details);
        if(details != null && !(details instanceof  String)) {
        	System.out.println(details);
        	return new UserDTO((User) details);
        }
        return null;
    }

}
