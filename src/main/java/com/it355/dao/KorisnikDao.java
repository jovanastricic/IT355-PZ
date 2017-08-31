/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.dao;

import com.it355.model.Korisnik;
import java.util.List;

/**
 *
 * @author Jovana BGD
 */
public interface KorisnikDao {

    public int getCount();

    public List<Korisnik> getAllKorisnici();

    public boolean addKorisnik(Korisnik korisnik);

    public boolean deleteKorisnik(int id_korisnik);

    public Korisnik getById(int id_korisnik);

    public int getNextId();

    public boolean updateKorisnik(Korisnik korisnik);

}
