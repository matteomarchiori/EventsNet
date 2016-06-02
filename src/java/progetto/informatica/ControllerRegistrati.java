/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto.informatica;

import PO.Utente;
import CRUD.CRUD;
import hibernate.HibernateUtil;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import utili.Password;

/**
 *
 * @author matteo
 */
@Controller
public class ControllerRegistrati {
    
    private static CRUD crud;

    public ControllerRegistrati() {
        crud = new CRUD(HibernateUtil.getSessionFactory());
    }
    
    @RequestMapping(value="/loginForm", method = RequestMethod.GET)
    public String loginForm(ModelMap map, @RequestParam(value="form") String form){
        if(form.equals("login")){
            map.put("form", "login");
        }
        else{
            map.put("form", "register");
        }
        return "login";
    }
    
    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(@RequestParam(value="nick") String nick, @RequestParam(value="password") String password,HttpSession session){
       Utente u = crud.selectUtente(nick);
       if (u!=null){
           try {
               String hash = Password.getMD5(password);
               if(u.getPassword().equals(hash)) {
                   session.setAttribute("nick", nick);
                   session.setAttribute("password", password);
                   return "index";
               }
               return "login";
           } catch (NoSuchAlgorithmException ex) {
               Logger.getLogger(ControllerRegistrati.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       return "login";  
    }
    
    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "index";  
    }
}
