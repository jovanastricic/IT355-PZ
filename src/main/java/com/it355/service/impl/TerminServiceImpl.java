/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.service.impl;

import com.it355.dao.TerminDao;
import com.it355.model.Termin;
import com.it355.service.TerminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Jovana BGD
 */
public class TerminServiceImpl implements TerminService {

    @Autowired
    TerminDao terminDao;

    @Override
    public int getCount() {
        return terminDao.getCount();
    }

    @Override
    public List<Termin> getAllTermini() {
        return terminDao.getAllTermini();
    }

    @Override
    public boolean addTermin(Termin termin) {
      return terminDao.addTermin(termin);
    }

}
