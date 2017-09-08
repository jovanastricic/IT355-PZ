/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.service.impl;

import com.it355.dao.OrdinacijaDao;
import com.it355.model.Ordinacija;
import com.it355.service.OrdinacijaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Jovana BGD
 */
public class OrdinacijaServiceImpl implements OrdinacijaService {

    @Autowired
    OrdinacijaDao ordinacijaDao;

    @Override
    public int getCount() {
        return ordinacijaDao.getCount();
    }

    @Override
    public List<Ordinacija> getAllOrdinacije() {
        return ordinacijaDao.getAllOrdinacije();
    }

    @Override
    public boolean addOrdinacija(Ordinacija ordinacija) {
        return ordinacijaDao.addOrdinacija(ordinacija);
    }

}
