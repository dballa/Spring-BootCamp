package com.ikubinfo.books.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.books.converter.BookConverter;
import com.ikubinfo.books.dto.BookDto;
import com.ikubinfo.books.dto.BookDtoForCreate;
import com.ikubinfo.books.entity.BookEntity;
import com.ikubinfo.books.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/addBook")
	public BookDto addBook(@RequestBody BookDtoForCreate book) {
		
		return BookConverter.toDto(bookService.addBook(book));
	}
	@PutMapping("/updateBook")
	public BookDto updateBook(@RequestBody BookDto book) {
		return BookConverter.toDto(bookService.updateBook(book));
	}
	@DeleteMapping("deleteBook")
	public void deleteUser(@RequestBody BookDto book) {

		bookService.hardDeleteBook(book);
	}
	@GetMapping("/findBook/{id}")
	public BookDto getBookById(@PathVariable int id) {

		return BookConverter.toDto(bookService. getBookById(id));
	}
	@GetMapping("/allBooks")
	public List<BookDto> getAllBooks(){
		
		List<BookDto> books = new ArrayList<>(); 
		for(BookEntity book : bookService. getAllBooks()) {
			books.add(BookConverter.toDto(book));
		}
		return books;
	}
}
