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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public String event() {
        return "event";
    }
    
    @RequestMapping(value = "/list_events", method = RequestMethod.GET)
    public String list_events() {
        return "list_events";
    }
    
    @RequestMapping(value = "/add_event", method = RequestMethod.GET)
    public String add_event() {
        return "add_event";
    }

}//MainController