/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.prvidomaci;

/**
 *
 * @author Jovana BGD
 */
import com.it355.model.Pregled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PrviController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("porukica", "Jovana je uradila na vreme svoj prvi domaci zadatak!");
        return "pozic";
    }
    @RequestMapping(value = "/pregled", method
            = RequestMethod.GET)
    public String pregled(ModelMap map) {
        map.addAttribute("pregled", new Pregled());
        return "pregled";
    }

    @RequestMapping(value = "/addPregled", method
            = RequestMethod.POST)
    public String addStudent(@ModelAttribute Pregled pregled,
            ModelMap model) {
        model.addAttribute("ime", pregled.getImeIPrezime());
        model.addAttribute("jmbg", pregled.getJmbg());
        model.addAttribute("email", pregled.getEmail());
        model.addAttribute("telefon", pregled.getTelefon());
        model.addAttribute("datum", pregled.getDatum());
        model.addAttribute("vreme", pregled.getVreme());
        model.addAttribute("opis", pregled.getOpis());
        return "prikaz";
    }
}
