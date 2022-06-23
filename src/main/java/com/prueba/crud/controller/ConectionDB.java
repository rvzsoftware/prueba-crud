/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto
 */
public class ConectionDB {
    
    protected static Connection connect;
    protected static ConectionDB instance;
    protected Statement st;
    private String URl;

    private ConectionDB() {
        this.URl = "clientes.db";
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+this.URl);
        } catch (SQLException e) {
            Logger.getLogger(e.getMessage());
        }
        finally{}

    }

    public static ConectionDB getInstance() {
        if (instance == null) {
            instance = new ConectionDB();
        }

        return instance;

    }

    public boolean execute(String sql) {
        boolean res = false;
        try {

            st = connect.createStatement();
            st.execute(sql);
            res = true;

        } catch (SQLException ex) {
            Logger.getLogger(ConectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{}
        return res;
    }

    public ResultSet executeQuery(String sql) {
        ResultSet res = null;
        try {
            st = connect.createStatement();
            res = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{}
        return res;
    }

    
}
