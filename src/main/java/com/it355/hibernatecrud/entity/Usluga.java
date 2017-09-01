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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usluga")
public class Usluga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usluga")
    private Integer id_usluga;

    @ManyToOne
    @JoinColumn(name = "id_ordinacija", referencedColumnName = "id_ordinacija")
    private Ordinacija ordinacija;

    @Column(name = "tip_usluga")
    private String tip_usluga;

    @Column(name = "naziv_usluga")
    private String naziv_usluga;

    @Column(name = "cena_usluga")
    private Integer cena_usluga;

    public Integer getId_usluga() {
        return id_usluga;
    }

    public void setId_usluga(Integer id_usluga) {
        this.id_usluga = id_usluga;
    }

    public Ordinacija getOrdinacija() {
        return ordinacija;
    }

    public void setOrdinacija(Ordinacija ordinacija) {
        this.ordinacija = ordinacija;
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

    public Integer getCena_usluga() {
        return cena_usluga;
    }

    public void setCena_usluga(Integer cena_usluga) {
        this.cena_usluga = cena_usluga;
    }

    @Override
    public String toString() {
        return "Usluga{" + "id_usluga=" + id_usluga + ", ordinacija=" + ordinacija + ", tip_usluga=" + tip_usluga + ", naziv_usluga=" + naziv_usluga + ", cena_usluga=" + cena_usluga + '}';
    }

}
