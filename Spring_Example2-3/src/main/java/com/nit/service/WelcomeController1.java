package com.nit.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController1 {

	@RequestMapping(path="/display")
	public ModelAndView display() {
		ModelAndView model=new ModelAndView();
		model.setViewName("Display");
		model.addObject("message", "successfully to do your job");
		return model;
	}
}
