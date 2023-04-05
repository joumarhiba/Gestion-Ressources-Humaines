package com.GRH.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class HttpResponse {
    @JsonProperty(value = "status", access = JsonProperty.Access.READ_ONLY)
    private int statusCode;

    @JsonProperty(value = "message", access = JsonProperty.Access.READ_ONLY)
    private String msg;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Object data;



    public HttpResponse(int status, String msg) {
        this.statusCode = status;
        this.msg = msg;
    }

    public HttpResponse(int status, Object data, String msg) {
        this.statusCode = status;
        this.data = data;
        this.msg = msg;
    }

    public HttpResponse(){
        super();
    }

}
