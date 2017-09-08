/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.mapper;

import com.it355.model.Ordinacija;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Jovana BGD
 */
public class OrdinacijaMapper implements RowMapper<Ordinacija> {

    @Override
    public Ordinacija mapRow(ResultSet rs, int i) throws SQLException {
        Ordinacija ordinacija = new Ordinacija();
        ordinacija.setId_ordinacija(rs.getInt("id_ordinacija"));
        ordinacija.setNaziv_ordinacija(rs.getString("naziv_ordinacija"));
        ordinacija.setOpis_ordinacija(rs.getString("opis_ordinacija"));
        ordinacija.setAdresa_ordinacija(rs.getString("adresa_ordinacija"));
        ordinacija.setTelefon_ordinacija(rs.getString("telefon_ordinacija"));
        ordinacija.setEmail_ordinacija(rs.getString("email_ordinacija"));
        ordinacija.setRadnoVreme_ordinacija(rs.getString("radnoVreme_ordinacija"));
        return ordinacija;
    }

}
