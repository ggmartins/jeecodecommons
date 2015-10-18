package com.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 

@Controller
@RequestMapping("/")
public class MainController {
	
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("message", "hello Spring 4 MVC (/)");
        return "view1";
    }
 
    @RequestMapping(value="/webapp", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("message", "hello Spring 4 MVC (webapp)");
        return "view2";
    }

    @RequestMapping(value="/fileupload", method = RequestMethod.GET)
    public String fileUpload(ModelMap model) {
        model.addAttribute("message", "hello Spring 4 MVC (File Upload)");
        return "fileupload";
    }
    
}