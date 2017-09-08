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
public class Ordinacija implements Serializable {

    private int id_ordinacija;
    private String naziv_ordinacija;
    private String opis_ordinacija;
    private String adresa_ordinacija;
    private String telefon_ordinacija;
    private String email_ordinacija;
    private String radnoVreme_ordinacija;

    public Ordinacija() {
    }

    public Ordinacija(int id_ordinacija, String naziv_ordinacija, String opis_ordinacija, String adresa_ordinacija, String telefon_ordinacija, String email_ordinacija, String radnoVreme_ordinacija) {
        this.id_ordinacija = id_ordinacija;
        this.naziv_ordinacija = naziv_ordinacija;
        this.opis_ordinacija = opis_ordinacija;
        this.adresa_ordinacija = adresa_ordinacija;
        this.telefon_ordinacija = telefon_ordinacija;
        this.email_ordinacija = email_ordinacija;
        this.radnoVreme_ordinacija = radnoVreme_ordinacija;
    }

    public int getId_ordinacija() {
        return id_ordinacija;
    }

    public void setId_ordinacija(int id_ordinacija) {
        this.id_ordinacija = id_ordinacija;
    }

    public String getNaziv_ordinacija() {
        return naziv_ordinacija;
    }

    public void setNaziv_ordinacija(String naziv_ordinacija) {
        this.naziv_ordinacija = naziv_ordinacija;
    }

    public String getOpis_ordinacija() {
        return opis_ordinacija;
    }

    public void setOpis_ordinacija(String opis_ordinacija) {
        this.opis_ordinacija = opis_ordinacija;
    }

    public String getAdresa_ordinacija() {
        return adresa_ordinacija;
    }

    public void setAdresa_ordinacija(String adresa_ordinacija) {
        this.adresa_ordinacija = adresa_ordinacija;
    }

    public String getTelefon_ordinacija() {
        return telefon_ordinacija;
    }

    public void setTelefon_ordinacija(String telefon_ordinacija) {
        this.telefon_ordinacija = telefon_ordinacija;
    }

    public String getEmail_ordinacija() {
        return email_ordinacija;
    }

    public void setEmail_ordinacija(String email_ordinacija) {
        this.email_ordinacija = email_ordinacija;
    }

    public String getRadnoVreme_ordinacija() {
        return radnoVreme_ordinacija;
    }

    public void setRadnoVreme_ordinacija(String radnoVreme_ordinacija) {
        this.radnoVreme_ordinacija = radnoVreme_ordinacija;
    }

    @Override
    public String toString() {
        return "Ordinacija{" + "id_ordinacija=" + id_ordinacija + ", naziv_ordinacija=" + naziv_ordinacija + ", opis_ordinacija=" + opis_ordinacija + ", adresa_ordinacija=" + adresa_ordinacija + ", telefon_ordinacija=" + telefon_ordinacija + ", email_ordinacija=" + email_ordinacija + ", radnoVreme_ordinacija=" + radnoVreme_ordinacija + '}';
    }

}
