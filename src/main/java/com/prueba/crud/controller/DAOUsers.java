/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.crud.controller;

import com.prueba.crud.model.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto
 */
public class DAOUsers implements IDAO<Users>{

   private boolean res;
    private ConectionDB con;
    private String sql;

    @Override
    public boolean add(Users pojo) {
        res = false;
        con = ConectionDB.getInstance();
        sql = "INSERT INTO Users (user, password) VALUES "
                + "('" + pojo.getUser()+ "','" + pojo.getPassword()+ "')";
        res = con.execute(sql);
        return res;
    }

    @Override
    public boolean update(Users pojo) {
        res = false;
        con = ConectionDB.getInstance();
        sql = "UPDATE Users SET user = '" + pojo.getUser()+ "', password = '" + pojo.getPassword()+ "' WHERE (user = " + pojo.getUser()+ ");";
        res = con.execute(sql);
        return res;

    }

    @Override
    public boolean delete(int Id) {
        res = false;
        con = ConectionDB.getInstance();
        sql = "DELETE FROM Users WHERE(user = " + Id + ");";
        res = con.execute(sql);
        return res;
    }

    @Override
    public ArrayList<Users> showAll() {
        ArrayList lista = new ArrayList<Users>();

        try {
            ResultSet datos;
            con = ConectionDB.getInstance();
            sql = "SELECT * FROM Users;";
            datos = con.executeQuery(sql);

            while (datos.next()) {
                lista.add(new Users(datos.getString(1), datos.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOClients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    @Override
    public Users showOne(int Id) {
        Users user = null;

        try {
            ResultSet datos;
            con = ConectionDB.getInstance();
            sql = "SELECT * FROM Users WHERE (Id = '" + Id + "');";
            datos = con.executeQuery(sql);

            while (datos.next()) {
                user = new Users(datos.getString(1), datos.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOClients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public Users IniciarSesion(Users pojo) {
        Users user = null;

        try {
            ResultSet datos;
            con = ConectionDB.getInstance();
            sql = "SELECT * FROM Users WHERE (user = '" + pojo.getUser() + "');";
            datos = con.executeQuery(sql);

            while (datos.next()) {
                user = new Users(datos.getString(1), datos.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOClients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    

}
