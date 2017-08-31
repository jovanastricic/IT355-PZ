/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.service;

import com.it355.model.Usluga;
import java.util.List;

/**
 *
 * @author Jovana BGD
 */
public interface UslugaService {

    public int getCount();

    public List<Usluga> getAllUsluge();

    public boolean addUsluga(Usluga usluga);
}
