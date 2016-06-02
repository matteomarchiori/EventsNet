/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto.informatica;

import CRUD.CRUD;
import PO.Utente;
import hibernate.HibernateUtil;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import utili.Password;

/**
 *
 * @author matteo
 */
@Controller
public class ControllerTutti {
    
    private static CRUD crud;

    public ControllerTutti() {
        crud = new CRUD(HibernateUtil.getSessionFactory());
    }
    
    @RequestMapping(value="/register",method= RequestMethod.POST)
    public String registration(HttpSession session, @RequestParam(value="nick") String nick,@RequestParam(value="password") String password, @RequestParam(value="nome") String nome, @RequestParam(value="cognome") String cognome){
        try {
            String hash = Password.getMD5(password);
            Utente u = new Utente(nick,nome,cognome,hash);
            crud.insertUtente(u);
            session.setAttribute("nick", nick);
            session.setAttribute("password", hash);
            return "index";
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ControllerTutti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }
}
