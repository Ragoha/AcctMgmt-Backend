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
		System.out.println("과연? " + isAccessTokenValid);
		try {
			if (isAccessTokenValid) {
				System.out.println("사용자 인증!!!!!!!!!!!!!!@!@@@@@@@@@@@@@@@@@");
				Authentication authentication = jwtUtil.getAuthentication(accessToken);
				SecurityContextHolder.getContext().setAuthentication(authentication); //사용자 인증 설정 
			} else {
				String refreshToken = jwtUtil.resolveRefreshToken(request);
//				System.out.println("리프토큰: " + refreshToken);
				if (refreshToken != null && jwtUtil.validateRefreshToken((refreshToken))) {
					Authentication authentication = jwtUtil.getAuthentication(refreshToken);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		} catch (Exception e) {
			System.out.println("사용자 인증 실패!!!!!!!@@@@@@@@@@@");
			SecurityContextHolder.clearContext(); // 예외 시 인증 삭제
		}
		filterChain.doFilter(request, response);
	}
}