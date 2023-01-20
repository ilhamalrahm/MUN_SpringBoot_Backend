package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component("Context")
public class Context{

    private String name;
    private String token;
    private String email;
    private String college;
    private String committee;
    private String assigned;


    public void setName(String name)
    {
        this.name=name;
    }
    public void setToken(String token)
    {
        this.token=token;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public void setCollege(String college)
    {
        this.college=college;
    }
    public void setCommittee(String committee)
    {
        this.committee=committee;
    }
    public void setAssigned(String assigned)
    {
        this.assigned=assigned;
    }

    public String getName()
    {
        return this.name;
    }
    public String getEmail(){return this.email;}
    public String getToken(){return this.token;}
    public String getCollege(){return this.college;}
    public String getCommittee(){return this.committee;}
    public String getAssigned(){return this.assigned;}




}
