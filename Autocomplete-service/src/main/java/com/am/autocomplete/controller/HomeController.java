package com.am.autocomplete.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// Set mapping for home page. To view the web page use url localhost:8080
	@RequestMapping("/")
	public String home() {
		return "html/home.html";
	}

	// Set mapping for JavaScript file
	@RequestMapping("/js")
	public String js() {
		return "javascript/Script.js";
	}

	// Set mapping for CSS file
	@RequestMapping("/css")
	public String css() {
		return "css/Style.css";
	}
}
