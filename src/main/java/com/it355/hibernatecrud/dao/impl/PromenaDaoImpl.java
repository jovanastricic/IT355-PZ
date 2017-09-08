/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.hibernatecrud.dao.impl;

/**
 *
 * @author Jovana BGD
 */
import com.it355.hibernatecrud.dao.PromenaDao;
import com.it355.hibernatecrud.entity.Ordinacija;
import com.it355.hibernatecrud.entity.Usluga;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Repository("promenaDao")
@Service
public class PromenaDaoImpl implements PromenaDao {

    @SuppressWarnings("unused")
    private final Log logger = LogFactory.getLog(getClass());

    //Instanciramo sesiju
    @Autowired
    private SessionFactory sessionFactory;

    //kreiramo seter za sesiju
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //kreiramo geter za sesiju
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public Usluga getUslugaById(int id) {
        /*getSession().createCriteria(Product.class).add(Restrictions.eq("id", id))
         .uniqueResult() je metoda koju omogucava Hibernate
         Ovo je vrsta SQL querry-ja pri cemu je tabela iz koje citamo podatke definisana kao
         atribut metode createCriteria, dok su parametri po kojima pretrazujemo atributi metode
         Restrictions.eq(naziv parametra u bazi, naziv parametra u entitetu). Za svaki parametar dodaje se
         posebna restrikcija.
         Ovaj kod bi mogao da se prevede u sql kao: 
         SELECT * FROM PRODUCT WHERE ID=?
         */
        Usluga usluga = (Usluga) getSession().createCriteria(Usluga.class).add(Restrictions.eq("id", id))
                .uniqueResult();
        return usluga;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Ordinacija> getOrdinacije() {
        List<Ordinacija> results = (List<Ordinacija>) getSession().createCriteria(Ordinacija.class).list();
        return results;
    }

    @Override
    @Transactional
    public Ordinacija getOrdinacijaById(int id) {
        Ordinacija ordinacija = (Ordinacija) getSession().createCriteria(Ordinacija.class).add(Restrictions.eq("id", id))
                .uniqueResult();
        return ordinacija;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Usluga> getUslugaByOrdinacija(Ordinacija ordinacija) {
        return (List<Usluga>) getSession().createCriteria(Usluga.class).add(Restrictions.eq("ordinacija", ordinacija))
                .list();
    }

    @Override
    @Transactional
    public void editOrdinacija(Ordinacija ordinacija) {
        getSession().saveOrUpdate(ordinacija);
    }

    @Override
    @Transactional
    public Ordinacija addOrdinacija(Ordinacija ordinacija) {
        return (Ordinacija) getSession().merge(ordinacija);
    }

    @Override
    @Transactional
    public void editUsluga(Usluga usluga) {
        getSession().saveOrUpdate(usluga);
    }

    @Override
    @Transactional
    public Usluga addUsluga(Usluga usluga) {
        return (Usluga) getSession().merge(usluga);
    }

    @Override
    @Transactional
    public int getCountUslugeInOrdinacija(int ordinacijaId) {
        String hql = "select count(*) from usluga where id_ordinacija = :id";
        Number result = (Number) getSession().createSQLQuery(hql).setInteger("id", ordinacijaId).uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Override
    @Transactional
    public int getCountUsluge() {
        Number result = (Number) getSession().createSQLQuery("select count(*) from usluga").uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Override
    @Transactional
    public void deleteUsluga(Usluga usluga) {
        getSession().delete(usluga);
    }

    @Override
    @Transactional
    public void deleteOrdinacija(Ordinacija ordinacija) {
        getSession().delete(ordinacija);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Usluga> getUsluge() {
        List<Usluga> results = (List<Usluga>) getSession().createCriteria(Usluga.class).list();
        return results;
    }

}
