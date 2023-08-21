package kr.co.acctmgmt.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	public JwtAuthenticationFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String accessToken = jwtUtil.resolveAccessToken(request);
		boolean isAccessTokenValid = accessToken != null && jwtUtil.validateToken(accessToken);
//		System.out.println("����? " + isAccessTokenValid);
		try {
			if (isAccessTokenValid) {
//				System.out.println("����� ����!!!!!!!!!!!!!!@!@@@@@@@@@@@@@@@@@");
				Authentication authentication = jwtUtil.getAuthentication(accessToken);
				SecurityContextHolder.getContext().setAuthentication(authentication); //����� ���� ���� 
			} else {
				String refreshToken = jwtUtil.resolveRefreshToken(request);
//				System.out.println("������ū: " + refreshToken);
				if (refreshToken != null && jwtUtil.validateRefreshToken((refreshToken))) {
					Authentication authentication = jwtUtil.getAuthentication(refreshToken);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		} catch (Exception e) {
			SecurityContextHolder.clearContext(); // ���� �� ���� ����
		}
		filterChain.doFilter(request, response);
	}
}