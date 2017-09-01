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
import com.it355.hibernatecrud.dao.PromenaDao;
import com.it355.hibernatecrud.entity.Ordinacija;
import com.it355.hibernatecrud.entity.Usluga;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {

    @Autowired
    PromenaDao promenaDao;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/addUsluga", method = RequestMethod.GET)
    public String addUtakmica(Model model) {
        model.addAttribute("usluga", new Usluga());
        model.addAttribute("ordinacije", promenaDao.getOrdinacije());
        return "addUsluga";
    }

    @RequestMapping(value = "/editUsluga/{id}", method = RequestMethod.GET)
    public String addUtakmica(@PathVariable("id") int id, Model model) {
        Usluga usluga = promenaDao.getUslugaById(id);
        model.addAttribute("usluga", usluga);
        model.addAttribute("ordinacije", promenaDao.getOrdinacije());
        return "addUsluga";
    }

    @RequestMapping(value = "/addUsluga", method = RequestMethod.POST)
    public ModelAndView addUtakmica(@ModelAttribute("usluga") Usluga usl, ModelAndView model) {
        //   uta.setEnabled(Boolean.TRUE);   ako ne radi dodati atribut
        usl = promenaDao.addUsluga(usl);
        model.addObject("ordinacije", promenaDao.getOrdinacije());
        model.addObject("successMsg", "Usluga uspesno dodata");
        model.addObject("usluga", usl);
        return model;
    }

    @RequestMapping(value = "/addOrdinacija", method = RequestMethod.GET)
    public String addOrdinacija(Model model) {
        model.addAttribute("ordinacija", new Ordinacija());
        return "addOrdinacija";
    }

    @RequestMapping(value = "/addOrdinacija", method = RequestMethod.POST)
    public ModelAndView addOrdinacija(@ModelAttribute("ordinacija") Ordinacija ord, ModelAndView model) {
        //   klu.setEnabled(Boolean.TRUE);
        //  klu.setId_klub(10);
        System.out.println("aaa " + ord.toString());
        promenaDao.addOrdinacija(ord);
        model.addObject("successMsg", "Ordinacija uspesno dodata");
        return model;
    }

    @RequestMapping(value = "/seeusluge", method = RequestMethod.GET)
    public ModelAndView getUsluge(ModelAndView model) {
        model.addObject("usluge", promenaDao.getUsluge());
        model.addObject("usluga", new Usluga());
        return model;
    }

    @RequestMapping(value = "/deleteusluga/{id}", method = RequestMethod.GET)
    public String deleteUsluga(@PathVariable("id") int id, HttpServletRequest request) {
        System.out.println("Fetching & Deleting usluga with id " + id);
        Usluga usl = promenaDao.getUslugaById(id);
        if (usl == null) {
            System.out.println("Unable to delete. Usluga with id " + id + " not found");
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }

        promenaDao.deleteUsluga(usl);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
