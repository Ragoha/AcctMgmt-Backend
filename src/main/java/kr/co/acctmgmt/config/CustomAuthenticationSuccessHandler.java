package kr.co.acctmgmt.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        // 인증에 성공한 사용자 정보를 세션에 저장
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        HttpSession session = request.getSession();
        session.setAttribute("userDetails", userDetails);
        
        System.out.println("세션에 값이 들어 있나요??" + userDetails.toString());
        // 로그인 후 페이지로 리다이렉트
        response.sendRedirect("/main"); // 로그인 후 페이지 URL
    }
}
