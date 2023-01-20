package com.example.demo.model;

import com.example.demo.interfaces.Key;
import org.springframework.stereotype.Component;

@Component
public class ResponseKey implements Key {
    public String message;
    public Context context;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
