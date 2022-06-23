/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.crud.controller;

import com.prueba.crud.model.Clients;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto
 */
public class DAOClients implements IDAO<Clients> {

    private boolean res;
    private ConectionDB con;
    private String sql;

    @Override
    public boolean add(Clients pojo) {
        res = false;
        con = ConectionDB.getInstance();
        sql = "INSERT INTO Clients (Nombre, RFC, Telefono, Email) VALUES "
                + "('" + pojo.getNombre() + "','" + pojo.getRFC() + "','"
                + pojo.getTelefono() + "','" + pojo.getEmail() + "')";
        res = con.execute(sql);
        return res;
    }

    @Override
    public boolean update(Clients pojo) {
        res = false;
        con = ConectionDB.getInstance();
        sql = "UPDATE Clients SET Nombre = '" + pojo.getNombre() + "', RFC = '" + pojo.getRFC() + "', Telefono = '" + pojo.getTelefono() + "', Email = '" + pojo.getEmail() + "' WHERE (Id = " + pojo.getId() + ");";
        res = con.execute(sql);
        return res;

    }

    @Override
    public boolean delete(int id) {
        res = false;
        con = ConectionDB.getInstance();
        sql = "DELETE FROM Clients WHERE(Id = " + id + ");";
        res = con.execute(sql);
        return res;
    }

    @Override
    public ArrayList<Clients> showAll() {
        ArrayList lista = new ArrayList<Clients>();

        try {
            ResultSet datos;
            con = ConectionDB.getInstance();
            sql = "SELECT * FROM Clients;";
            datos = con.executeQuery(sql);

            while (datos.next()) {
                lista.add(new Clients(datos.getLong(1), datos.getString(2), datos.getString(3), datos.getString(4), datos.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOClients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    @Override
    public Clients showOne(int Id) {
        Clients cliente = null;

        try {
            ResultSet datos;
            con = ConectionDB.getInstance();
            sql = "SELECT * FROM Clients WHERE (Id = " + Id + ");";
            datos = con.executeQuery(sql);

            while (datos.next()) {
                cliente = new Clients(datos.getLong(1), datos.getString(2), datos.getString(3), datos.getString(4), datos.getString(5));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOClients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

}
