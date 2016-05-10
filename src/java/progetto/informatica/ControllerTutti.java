/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto.informatica;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author matteo
 */
@Controller
public class ControllerTutti {
    /*@RequestMapping(value="/register", params = {"nick","password","nome","cognome"},method= RequestMethod.POST)
    public String registration(@RequestParam(value="nick") String nick,@RequestParam(value="password") String password, @RequestParam(value="nome") String nome, @RequestParam(value="cognome") String cognome){
        Visitatore v = new Visitatore(email,password,carta,null);
        Set<Visitatore> visitatori = new HashSet<>();
        visitatori.add(v);
        carta.setVisitatori(visitatori);
        crud.insertCarta(carta);
        crud.insertVisitatore(v); 
        return "index";
    }*/
}
