/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.crud.model;

/**
 *
 * @author Alberto
 */
public class Users {
    
    public String User;
    public String Password;

    public Users(String User, String Password) {
        this.User = User;
        this.Password = Password;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    
}
