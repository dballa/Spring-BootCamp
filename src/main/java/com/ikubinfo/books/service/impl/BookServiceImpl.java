package com.ikubinfo.books.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ikubinfo.books.converter.BookConverter;
import com.ikubinfo.books.dto.BookDto;
import com.ikubinfo.books.dto.BookDtoForCreate;
import com.ikubinfo.books.dto.ExternalApi;
import com.ikubinfo.books.entity.BookEntity;
import com.ikubinfo.books.entity.CategoryEntity;
import com.ikubinfo.books.exception.CostumBookException;
import com.ikubinfo.books.repository.BookRepository;
import com.ikubinfo.books.repository.CategoryRepository;
import com.ikubinfo.books.service.BookService;


@Service
public class BookServiceImpl implements BookService {
	
	BookRepository bookRepository;
	CategoryRepository categoryRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository) {
		super();
		this.bookRepository = bookRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<BookEntity> getBooks(String publisher,String field, String order) {
		if (publisher != null && !publisher.isEmpty())
			return bookRepository.getFilteredByPublisher(publisher);
		else if (field != null && !field.isEmpty() )
			return bookRepository.getBooksSortedByFieldAndOrder(field,order);	
		else
			return bookRepository.getAllBooks();
	}

	@Override
	public BookEntity getBookById(int id) {
		
		BookEntity existingBook= bookRepository.getBookById(id);
		if(existingBook ==  null) {
			throw new CostumBookException("Book doesn't exist!");
		}else {
			return existingBook;
		}
	}

	@Override
	public BookEntity addBook(BookDtoForCreate book) {
		if (book != null) {
			CategoryEntity categoryFound = categoryRepository.getCategoryById(book.getCategory());
			if(categoryFound != null){
				BookEntity bookToAdd = BookConverter.toEntityForCreate(book, categoryFound);
				bookRepository.addBook(bookToAdd);
				return bookToAdd;
			}else {
				throw new CostumBookException("Category is mandatory");
			}
		}
		return null;
		
	}

	@Override
	public BookEntity updateBook(BookDto book) {
		
		BookEntity existingBook= bookRepository.getBookById(book.getId());
		
		if(existingBook ==  null) {
			throw new CostumBookException("Book doesn't exist!");
		}else {
			if (book != null) {
				CategoryEntity categoryFound = categoryRepository.getCategoryById(book.getCategory().getId());
				if(categoryFound != null) {
					BookEntity bookToUpdate = BookConverter.toEntity(book);
					existingBook.setTitle(bookToUpdate.getTitle());
					existingBook.setDescription(bookToUpdate.getDescription());
					existingBook.setEdition(bookToUpdate.getEdition());
					existingBook.setIsbn(bookToUpdate.getIsbn());
					existingBook.setNumberOfPages(bookToUpdate.getNumberOfPages());
					existingBook.setPublisher(bookToUpdate.getPublisher());
					bookRepository.updateBook(existingBook);
					return existingBook;
				}else {
					throw new CostumBookException("Category is mandatory");
				}					
			}
		}
		return null;	
	}

	@Override
	public void hardDeleteBook(BookDto book) {
		
		if (bookRepository.getBookById(book.getId()) == null) {
			throw new CostumBookException("This book doesn't exists");
		} else {
			bookRepository.hardDeleteBook(BookConverter.toEntity(book));
		}
		
	}
	
	@Override
	public ExternalApi testRest() {
		
		ResponseEntity<ExternalApi> response=restTemplate.exchange("https://jsonplaceholder.typicode.com/comments/1", HttpMethod.GET,null,ExternalApi.class);

		ExternalApi a = response.getBody();

		return a;
	}


}
