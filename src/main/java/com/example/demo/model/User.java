package com.example.demo.model;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "Users")
@Component("Users")
public class User {
    private String name;
//    @Indexed(unique = true)
    private String email;
    private String password;
    private String college;
    private String committee="";
    private String assigned="";
    private Boolean paymentDone=false;
    private Boolean fromMahe;
    private String committeePref="";
    private String countryPref="";
    private String phone="";

    public void setName(String name)
    {
        this.name=name;
    }
    public void setPassword(String password)
    {
        this.password=password;
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
    public void setPaymentDone(Boolean paymentDone)
    {
        this.paymentDone=paymentDone;
    }
    public void setFromMahe(Boolean fromMahe)
    {
        this.fromMahe=fromMahe;
    }
    public void setCommitteePref(String committeePref)
    {
        this.committeePref=committeePref;
    }
    public void setCountryPref(String countryPref)
    {
        this.countryPref=countryPref;
    }
    public void setPhone(String phone)
    {
        this.phone=phone;
    }

    public String getName()
    {
        return this.name;
    }
    public String getEmail(){return this.email;}
    public String getPassword(){return this.password;}
    public String getCollege(){return this.college;}
    public String getCommittee(){return this.committee;}
    public String getAssigned(){return this.assigned;}
    public String getCommitteePref(){return this.committeePref;}
    public String getCountryPref(){return this.countryPref;}
    public String getPhone(){return this.phone;}
    public Boolean getPaymentDone(){return this.paymentDone;}
    public Boolean getFromMahe(){return this.fromMahe;}





}
