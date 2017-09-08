/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.dao;

import com.it355.model.Termin;
import java.util.List;

/**
 *
 * @author Jovana BGD
 */
public interface TerminDao {
    
public int getCount();

    public List<Termin> getAllTermini();
    public boolean addTermin(Termin termin);

    public boolean deleteTermin(int id_termin);

    public Termin getById(int id_termin);

    public int getNextId();

    public boolean updateTermin(Termin termin);
    
    public boolean zakazi(int id_termin, int id_korisnik,String dan_termin, String vreme_termin,String  opis_termin);

}
