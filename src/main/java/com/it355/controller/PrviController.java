/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.controller;

/**
 *
 * @author Jovana BGD
 */
import com.it355.dao.PregledDao;
import com.it355.model.Pregled;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrviController {
    /*
     @Autowired
     private MessageSource messageSource;*/

    @Autowired
    private PregledDao pregledDao;
    /*
     @RequestMapping(value = "/pregled", method = RequestMethod.GET)
     public ModelAndView pregled() {
     System.out.println("Pozivam message source");
     pregledDao.addPregled();
     System.out.println(messageSource.getMessage("name", null, Locale.ENGLISH));
     return new ModelAndView("pregled", "command", new Pregled());
     }*/

    @RequestMapping(value = "/pregled", method = RequestMethod.GET)
    public String pregled(ModelMap map) {
        map.addAttribute("pregled", new Pregled());
        return "pregled";
    }

    @RequestMapping(value = "/addPregled", method = RequestMethod.POST)
    public String addPregled(@ModelAttribute Pregled pregled, ModelMap model) {
        model.addAttribute("imeIPrezime", pregled.getImeIPrezime());
        model.addAttribute("jmbg", pregled.getJmbg());
        model.addAttribute("email", pregled.getEmail());
        model.addAttribute("telefon", pregled.getTelefon());
        model.addAttribute("datum", pregled.getDatum());
        model.addAttribute("vreme", pregled.getVreme());
        model.addAttribute("opis", pregled.getOpis());
        pregledDao.addPregled();
        pregledDao.addPregled();
        return "prikaz";
    }
}
