package com.example.demo.interfaces;

import org.springframework.stereotype.Component;

@Component
public interface GeneralResponse {
    public void setResponse(Key key);
    public Key getResponse();


}
