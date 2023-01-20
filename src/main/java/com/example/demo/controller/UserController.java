package com.example.demo.controller;
import com.example.demo.factories.KeyFactory;
import com.example.demo.factories.ResponseFactory;
import com.example.demo.interfaces.GeneralResponse;
import com.example.demo.interfaces.Key;
import com.example.demo.model.*;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/user")
public class UserController {
    Key key;
    @Autowired
    User user;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    KeyFactory keyFactory;
    @Autowired
    GeneralResponse response;
    @Autowired
    ResponseFactory responseFactory;



    @PostMapping("/signup")
    public ResponseEntity<Key> signupUser(@RequestBody User userdata)
    {
        response=responseFactory.createResponse("signup");

        User u =userRepository.getUserByEmailEquals(userdata.getEmail());
        if(u!=null)
        {

            key=keyFactory.createKey("signup",u,"User Already Exists!");
            System.out.println(u.getEmail());
            response.setResponse(key);

            return new ResponseEntity<>(response.getResponse(), HttpStatus.CONFLICT);
        }
        else
        {
            user.setName(userdata.getName());
            user.setEmail(userdata.getEmail());
            user.setPassword(userService.encryptPass(userdata));
            user.setCollege(userdata.getCollege());
            user.setFromMahe(userdata.getFromMahe());
            user.setCommitteePref(userdata.getCommitteePref());
            user.setCountryPref(userdata.getCountryPref());
            user.setPhone(userdata.getPhone());

            userRepository.save(user);
            key=keyFactory.createKey("signup",user,"Signip Successful!");
            response.setResponse(key);



            return new ResponseEntity<>(response.getResponse(), HttpStatus.OK);
        }

    }
    @Autowired
    @PostMapping("/signin")
    public ResponseEntity<Key> signinUser(@RequestBody User userdata)
    {

        response=responseFactory.createResponse("signin");
        System.out.println("in signin");
        User u=userRepository.getUserByEmailEquals(userdata.getEmail());
        if(u==null)
        {
            System.out.println(user.getEmail()+"NULL");
            key=keyFactory.createKey("signin",u,"User Does not exist!");
            response.setResponse(key);

            return new ResponseEntity<>(response.getResponse(), HttpStatus.BAD_REQUEST);
        }
        else
        {
            System.out.println("Not null");

            if(userService.verify(userdata,u))
            {
                user=u;
                key=keyFactory.createKey("signin",user,"Signin SuccessFul!");
                response.setResponse(key);
                System.out.println(response.getResponse());
                return new ResponseEntity<>(response.getResponse(), HttpStatus.OK);
            }
            else
            {

                key=keyFactory.createKey("signin",user,"Password Incorrect!");
                response.setResponse(key);

                return new ResponseEntity<>(response.getResponse(), HttpStatus.BAD_REQUEST);
            }


        }





    }
    @PostMapping("/home")
    public ResponseEntity<Key> home(@RequestBody Context context)
    {
        response=responseFactory.createResponse("home");
        String token=context.getToken();
        if(token==null)
        {
//            user=null;
            key=keyFactory.createKey("home",user,"Unauthorized with no token!");
            return new ResponseEntity<>(response.getResponse(), HttpStatus.UNAUTHORIZED);
        }
        else
        {
            String val=Jwts.parser().setSigningKey("javainuse").parseClaimsJws(token).getBody().getSubject();
            System.out.println(val);
            user =userRepository.getUserByEmailEquals(val);
            key=keyFactory.createKey("home",user,"Authorized!");

            return new ResponseEntity<>(response.getResponse(), HttpStatus.OK);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<Key> logout()
    {
        response=responseFactory.createResponse("logout");
        key=keyFactory.createKey("home",user,"Logout Successful!");

        return new ResponseEntity<>(response.getResponse(), HttpStatus.OK);
    }

}
