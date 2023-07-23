package kr.co.acctmgmt.mapper;

import kr.co.acctmgmt.domain.ExpRefToken;

public interface ExpRefTokenMapper {

	public boolean existsByToken(String token);
	
	public void saveToken(ExpRefToken expRefToken);
}
