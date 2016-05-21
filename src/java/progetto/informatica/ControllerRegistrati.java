/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto.informatica;

import CRUD.CRUD;
import hibernate.HibernateUtil;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import PO.*;

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
    
    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(@RequestParam(value="nick") String nick, @RequestParam(value="password") String password,HttpSession session){
       Utente u = crud.selectUtente(nick);
       if (u!=null){
           if(u.getPassword().equals(password)) {
               session.setAttribute("nick", nick);
               session.setAttribute("password", password);
               return "/";
           }
           return "register";
       }
       return "register";  
    }
    
    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public String logout(HttpSession session,ModelMap map){
        session.invalidate();
        return "index";  
    }
}
