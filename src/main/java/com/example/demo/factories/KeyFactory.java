package com.example.demo.factories;

import com.example.demo.interfaces.Factory;
import com.example.demo.interfaces.Key;
import com.example.demo.model.*;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeyFactory implements Factory {
    @Autowired
    Context context;
    @Autowired
    UserService userService;
    @Autowired
    ResponseKey responseKey;
    @Autowired
    ResponseMessageKey responseMessageKey;




    public Key createKey(String type, User user, String message)
    {
        if(type=="signin")
        {

            if(user==null)
            {
                responseKey.setMessage(message);
                responseKey.setContext(context);
                return responseKey;
            }
            else
            {
                String token=userService.generateToken(user);
                context.setCollege(user.getCollege());
                context.setEmail(user.getEmail());
                context.setName(user.getName());
                context.setCommittee(user.getCommittee());
                context.setToken(token);
                context.setAssigned(user.getAssigned());
                responseKey.setContext(context);
                responseKey.setMessage(message);

                return responseKey;
            }

        }
        else if(type=="signup")
        {

            responseMessageKey.setMessage(message);
            return responseMessageKey;

        }
        else if(type=="home")
        {

            responseMessageKey.setMessage(message);
            return responseMessageKey;

        }
        else
        {
            responseMessageKey.setMessage(message);
            return responseMessageKey;
        }
    }
}
