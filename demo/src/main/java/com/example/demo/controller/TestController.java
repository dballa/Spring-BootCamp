package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

	@GetMapping(value = "/api/test")
	@PreAuthorize("hasAuthority('ADMIN1')")
	public ResponseEntity<String> test() {


		return ResponseEntity.ok("Success");
	}
}
