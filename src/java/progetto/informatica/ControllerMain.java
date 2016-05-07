/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto.informatica;

import CRUD.CRUD;
import hibernate.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author matteo
 */
@Controller
public class ControllerMain {
    
    private static CRUD crud = new CRUD(HibernateUtil.getSessionFactory());
    
    public ControllerMain(){
    }
    
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(){
        return "index";
    }
    
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login(){
        return "login";
    }
    
}//MainController
