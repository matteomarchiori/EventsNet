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
 * @author chnedev
 */
@Controller
public class ControllerMain {

    //private static CRUD crud = new CRUD();

    @RequestMapping(value = {"/"})
    public String index(ModelMap m) {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap m) {
        return "login";
    }
    
    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public String event() {
        return "event";
    }

}//MainController