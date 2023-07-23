package kr.co.acctmgmt.config.jwt;

import org.springframework.stereotype.Service;

import kr.co.acctmgmt.domain.ExpRefToken;
import kr.co.acctmgmt.mapper.ExpRefTokenMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpiredRefreshTokenService {
	
	private final ExpRefTokenMapper expRefTokenMapper;

    public boolean isExpiredToken(String token) {
        return expRefTokenMapper.existsByToken(token);
    }

//    public ExpRefToken addExpiredToken(String token) {
    public void addExpiredToken(String token) {
        ExpRefToken saveToken = ExpRefToken.builder()
            .token(token)
            .build();
        
//        return expRefTokenMapper.saveToken(saveToken);
        expRefTokenMapper.saveToken(saveToken);
    }
}
