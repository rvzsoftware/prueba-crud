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
public class Clients {
    
    private long Id;
    private String Nombre;
    private String RFC;
    private String Telefono;
    private String Email;

    public Clients(long Id,String Nombre, String RFC, String Telefono, String Email) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.RFC = RFC;
        this.Telefono = Telefono;
        this.Email = Email;
    }
    public Clients(String Nombre, String RFC, String Telefono, String Email) {
        this.Nombre = Nombre;
        this.RFC = RFC;
        this.Telefono = Telefono;
        this.Email = Email;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
    
    
}
