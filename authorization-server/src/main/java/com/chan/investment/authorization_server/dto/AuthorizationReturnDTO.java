package com.chan.investment.authorization_server.dto;

public class AuthorizationReturnDTO {
    private String message;
    private String username;

    public AuthorizationReturnDTO() {
    }

    public AuthorizationReturnDTO(String message, String username) {
        this.message = message;
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
