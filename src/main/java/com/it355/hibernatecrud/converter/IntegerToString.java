/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.hibernatecrud.converter;

import com.it355.dao.TerminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jovana BGD
 */
public class IntegerToString implements Converter<String, Integer> {

    @Autowired
    TerminDao terminDao;

    @Override
    public Integer convert(String s) {
        if (s.isEmpty()) {
            return null;
        }
        Integer valeu = Integer.valueOf(s);
        System.out.println("Konvertujem u ordinaciju");
        return valeu;
    }
}
