/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.controller;

import com.it355.dao.KorisnikDao;
import com.it355.dao.UslugaDao;
import com.it355.model.Korisnik;
import com.it355.model.Usluga;
import com.it355.service.KorisnikService;
import com.it355.service.UslugaService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
    UslugaService uslugaService;

    @Autowired
    KorisnikService korisnikService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Ovo je strana kojoj svi moguda pristupe!");
        model.setViewName("hello");
        return model;
    }

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Ovo je strana kojoj svi mogu da pristupe!");
        model.setViewName("hello");
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

    @RequestMapping(value = "/addusluga", method = RequestMethod.GET)
    public String addUsluga(Model model) {
        model.addAttribute("usluga", new Usluga());
        return "addusluga";
    }

    @RequestMapping(value = "/addusluga", method = RequestMethod.POST)
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

}
