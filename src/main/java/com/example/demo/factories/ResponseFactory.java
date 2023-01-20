package com.example.demo.factories;

import com.example.demo.interfaces.Factory;
import com.example.demo.interfaces.GeneralResponse;
import com.example.demo.interfaces.Key;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseFactory implements Factory {
    @Autowired
    Response response;
    @Autowired
    ResponseMessage responseMessage;

    public GeneralResponse createResponse(String type)
    {
        if(type=="signin")
        {
            return response;
        }
        else
        {
            return responseMessage;
        }
    }
}
