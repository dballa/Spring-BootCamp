package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.converter.BookConverter;
import com.book.dto.BookDto;
import com.book.dto.BookDtoForCreate;
import com.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookSevice;

	@DeleteMapping("/deleteBook/{id}")
	public void deleteBook(@PathVariable long id) {
		bookSevice.deleteBook(id);

	}

	@PostMapping("/addBook")
	public BookDto addBook(@RequestBody BookDtoForCreate book) {
		return BookConverter.toDto(bookSevice.addBook(book));
	}

}
