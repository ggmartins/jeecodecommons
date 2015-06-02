package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	@RequestMapping("/hw")
	public ModelAndView helloWorld() {
 
		String message = "<b>This is a model message generated by HelloWorldController</b>";
		return new ModelAndView("helloworld", "message", message);
	}

}
