/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.controller;

import com.it355.dao.KorisnikDao;
import com.it355.dao.OrdinacijaDao;
import com.it355.dao.TerminDao;
import com.it355.dao.UslugaDao;
import com.it355.model.Korisnik;
import com.it355.model.Ordinacija;
import com.it355.model.Termin;
import com.it355.model.Usluga;
import com.it355.service.KorisnikService;
import com.it355.service.OrdinacijaService;
import com.it355.service.TerminService;
import com.it355.service.UslugaService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Autowired
    UslugaDao uslugaDao;

    @Autowired
    KorisnikDao korisnikDao;

    @Autowired
    TerminDao terminDao;

    @Autowired
    OrdinacijaDao ordinacijaDao;

    @Autowired
    UslugaService uslugaService;

    @Autowired
    KorisnikService korisnikService;

    @Autowired
    TerminService terminService;

    @Autowired
    OrdinacijaService ordinacijaService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView model = new ModelAndView();
        //model.addObject("message", "Ovo je strana kojoj svi moguda pristupe!");
        model.setViewName("hello");
        return model;
    }

    @RequestMapping(value = {"/kontakt"}, method = RequestMethod.GET)
    public ModelAndView kontaktPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("kontakt");
        return model;
    }

    @RequestMapping(value = {"/saveti"}, method = RequestMethod.GET)
    public ModelAndView savetiPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("saveti");
        return model;
    }

    @RequestMapping(value = {"/onama"}, method = RequestMethod.GET)
    public ModelAndView onamaPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("onama");
        return model;
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Ovo je strana za admine!");
        model.setViewName("admin");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Losi login podaci!");
        }
        if (logout != null) {
            model.addObject("msg", "Izlogovani ste.");
        }
        model.setViewName("login");
        return model;
    }

///////////////////////////
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.addObject("korisnik", new Korisnik());
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("korisnik") Korisnik korisnik, ModelAndView model) {
        model.addObject("object", korisnik);
        korisnik.setId_korisnik(korisnikDao.getNextId());
        korisnikDao.addKorisnik(korisnik);
        int idUser = korisnikDao.getNextIdUser();
        korisnikDao.addUser(korisnik.getId_korisnik(), korisnik.getUsername(), korisnik.getPassword());

        korisnikDao.addUserRole(idUser);

        model.setViewName("login");
        return model;

    }

    /////////////////////////
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);
            model.addObject("username", userDetail.getUsername());
        }
        model.setViewName("403");
        return model;
    }

    @RequestMapping(value = "/usluge", method = RequestMethod.GET)
    public ModelAndView usluge(ModelAndView modelAndView) {
        List<Usluga> usluge = uslugaDao.getAllUsluge();
        modelAndView.addObject("usluge", usluge);
        modelAndView.setViewName("usluge");
        return modelAndView;
    }

    @RequestMapping(value = "/korisnici", method = RequestMethod.GET)
    public ModelAndView korisnici(ModelAndView modelAndView) {
        List<Korisnik> korisnici = korisnikDao.getAllKorisnici();
        for (Korisnik korisnik : korisnici) {
            System.err.println(korisnik.toString());
        }
        modelAndView.addObject("korisnici", korisnici);
        modelAndView.setViewName("korisnici");
        return modelAndView;
    }

    @RequestMapping(value = "/termini", method = RequestMethod.GET)
    public ModelAndView termini(ModelAndView modelAndView) {
        List<Termin> termini = terminDao.getAllTermini();
        modelAndView.addObject("termini", termini);
        modelAndView.setViewName("termini");
        return modelAndView;
    }

    @RequestMapping(value = "/adduslugaa", method = RequestMethod.GET)
    public String addUsluga(Model model) {
        model.addAttribute("usluga", new Usluga());
        return "adduslugaa";
    }

    @RequestMapping(value = "/adduslugaa", method = RequestMethod.POST)
    public ModelAndView addUsluga(@ModelAttribute("usluga") Usluga u, ModelAndView model) {
        model.addObject("object", u);
        u.setId_usluga(uslugaDao.getCount() + 1);
        uslugaDao.addUsluga(u);
        return model;
    }

    @RequestMapping(value = "/deleteusluga/{id}.{naziv}", method = RequestMethod.GET)
    public String deleteUsluga(@PathVariable("id") int id, @PathVariable("naziv") String naziv,
            HttpServletRequest request) {
        uslugaDao.deleteUsluga(id);
        return "hello";
    }

    @RequestMapping(value = "/updateusluga/{id}", method = RequestMethod.GET)
    public ModelAndView updateUsluga(@PathVariable("id") int id, HttpServletRequest request, ModelAndView model) {
        Usluga usluga = uslugaDao.getById(id);
        model.addObject("usluga", usluga);
        model.setViewName("updateusluga");
        return model;
    }

    @RequestMapping(value = "/updateusluga/{id}", method = RequestMethod.POST)
    public ModelAndView updateUsluga(@ModelAttribute("usluga") Usluga u, ModelAndView model) {
        model.addObject("object", u);
        model.setViewName("hello");
        uslugaDao.updateUsluga(u);
        return model;
    }

    @RequestMapping(value = "/addkorisnik", method = RequestMethod.GET)
    public String addKorisnik(Model model) {
        model.addAttribute("korisnik", new Korisnik());
        return "addkorisnik";
    }

    @RequestMapping(value = "/addkorisnik", method = RequestMethod.POST)
    public ModelAndView addKorisnik(@ModelAttribute("korisnik") Korisnik k, ModelAndView model) {
        model.addObject("object", k);
        k.setId_korisnik(korisnikDao.getCount() + 1);
        korisnikDao.addKorisnik(k);
        return model;
    }

    @RequestMapping(value = "/deletekorisnik/{id}.{ime}.{prezime}", method = RequestMethod.GET)
    public String deleteKorisnik(@PathVariable("id") int id, @PathVariable("ime") String ime,
            @PathVariable("prezime") String prezime, HttpServletRequest request) {
        korisnikDao.deleteKorisnik(id);
        return "hello";
    }

    @RequestMapping(value = "/updatekorisnik/{id}", method = RequestMethod.GET)
    public ModelAndView updateKorisnik(@PathVariable("id") int id, HttpServletRequest request, ModelAndView model) {
        Korisnik korisnik = korisnikDao.getById(id);
        model.addObject("korisnik", korisnik);
        model.setViewName("updatekorisnik");
        return model;
    }

    @RequestMapping(value = "/updatekorisnik/{id}", method = RequestMethod.POST)
    public ModelAndView updateKorisnik(@ModelAttribute("korisnik") Korisnik k, ModelAndView model) {
        model.addObject("object", k);
        model.setViewName("hello");
        korisnikDao.updateKorisnik(k);
        return model;
    }

    @RequestMapping(value = "/addtermin", method = RequestMethod.GET)
    public String addTermin(Model model) {
        model.addAttribute("termin", new Termin());
        List<Ordinacija> ordinacije = ordinacijaDao.getAllOrdinacije();

        model.addAttribute("ordinacije", ordinacije);
        return "pregled";
    }

    @RequestMapping(value = "/addtermin", method = RequestMethod.POST)
    public ModelAndView addTermin(@ModelAttribute("termin") Termin term, ModelAndView model) {
        model.addObject("object", term);
        
        term.setId_termin(terminDao.getNextId());//
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        
        int idUser = korisnikDao.getIDByUsername(name);

        term.setId_korisnik(idUser);
        
        terminDao.addTermin(term);
        
        model.setViewName("hello");
        return model;
    }
    /*  
     @RequestMapping(value = "/deletetermin/{id}", method = RequestMethod.GET)
     public String deleteTermin(@PathVariable("id") int id,
     HttpServletRequest request) {
     terminDao.deleteTermin(id);
     return "hello";
     }
    
     @RequestMapping(value = "/updatetermin/{id}", method = RequestMethod.GET)
     public ModelAndView updateTermin(@PathVariable("id") int id, HttpServletRequest request, ModelAndView model) {
     Termin termin = terminDao.getById(id);
     model.addObject("usluga", termin);
     model.setViewName("updatetermin");
     return model;
     }
    
     @RequestMapping(value = "/updatetermin/{id}", method = RequestMethod.POST)
     public ModelAndView updateTermin(@ModelAttribute("termin") Termin t, ModelAndView model) {
     model.addObject("object", t);
     model.setViewName("hello");
     terminDao.updateTermin(t);
     return model;
     }*/
}
