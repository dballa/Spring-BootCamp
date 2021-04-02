package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.converter.BookConverter;
import com.book.dto.BookDto;
import com.book.dto.BookDtoForCreate;
import com.book.entity.BookEntity;
import com.book.exception.BookException;
import com.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/book")
	public List<BookEntity> getAll(@RequestParam(required=false) String name, @RequestParam(required=false) Integer rate, @RequestParam(required=false) String sort){
		
		if(name != null && rate != null) {
			return bookService.getAllBooks();
		}
		
		if(name != null) {
			return bookService.searchBooksByName(name);
		}
		
		if(rate != null) {
			return bookService.searchBooksByRate(rate);
		}
		
		if(sort != null) {
			return bookService.getAllBooksSortByPrice(sort);
		}
		
		return bookService.getAllBooks();
	}
	
	@GetMapping("/book/{id}")
	public BookEntity getById(@PathVariable long id) {
		BookEntity entity = bookService.getBookById(id);
		return entity;
	}
	
	@DeleteMapping("/book/{id}")
	public BookEntity deleteBook(@PathVariable long id) {
		return bookService.deleteBook(id);
	}

	@PostMapping("/book")
	public BookDto addBook(@RequestBody BookDtoForCreate book) {
		BookEntity bookEntity = bookService.addBook(book);
		return BookConverter.toDto(bookEntity);
	}

}
