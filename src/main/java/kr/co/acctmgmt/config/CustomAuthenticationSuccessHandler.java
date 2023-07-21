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
        // ������ ������ ����� ������ ���ǿ� ����
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        HttpSession session = request.getSession();
        session.setAttribute("userDetails", userDetails);
        
        System.out.println("���ǿ� ���� ��� �ֳ���??" + userDetails.toString());
        // �α��� �� �������� �����̷�Ʈ
        response.sendRedirect("/main"); // �α��� �� ������ URL
    }
}
