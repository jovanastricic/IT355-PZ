/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.dao.impl;

import com.it355.dao.OrdinacijaDao;
import com.it355.mapper.OrdinacijaMapper;
import com.it355.model.Ordinacija;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jovana BGD
 */
public class OrdinacijaDaoImpl implements OrdinacijaDao {

    private JdbcTemplate jdbcTemplate;
    @SuppressWarnings("unused")
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM ORDINACIJA";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<Ordinacija> getAllOrdinacije() {
        String sql = "SELECT * FROM ORDINACIJA";
        List<Ordinacija> ordinacija = jdbcTemplate.query(sql, new OrdinacijaMapper());
        
        return ordinacija;
    }

    @Override
    public boolean addOrdinacija(Ordinacija ordinacija) {
        String sql = "INSERT INTO ORDINACIJA " + "(ID_ORDINACIJA, NAZIV_ORDINACIJA, OPIS_ORDINACIJA, ADRESA_ORDINACIJA, TELEFON_ORDINACIJA, EMAIL_ORDINACIJA, RADNOVREME_ORDINACIJA) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{ordinacija.getId_ordinacija(), ordinacija.getNaziv_ordinacija(), ordinacija.getOpis_ordinacija(), ordinacija.getAdresa_ordinacija(), ordinacija.getTelefon_ordinacija(), ordinacija.getEmail_ordinacija(), ordinacija.getRadnoVreme_ordinacija()});
        return true;
    }

    @Override
    public boolean deleteOrdinacija(int id_ordinacija) {
        String sql = "DELETE FROM ORDINACIJA WHERE ID_ORDINACIJA = ?";
        jdbcTemplate.update(sql, new Object[]{id_ordinacija});
        return true;
    }

    @Override
    public Ordinacija getById(int id_ordinacija) {
        String sql = "SELECT * FROM KORISNIK WHERE ID_KORISNIK = ?";
        Ordinacija ordinacija = jdbcTemplate.queryForObject(sql, new Object[]{id_ordinacija}, new OrdinacijaMapper());
        return ordinacija;
    }

    @Override
    public int getNextId() {
        String sql = "SELECT ID_ORDINACIJA FROM ORDINACIJA ORDER BY ID_ORDINACIJA DESC LIMIT 1";
        int temp_id = jdbcTemplate.queryForObject(sql, Integer.class);
        return temp_id++;
    }

    @Override
    public boolean updateOrdinacija(Ordinacija ordinacija) {
        String sql = "UPDATE ORDINACIJA SET NAZIV_ORDINACIJA = ?, OPIS_ORDINACIJA = ?, ADRESA_ORDINACIJA = ?, TELEFON_ORDINACIJA = ?, EMAIL_ORDINACIJA = ?, RADNOVREME_ORDINACIJA = ? WHERE ID_ORDINACIJA = ?";
        jdbcTemplate.update(sql, new Object[]{ordinacija.getNaziv_ordinacija(), ordinacija.getOpis_ordinacija(), ordinacija.getAdresa_ordinacija(), ordinacija.getTelefon_ordinacija(), ordinacija.getEmail_ordinacija(), ordinacija.getRadnoVreme_ordinacija(), ordinacija.getId_ordinacija()});
        return true;
    }

}
