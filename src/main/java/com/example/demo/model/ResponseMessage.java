package com.example.demo.model;

import com.example.demo.interfaces.GeneralResponse;
import com.example.demo.interfaces.Key;
import org.springframework.stereotype.Component;

@Component
public class ResponseMessage implements GeneralResponse {

    Key key;

    public void setResponse(Key key)
    {
        this.key=key;
    }

    public Key getResponse()
    {
        return this.key;
    }

}
