package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.dto.QuoteDto;
import com.book.service.QuotesService;

@RestController
public class QuotesController {
	@Autowired
	QuotesService quoteService;
	
	@GetMapping("/quote")
	public QuoteDto randomQuote() {
		return quoteService.getRandomQuote();
	}
	
	
}
