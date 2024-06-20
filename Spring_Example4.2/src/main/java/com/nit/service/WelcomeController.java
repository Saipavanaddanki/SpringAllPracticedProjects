package com.nit.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {

	@RequestMapping(value="/display")
	public  ModelAndView toDisplay() {
		ModelAndView model=new ModelAndView();
		model.setViewName("display");
		System.out.println(model.getViewName());
		model.addObject("name", "saipavan");
		return model;
	}
}
