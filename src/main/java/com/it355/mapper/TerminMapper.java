/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.mapper;

import com.it355.model.Termin;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Jovana BGD
 */
public class TerminMapper implements RowMapper<Termin> {

    @Override
    public Termin mapRow(ResultSet rs, int arg1) throws SQLException {
        Termin termin = new Termin();
        termin.setId_termin(rs.getInt("id_termin"));
        termin.setDan_termin(rs.getString("dan_termin"));
        termin.setVreme_termin(rs.getString("vreme_termin"));
        termin.setOpis_termin(rs.getString("opis_termin"));
        return termin;
    }

}
