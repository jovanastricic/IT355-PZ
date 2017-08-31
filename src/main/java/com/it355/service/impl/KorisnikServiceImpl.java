/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.service.impl;

import com.it355.dao.KorisnikDao;
import com.it355.model.Korisnik;
import com.it355.service.KorisnikService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Jovana BGD
 */
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    KorisnikDao korisnikDao;

    @Override
    public int getCount() {
        return korisnikDao.getCount();
    }

    @Override
    public List<Korisnik> getAllKorisnici() {
        return korisnikDao.getAllKorisnici();
    }

    @Override
    public boolean addKorisnik(Korisnik korisnik) {
        return korisnikDao.addKorisnik(korisnik);
    }

}
