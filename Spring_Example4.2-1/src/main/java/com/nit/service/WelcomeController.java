package com.nit.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WelcomeController {

	@RequestMapping(path="/display")
	public ModelAndView display() {
		ModelAndView model=new ModelAndView();
		model.setViewName("d1");
		model.addObject("name", "sai");
		return model;
	}
}
