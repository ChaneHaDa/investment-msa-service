package com.chan.investment.authorization_server.dto;

public class AuthenticateReturnDTO {
    private String accessToken;
    private String expiredAt;

    public AuthenticateReturnDTO() {
    }

    public AuthenticateReturnDTO(String accessToken, String expiredAt) {
        this.accessToken = accessToken;
        this.expiredAt = expiredAt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(String expiredAt) {
        this.expiredAt = expiredAt;
    }
}
