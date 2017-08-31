/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.dao.impl;

import com.it355.dao.UslugaDao;
import com.it355.mapper.UslugaMapper;
import com.it355.model.Usluga;
import java.util.List;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jovana BGD
 */
public class UslugaDaoImpl implements UslugaDao {

    private JdbcTemplate jdbcTemplate;
    @SuppressWarnings("unused")
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM USLUGA";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<Usluga> getAllUsluge() {
        String sql = "SELECT * FROM USLUGA";
        List<Usluga> usluga = jdbcTemplate.query(sql, new UslugaMapper());
        return usluga;
    }

    @Override
    @Transactional
    public boolean addUsluga(Usluga usluga) {
        int ordinacija = 1;

        String sql = "INSERT INTO USLUGA " + "(ID_USLUGA, ID_ORDINACIJA, TIP_USLUGA, NAZIV_USLUGA, CENA_USLUGA) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{usluga.getId_usluga(), ordinacija, usluga.getTip_usluga(), usluga.getNaziv_usluga(), usluga.getCena_usluga()});
        return true;
    }

    @Override
    public boolean deleteUsluga(int id_usluga) {
        String sql = "DELETE FROM USLUGA WHERE ID_USLUGA = ? ";
        jdbcTemplate.update(sql, new Object[]{id_usluga});
        return true;
    }

    @Override
    public Usluga getById(int id_usluga) {
        String sql = "SELECT * FROM USLUGA WHERE ID_USLUGA = ?";
        Usluga usluga = jdbcTemplate.queryForObject(sql, new Object[]{id_usluga}, new UslugaMapper());
        return usluga;
    }

    @Override
    public int getNextId() {
        String sql = "SELECT ID_USLUGA FROM USLUGA ORDER BY ID_USLUGA DESC LIMIT 1";
        int temp_id = jdbcTemplate.queryForObject(sql, Integer.class);
        return temp_id++;
    }

    @Override
    public boolean updateUsluga(Usluga usluga) {
        int ordinacija = 1;
        String sql = "UPDATE USLUGA SET TIP_USLUGA = ?, NAZIV_USLUGA = ?, CENA_USLUGA = ? WHERE ID_USLUGA = ?";
        jdbcTemplate.update(sql, new Object[]{usluga.getTip_usluga(), usluga.getNaziv_usluga(), usluga.getCena_usluga(), usluga.getId_usluga()});
        return true;
    }

 }
