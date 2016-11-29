/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.dao.impl;

import com.it355.dao.PregledDao;

/**
 *
 * @author Jovana BGD
 */
public class PregledDaoImpl implements PregledDao {

    @Override
    public void addPregled() {
        System.out.println("Dodajem pregled");
    }

    @Override
    public String addPregledRet() {
        System.out.println("Dodajem pregled i vracam vrednost");
        return "dodato";
    }

    @Override
    public void addPregledThrowException() throws Exception {
        System.out.println("dodajem pregled, ali bacicu gresku");
        throw new Exception("Generic Error");
    }

    @Override
    public void addPregledAround(String name) {
        System.out.println("dodajem pregled pod imenom: " + name);
    }

}
