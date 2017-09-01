/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.hibernatecrud.entity;

/**
 *
 * @author Jovana BGD
 */
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "ordinacija")
public class Ordinacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ordinacija")
    private Integer id_ordinacija;

    @Column(name = "naziv_ordinacija")
    private String naziv_ordinacija;

    @Column(name = "opis_ordinacija")
    private String opis_ordinacija;

    @Column(name = "adresa_ordinacija")
    private String adresa_ordinacija;

    @Column(name = "telefon_ordinacija")
    private String telefon_ordinacija;

    @Column(name = "email_ordinacija")
    private String email_ordinacija;

    @Column(name = "radnovreme_ordinacija")
    private String radnovreme_ordinacija;

    public Ordinacija() {
    }

    public Integer getId_ordinacija() {
        return id_ordinacija;
    }

    public void setId_ordinacija(Integer id_ordinacija) {
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

    public String getRadnovreme_ordinacija() {
        return radnovreme_ordinacija;
    }

    public void setRadnovreme_ordinacija(String radnovreme_ordinacija) {
        this.radnovreme_ordinacija = radnovreme_ordinacija;
    }

    @Override
    public String toString() {
        return naziv_ordinacija;
    }

}
