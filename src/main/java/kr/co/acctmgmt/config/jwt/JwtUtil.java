package kr.co.acctmgmt.config.jwt;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.co.acctmgmt.domain.Employee;
import kr.co.acctmgmt.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtUtil {

  private final ExpiredRefreshTokenService expiredRefreshTokenService;
  private final EmployeeService userService;

//  @Value("${jwt.secret}")
  private String secretKey = "acctmgmt";

  private final long ACCESS_TOKEN_VALID_TIME = 1000L * 60 * 60 * 24; //24시간
  private final long REFRESH_TOKEN_VALID_TIME = 1000L * 60 * 60 * 24 * 60; // 2달

  public String createAccessToken(String userPk, String role) {
      Claims claims = Jwts.claims().setSubject(userPk);
      claims.put("empAuth", role);
      Date now = new Date();

      return Jwts.builder()
          .setClaims(claims)
          .setIssuedAt(now)
          .setExpiration(new Date(now.getTime() + ACCESS_TOKEN_VALID_TIME))
          .signWith(SignatureAlgorithm.HS256, secretKey)
          .compact();
  }

  public String createRefreshToken(String userPk, String role) {
      Claims claims = Jwts.claims();
      claims.put("role", role);
      Date now = new Date();
      Date expiration = new Date(now.getTime() + REFRESH_TOKEN_VALID_TIME);

      return Jwts.builder()
          .setClaims(claims)
          .setIssuedAt(now)
          .setExpiration(expiration)
          .signWith(SignatureAlgorithm.HS256, secretKey)
          .compact();
  }

  public Authentication getAuthentication(String token) {
//	  System.out.println("getUserPk?:" + getUserPk(token) );
      String email = getUserPk(token);
//      System.out.println("그래서 나온 eamil: " + email);
      Employee employee = userService.findByEmail(email);
//      System.out.println("그래서 나온 객체 클:" + employee.toString());
      
      List<GrantedAuthority> authorities = (List<GrantedAuthority>) employee.getAuthorities();
      for (GrantedAuthority authority : authorities) {
//          System.out.println("@@@@@사용자 권한: " + authority.getAuthority());
      }
      
      return new UsernamePasswordAuthenticationToken(employee, "", employee.getAuthorities());
  }

  public String getUserPk(String token) {
      return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
  }

  public String resolveAccessToken(HttpServletRequest request) {
      String token = request.getHeader("access-token");
      return token;
  }

  public String resolveRefreshToken(HttpServletRequest request) {
      String token = null;
      Cookie cookie = WebUtils.getCookie(request, "refresh-token");
      if (cookie != null)
          token = cookie.getValue();
      return token;
  }

  public boolean validateToken(String jwtToken) {
      try {
          Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
          return !claims.getBody().getExpiration().before(new Date());
      } catch (Exception e) {
          return false;
      }
  }

  public boolean validateRefreshToken(String jwtToken) {
      if(expiredRefreshTokenService.isExpiredToken(jwtToken)) {
          return false;
      }

      return validateToken(jwtToken);
  }
}