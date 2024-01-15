package com.jayblog.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createPost() {
		logger.info("C : create");
		
		return "create";
	}
	@GetMapping(value = "/read/{bno}")
	public String readPost(Model model, @PathVariable(name = "bno") Integer bno) {
		logger.info("C : read " + bno + "번 글");
		model.addAttribute(bno);
		return "read";
	}
	@GetMapping(value = "/update/{bno}")
	public String updatePost(Model model, @PathVariable(name = "bno") Integer bno) {
		logger.info("C : read " + bno + "번 글");
		model.addAttribute(bno);
		return "update";
	}
	
}
