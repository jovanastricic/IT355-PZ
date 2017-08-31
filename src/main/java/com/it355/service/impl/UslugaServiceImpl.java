/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.service.impl;

import com.it355.dao.UslugaDao;
import com.it355.model.Usluga;
import com.it355.service.UslugaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Jovana BGD
 */
public class UslugaServiceImpl implements UslugaService {

    @Autowired
    UslugaDao uslugaDao;

    @Override
    public int getCount() {
        return uslugaDao.getCount();
    }

    @Override
    public List<Usluga> getAllUsluge() {
        return uslugaDao.getAllUsluge();
    }

    @Override
    public boolean addUsluga(Usluga usluga) {
        return uslugaDao.addUsluga(usluga);
    }

}
