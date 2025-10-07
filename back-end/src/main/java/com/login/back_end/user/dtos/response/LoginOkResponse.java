package com.login.back_end.user.dtos.response;

public class LoginOkResponse {
    private Integer status;
    private String accesToken;

    public LoginOkResponse(Integer status, String accesToken) {
        this.status = status;
        this.accesToken = accesToken;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAccesToken() {
        return accesToken;
    }

    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }
}
