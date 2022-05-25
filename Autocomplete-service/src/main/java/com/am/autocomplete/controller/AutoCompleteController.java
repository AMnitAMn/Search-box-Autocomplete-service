package com.am.autocomplete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.am.autocomplete.service.AutoCompleteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class AutoCompleteController {
	
	private final AutoCompleteService acs;
	@Autowired
	public AutoCompleteController(AutoCompleteService acs) {
		this.acs = acs;
	}
	
	@GetMapping("/search")
	public List<String> doAutoComplete(@RequestParam("q") final String input){

		// If the query input contains non alphabetic characters, return null.\
		if(input==null || !input.matches("[a-zA-Z]+"))
			return null;
		
		
		List<String> suggestions = acs.doAutoComplete(input);
		return suggestions;
	}
	
}
