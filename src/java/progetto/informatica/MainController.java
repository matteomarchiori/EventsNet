/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto.informatica;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author matteo
 */
@Controller
public class MainController {
    
    public MainController(){
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
