package com.example.demo.service;
import com.example.demo.model.User;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;


@Service
public class UserService {

    @Value("${jwt.secret}")
    private String secret;

    public String encryptPass(User user){
        String salt= BCrypt.gensalt(10);
        String encryptedPass=BCrypt.hashpw(user.getPassword(),salt);
        return  encryptedPass;

    }

    public String generateToken(User user){
        String token=Jwts.builder().setSubject(user.getEmail()).signWith(SignatureAlgorithm.HS256,secret).compact();
        return token;
    }

    public Boolean verify(User userdata,User user){
        Boolean match=BCrypt.checkpw(userdata.getPassword(),user.getPassword());
        return match;

    }
}
