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
public class Korisnik implements Serializable{

    private int id_korisnik;
    private String ime_korisnik;
    private String prezime_korisnik;
    private String adresa_korisnik;
    private String email_korisnik;
    private String telefon_korisnik;

    public int getId_korisnik() {
        return id_korisnik;
    }

    public void setId_korisnik(int id_korisnik) {
        this.id_korisnik = id_korisnik;
    }

    public String getIme_korisnik() {
        return ime_korisnik;
    }

    public void setIme_korisnik(String ime_korisnik) {
        this.ime_korisnik = ime_korisnik;
    }

    public String getPrezime_korisnik() {
        return prezime_korisnik;
    }

    public void setPrezime_korisnik(String prezime_korisnik) {
        this.prezime_korisnik = prezime_korisnik;
    }

    public String getAdresa_korisnik() {
        return adresa_korisnik;
    }

    public void setAdresa_korisnik(String adresa_korisnik) {
        this.adresa_korisnik = adresa_korisnik;
    }

    public String getEmail_korisnik() {
        return email_korisnik;
    }

    public void setEmail_korisnik(String email_korisnik) {
        this.email_korisnik = email_korisnik;
    }

    public String getTelefon_korisnik() {
        return telefon_korisnik;
    }

    public void setTelefon_korisnik(String telefon_korisnik) {
        this.telefon_korisnik = telefon_korisnik;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "id_korisnik=" + id_korisnik + ", ime_korisnik=" + ime_korisnik + ", prezime_korisnik=" + prezime_korisnik + ", adresa_korisnik=" + adresa_korisnik + ", email_korisnik=" + email_korisnik + ", telefon_korisnik=" + telefon_korisnik + '}';
    }
}