package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.book.service.BookService;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
//		new BookService().testTransaction();
		SpringApplication.run(BookApplication.class, args);
	}

}
