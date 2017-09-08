/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.dao.impl;

import com.it355.dao.TerminDao;
import com.it355.mapper.TerminMapper;
import com.it355.model.Termin;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jovana BGD
 */
public class TerminDaoImpl implements TerminDao {

    private JdbcTemplate jdbcTemplate;
    @SuppressWarnings("unused")
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM TERMIN";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<Termin> getAllTermini() {
        String sql = "SELECT * FROM TERMIN";
        List<Termin> termin = jdbcTemplate.query(sql, new TerminMapper());
        return termin;
    }

    @Override
    public boolean addTermin(Termin termin) {
        int ordinacija = 1;

        String sql = "INSERT INTO TERMIN "
                + "(ID_TERMIN, ID_ORDINACIJA, ID_KORISNIK, DAN_TERMIN, VREME_TERMIN, OPIS_TERMIN) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{termin.getId_termin(), ordinacija, termin.getId_korisnik(),
            termin.getDan_termin(), termin.getVreme_termin(), termin.getOpis_termin()});
        return true;
    }

    @Override
    public boolean deleteTermin(int id_termin) {
        String sql = "DELETE FROM TERMIN WHERE ID_TERMIN = ? ";
        jdbcTemplate.update(sql, new Object[]{id_termin});
        return true;
    }

    @Override
    public Termin getById(int id_termin) {
        String sql = "SELECT * FROM TERMIN WHERE ID_TERMIN = ?";
        Termin termin = jdbcTemplate.queryForObject(sql, new Object[]{id_termin}, new TerminMapper());
        return termin;
    }

    @Override
    public int getNextId() {
        String sql = "SELECT ID_TERMIN FROM TERMIN ORDER BY ID_TERMIN DESC LIMIT 1";
        int temp_id = jdbcTemplate.queryForObject(sql, Integer.class);
        return temp_id + 1;
    }

    @Override
    public boolean updateTermin(Termin termin) {
        int ordinacija = 1;
        String sql = "UPDATE TERMIN SET DAN_TERMIN = ?, VREME_TERMIN = ?, OPIS_TERMIN = ? WHERE ID_TERMIN = ?";
        jdbcTemplate.update(sql, new Object[]{termin.getDan_termin(), termin.getVreme_termin(), termin.getOpis_termin(), termin.getId_termin()});
        return true;
    }

    @Override
    public boolean zakazi(int id_termin, int id_korisnik, String dan_termin, String vreme_termin, String opis_termin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
