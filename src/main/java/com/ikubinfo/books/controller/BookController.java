package com.ikubinfo.books.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.books.converter.BookConverter;
import com.ikubinfo.books.dto.BookDto;
import com.ikubinfo.books.dto.BookDtoForCreate;
import com.ikubinfo.books.dto.ExternalApi;
import com.ikubinfo.books.entity.BookEntity;
import com.ikubinfo.books.service.BookService;

import io.swagger.annotations.ApiOperation;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@ApiOperation(value="Add a new book")
	@PostMapping("/books")
	public ResponseEntity<BookDto> addBook(@RequestBody BookDtoForCreate book) {
		
		return new ResponseEntity<>(BookConverter.toDto(bookService.addBook(book)),HttpStatus.CREATED);
	}
	@ApiOperation(value="Update an existing book")
	@PutMapping("/books")
	public ResponseEntity<BookDto> updateBook(@RequestBody BookDto book) {
		return new ResponseEntity<>(BookConverter.toDto(bookService.updateBook(book)),HttpStatus.OK);
	}
	@ApiOperation(value="Delete an existing book")
	@DeleteMapping("books/{id}")
	public void deleteUser(@RequestBody BookDto book) {

		bookService.hardDeleteBook(book);
	}
	@ApiOperation(value="Get an existing book")
	@GetMapping("/books/{id}")
	public ResponseEntity<BookDto> getBookById(@PathVariable int id) {

		return new ResponseEntity<>(BookConverter.toDto(bookService. getBookById(id)),HttpStatus.OK);
	}
	@ApiOperation(value="Get all books filter by isbn")
	@GetMapping("/books")
	public ResponseEntity<List<BookDto>> getFilteredBooks(@RequestParam(required=false) String publisher, @RequestParam(required=false) String sortBy, @RequestParam(required=false) String order){
		
		List<BookDto> books = new ArrayList<>(); 
		for(BookEntity book : bookService. getBooks(publisher,sortBy,order)) {
			books.add(BookConverter.toDto(book));
		}
		return new ResponseEntity<>(books,HttpStatus.OK);
	}
	@GetMapping("/testRestTemplate")
	public ResponseEntity<ExternalApi> testRest(){
		return new ResponseEntity<>(bookService.testRest(),HttpStatus.OK);
	}
}
