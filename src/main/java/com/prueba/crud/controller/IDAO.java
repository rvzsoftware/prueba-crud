/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.crud.controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alberto
 * @param <T>
 */
public interface IDAO<T> {
    
    public boolean add(T pojo);
    
    public boolean update(T pojo);
    
    public boolean delete(int Id);
    
    public ArrayList<T> showAll();
    
    public T showOne(int Id);

    
}
