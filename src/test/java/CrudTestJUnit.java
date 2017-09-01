
import com.it355.hibernatecrud.dao.PromenaDao;
import com.it355.hibernatecrud.entity.Ordinacija;
import com.it355.hibernatecrud.entity.Usluga;
import java.util.Arrays;
import java.util.Locale;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Jovana BGD
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/PrviDomaci-servlet.xml"})
public class CrudTestJUnit {
    
    @Autowired
    protected PromenaDao promenaDao;
    
    @Autowired
    private ApplicationContext context;
    
    @Before
    public void setUp() {
        
    }
    
    @Test
    public void addOrdinacijaTest() {
        Ordinacija ord = new Ordinacija();
        ord.setNaziv_ordinacija("Nova kategorija");
        ord.setOpis_ordinacija("Novi opis");
        ord.setAdresa_ordinacija("Nova adresa");
        ord.setEmail_ordinacija("Novi mail");
        Ordinacija newOrd = promenaDao.addOrdinacija(ord);
        promenaDao.deleteOrdinacija(newOrd);
        Assert.assertNotNull(newOrd);
    }
    
    @Test
    public void getOrdinacijaByIdTest() {
        Ordinacija ord = new Ordinacija();
        ord.setNaziv_ordinacija("Nova kategorija");
        ord.setOpis_ordinacija("Novi opis");
        ord.setAdresa_ordinacija("Nova adresa");
        ord.setEmail_ordinacija("Novi mail");
        Ordinacija newOrd = promenaDao.addOrdinacija(ord);
        Ordinacija get = promenaDao.getOrdinacijaById(newOrd.getId_ordinacija());
        promenaDao.deleteOrdinacija(newOrd);
        Assert.assertNotNull(get);
    }
    
    @Test
    public void createUslugaTest() {
        Usluga usl = new Usluga();
        usl.setTip_usluga("Novi tip");
        usl.setNaziv_usluga("Nova usluga");
        usl.setCena_usluga(2500);
        Usluga newUsl = promenaDao.addUsluga(usl);
        promenaDao.deleteUsluga(newUsl);
        Assert.assertNotNull(newUsl);
    }
    
    @Test
    public void getUslugaByIdTest() {
        Usluga usl = new Usluga();
        usl.setTip_usluga("Novi tip");
        usl.setNaziv_usluga("Nova usluga");
        usl.setCena_usluga(2500);
        Usluga newUsl = promenaDao.addUsluga(usl);
        Usluga get = promenaDao.getUslugaById(newUsl.getId_usluga());
        promenaDao.deleteUsluga(newUsl);
        Assert.assertNotNull(get);
    }
    
    @Test
    public void deleteUslugaTest() {
        Usluga usl = new Usluga();
        usl.setTip_usluga("Novi tip");
        usl.setNaziv_usluga("Nova usluga");
        usl.setCena_usluga(2500);
        Usluga newPro = promenaDao.addUsluga(usl);
        promenaDao.deleteUsluga(newPro);
        Usluga deletedUsluga = promenaDao.getUslugaById(newPro.getId_usluga());
        Assert.assertNull(deletedUsluga);
    }
    }