package kr.co.acctmgmt.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ExpRefToken {

	private int id;
	private String token;
	
}
