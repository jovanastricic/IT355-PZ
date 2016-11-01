/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.model;




/**
 *
 * @author Jovana BGD
 */
public class Pregled {

    private String imeIPrezime;
    private String jmbg;
    private String email;
    private String telefon;
    private String datum;
    private String vreme;
    private String opis;

    public Pregled() {
    }

    public Pregled(String imeIPrezime, String jmbg, String email, String telefon, String datum, String vreme, String opis) {
        this.imeIPrezime = imeIPrezime;
        this.jmbg = jmbg;
        this.email = email;
        this.telefon = telefon;
        this.datum = datum;
        this.vreme = vreme;
        this.opis = opis;
    }

    public String getImeIPrezime() {
        return imeIPrezime;
    }

    public void setImeIPrezime(String imeIPrezime) {
        this.imeIPrezime = imeIPrezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

}
