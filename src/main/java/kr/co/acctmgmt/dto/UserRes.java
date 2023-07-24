package kr.co.acctmgmt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRes {
    private Long id;
    private String email;
    private String name;
    private String accessToken;
    private String refreshToken;
}