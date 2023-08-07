package kr.co.acctmgmt.config.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import kr.co.acctmgmt.config.jwt.JwtAuthenticationFilter;
import kr.co.acctmgmt.config.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtUtil jwtUtil;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // origin 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占� port 占쎈쐻占쎈짗占쎌굲 "*" 占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈솂占쎈섣占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈뻼占쎌뒻占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�
        // Arrays.asList("<http://localhost:3000>") 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈뱜占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈솂占쎈섣占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲.
        corsConfiguration.setAllowCredentials(true); // 'Access-Control-Allow-Credentials' 占쎈엘占쎈쐭�몴占� true嚥∽옙 占쎄퐬占쎌젟

        corsConfiguration.setAllowedOriginPatterns(Arrays.asList("*"));
        // 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占� method "*" 占쎈쐻占쎈짗占쎌굲 "GET", "POST", "PUT", "DELETE", "OPTIONS" 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        // 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占� header
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        // 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈뻻占쎄땔占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占� 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占� header
        corsConfiguration.setExposedHeaders(Arrays.asList("Authorization", "refresh-token", "access-token"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable()
            .csrf().disable()
            .formLogin().disable()
            .cors().configurationSource(corsConfigurationSource())
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/login/**").permitAll()
            .antMatchers("/join/**").permitAll()
            .antMatchers("/join").permitAll()
            .antMatchers("/emp/**").permitAll()
            .antMatchers("/bgt/**").permitAll()
            .antMatchers("/syscfg/**").permitAll()
            .antMatchers("/info/**").permitAll()
//            .antMatchers("/ozt/**").permitAll()
            .antMatchers("/logouta/**").permitAll()
            .antMatchers("/message").permitAll()
            .antMatchers("/api/**").permitAll()
            .antMatchers("/pjtDate/**").permitAll()
            .antMatchers("/pjtSelDate/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(new JwtAuthenticationFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
    }

}
