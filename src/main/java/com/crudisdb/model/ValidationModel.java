/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudisdb.model;

/**
 *
 * @author b
 */
public class ValidationModel {
  
    private String text;
    private String mobile;
    private String email;

    public ValidationModel(String text, String mobile, String email) {
        this.text = text;
        this.mobile = mobile;
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
 
    
}
