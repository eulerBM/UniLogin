package com.login.back_end.user.dtos.response;

public class ErroResponse {

    private Integer status;
    private String messsage;

    public ErroResponse(Integer status, String messsage) {
        this.status = status;
        this.messsage = messsage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }
}
