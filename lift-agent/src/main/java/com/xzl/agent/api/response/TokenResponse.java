package com.xzl.agent.api.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class TokenResponse {

    @JsonAlias("access_token")
    private String accessToken;

    @JsonAlias("token_type")
    private String tokenType;

    @JsonAlias("expires_in")
    private Integer expiresIn;

    @JsonAlias("refresh_token")
    private String refreshToken;
}
