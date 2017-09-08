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
public class Termin implements Serializable {

    private int id_termin;
    private Integer id_ordinacija;
    private Integer id_korisnik;
    private String dan_termin;
    private String vreme_termin;
    private String opis_termin;

    public Termin() {
    }

    public Termin(int id_termin, Integer id_ordinacija, Integer id_korisnik, String dan_termin, String vreme_termin, String opis_termin) {
        this.id_termin = id_termin;
        this.id_ordinacija = id_ordinacija;
        this.id_korisnik = id_korisnik;
        this.dan_termin = dan_termin;
        this.vreme_termin = vreme_termin;
        this.opis_termin = opis_termin;
    }

    public Integer getId_ordinacija() {
        return id_ordinacija;
    }

    public void setId_ordinacija(Integer id_ordinacija) {
        this.id_ordinacija = id_ordinacija;
    }

    public int getId_termin() {
        return id_termin;
    }

    public void setId_termin(int id_termin) {
        this.id_termin = id_termin;
    }

    public String getDan_termin() {
        return dan_termin;
    }

    public void setDan_termin(String dan_termin) {
        this.dan_termin = dan_termin;
    }

    public String getVreme_termin() {
        return vreme_termin;
    }

    public void setVreme_termin(String vreme_termin) {
        this.vreme_termin = vreme_termin;
    }

    public String getOpis_termin() {
        return opis_termin;
    }

    public void setOpis_termin(String opis_termin) {
        this.opis_termin = opis_termin;
    }

    public Integer getId_korisnik() {
        return id_korisnik;
    }

    public void setId_korisnik(Integer id_korisnik) {
        this.id_korisnik = id_korisnik;
    }

    @Override
    public String toString() {
        return "Termin{" + "id_termin=" + id_termin + ", id_ordinacija=" + id_ordinacija + ", dan_termin=" + dan_termin + ", vreme_termin=" + vreme_termin + ", opis_termin=" + opis_termin + '}';
    }

}
