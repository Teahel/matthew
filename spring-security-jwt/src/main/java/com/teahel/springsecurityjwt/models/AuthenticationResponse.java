package com.teahel.springsecurityjwt.models;

/**
 * @author li.teahel@gmail.com
 * @date 2021/4/28
 */
public class AuthenticationResponse {

    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
