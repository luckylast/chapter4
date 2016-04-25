package com.example.amyhan.myforthapplication;

import java.io.Serializable;

/**
 * Created by amyhan on 3/02/16.
 */
public class ContactObject implements Serializable {
    private static final long seralVerionUID = 1L;
    private String name;
    private String phone;
    private String website;

    public ContactObject(String name, String phone, String website){
        super();
        this.name = name;
        this.phone = phone;
        this.website = website;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getWebsite(){
        return this.website;
    }
    public void setWebsite(String website){
        this.website = website;
    }

}

