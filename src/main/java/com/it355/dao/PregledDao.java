/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.dao;

/**
 *
 * @author Jovana BGD
 */
public interface PregledDao {
    
public void addPregled();
public String addPregledRet();
public void addPregledThrowException() throws Exception;
public void addPregledAround(String name);

}
