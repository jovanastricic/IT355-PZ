/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.dao;

import com.it355.model.Ordinacija;
import java.util.List;

/**
 *
 * @author Jovana BGD
 */
public interface OrdinacijaDao {

    public int getCount();

    public List<Ordinacija> getAllOrdinacije();

    public boolean addOrdinacija(Ordinacija ordinacija);

    public boolean deleteOrdinacija(int id_ordinacija);

    public Ordinacija getById(int id_ordinacija);

    public int getNextId();

    public boolean updateOrdinacija(Ordinacija ordinacija);

}
