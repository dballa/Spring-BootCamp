package com.ikubinfo.books.service;

import java.util.List;

import com.ikubinfo.books.dto.BookDto;
import com.ikubinfo.books.dto.BookDtoForCreate;
import com.ikubinfo.books.entity.BookEntity;

public interface BookService {
	
	public List<BookEntity> getAllBooks();
	
	public BookEntity getBookById(int id);
	
	public BookEntity addBook(BookDtoForCreate book);
	
	public BookEntity updateBook(BookDto book);
	
	public void hardDeleteBook(BookDto book);

}
