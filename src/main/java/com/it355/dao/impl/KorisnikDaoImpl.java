/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.dao.impl;

import com.it355.dao.KorisnikDao;
import com.it355.mapper.KorisnikMapper;
import com.it355.model.Korisnik;
import java.util.List;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jovana BGD
 */
public class KorisnikDaoImpl implements KorisnikDao {

    private JdbcTemplate jdbcTemplate;
    @SuppressWarnings("unused")
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM KORISNIK";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<Korisnik> getAllKorisnici() {
        String sql = "SELECT * FROM KORISNIK";
        List<Korisnik> korisnik = jdbcTemplate.query(sql, new KorisnikMapper());
        return korisnik;
    }

    @Override
    @Transactional
    public boolean addKorisnik(Korisnik korisnik) {

        String sql = "INSERT INTO KORISNIK " + "(ID_KORISNIK, IME_KORISNIK, PREZIME_KORISNIK, ADRESA_KORISNIK, EMAIL_KORISNIK, TELEFON_KORISNIK) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{korisnik.getId_korisnik(), korisnik.getIme_korisnik(), korisnik.getPrezime_korisnik(), korisnik.getAdresa_korisnik(), korisnik.getEmail_korisnik(), korisnik.getTelefon_korisnik()});
        return true;
    }

    @Override
    public boolean deleteKorisnik(int id_korisnik) {
        String sql = "DELETE FROM KORISNIK WHERE ID_KORISNIK = ?";
        jdbcTemplate.update(sql, new Object[]{id_korisnik});
        return true;
    }

    @Override
    public Korisnik getById(int id_korisnik) {
        String sql = "SELECT * FROM KORISNIK WHERE ID_KORISNIK = ?";
        Korisnik korisnik = jdbcTemplate.queryForObject(sql, new Object[]{id_korisnik}, new KorisnikMapper());
        return korisnik;
    }

    @Override
    public int getNextId() {
        String sql = "SELECT ID_KORISNIK FROM KORISNIK ORDER BY ID_KORISNIK DESC LIMIT 1";
        int temp_id = jdbcTemplate.queryForObject(sql, Integer.class);
        return temp_id++;
    }

    @Override
    public boolean updateKorisnik(Korisnik korisnik) {
        String sql = "UPDATE KORISNIK SET IME_KORISNIK = ?, PREZIME_KORISNIK = ?, ADRESA_KORISNIK = ?, EMAIL_KORISNIK = ?, TELEFON_KORISNIK = ? WHERE ID_KORISNIK = ?";
        jdbcTemplate.update(sql, new Object[]{korisnik.getIme_korisnik(), korisnik.getPrezime_korisnik(), korisnik.getAdresa_korisnik(), korisnik.getEmail_korisnik(), korisnik.getTelefon_korisnik(), korisnik.getId_korisnik()});
        return true;
    }
}
