/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.hibernatecrud.converter;

/**
 *
 * @author Jovana BGD
 */
import com.it355.hibernatecrud.dao.PromenaDao;
import com.it355.hibernatecrud.entity.Ordinacija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
final public class IntegerToOrdinacija implements Converter<String, Ordinacija> {

    @Autowired
    PromenaDao uslugaDao;

    @Override
    public Ordinacija convert(String s) {
        if (s.isEmpty()) {
            return null;
        }
        Integer valeu = Integer.valueOf(s);
        System.out.println("Konvertujem u kategoriju");
        Ordinacija ord = uslugaDao.getOrdinacijaById(valeu);
        return ord;
    }
}
