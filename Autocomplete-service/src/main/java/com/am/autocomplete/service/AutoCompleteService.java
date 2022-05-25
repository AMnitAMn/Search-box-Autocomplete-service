package com.am.autocomplete.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.am.autocomplete.dao.AutoCompleteDao;

@Service
public class AutoCompleteService {
	public List<String> doAutoComplete(String prefix){
		return AutoCompleteDao.getSuggestions(prefix);
	}
}
