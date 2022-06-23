/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.crud.controller;

import com.prueba.crud.model.Users;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto
 */
public class FactoyDAO {
    public  enum TypeDAO{USERS,CLIENTS};
    
    public static IDAO create(TypeDAO t){
      IDAO dao = null;
        switch (t) {
            case USERS:
                 dao = new DAOUsers();
                 
                break;
                
            case CLIENTS:
                 dao = new DAOClients();
                break;
            default:
                 Logger.getLogger(FactoyDAO.class.getName()).log(Level.INFO, null, "Tipo no valido");
        }
        return dao;
    }
    
    
}
