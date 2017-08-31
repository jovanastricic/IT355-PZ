/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.model;

import java.io.Serializable;

/**
 *
 * @author Jovana BGD
 */
@SuppressWarnings("serial")
public class Usluga implements Serializable {

    private int id_usluga;
    private String tip_usluga;
    private String naziv_usluga;
    private int cena_usluga;

    public int getId_usluga() {
        return id_usluga;
    }

    public void setId_usluga(int id_usluga) {
        this.id_usluga = id_usluga;
    }

    public String getTip_usluga() {
        return tip_usluga;
    }

    public void setTip_usluga(String tip_usluga) {
        this.tip_usluga = tip_usluga;
    }

    public String getNaziv_usluga() {
        return naziv_usluga;
    }

    public void setNaziv_usluga(String naziv_usluga) {
        this.naziv_usluga = naziv_usluga;
    }

    public int getCena_usluga() {
        return cena_usluga;
    }

    public void setCena_usluga(int cena_usluga) {
        this.cena_usluga = cena_usluga;
    }

    @Override
    public String toString() {
        return "Usluga{" + "id_usluga=" + id_usluga + ", tip_usluga=" + tip_usluga + ", naziv_usluga=" + naziv_usluga + ", cena_usluga=" + cena_usluga + '}';
    }
}
