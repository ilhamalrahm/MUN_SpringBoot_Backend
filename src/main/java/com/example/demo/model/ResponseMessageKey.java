package com.example.demo.model;

import com.example.demo.interfaces.Key;
import org.springframework.stereotype.Component;

@Component
public class ResponseMessageKey implements Key {
    public String message;

    public void setMessage(String message) {
        this.message = message;
    }
}
