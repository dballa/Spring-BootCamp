package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.book.converter.BookConverter;
import com.book.dto.BookDto;
import com.book.dto.BookDtoForCreate;
import com.book.dto.BookDtoForUpdate;
import com.book.entity.BookEntity;
import com.book.entity.PublisherEntity;
import com.book.exception.BookException;
import com.book.exception.PublisherException;
import com.book.repository.BookRepository;
import com.book.repository.PublisherRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@Value("${rateForBook}")
	private int rateForBook;
	
	@Value("${rateAllowedToDelete}")
	private int rateAllowedToDelete;
	
	public BookEntity addBook(BookDtoForCreate book) {
		if (book != null) {
			if (book.getName() != null) {
				if (book.getPrice() != 0) {
					if ((book.getRate()) > rateForBook) {
						PublisherEntity publisherFound = publisherRepository.getPublisherById(book.getPublisher_id());
						
						if(publisherFound != null) {
							BookEntity bookToAdd = BookConverter.toEntityForCreate(book, publisherFound);

							bookRepository.addBook(bookToAdd);
							return bookToAdd;
						}
					} else {
						System.out.println("Book not allowed because minimal rate is " + rateForBook
								+ " but book to add rate is " + book.getRate());
						throw new BookException("Could not publish book");
					}
				} else {
					System.out.println("Book price is mandatory");
					throw new BookException("Price is required");

				}
			} else {
				System.out.println("Book name is mandatory");
				throw new BookException("Name is required");
			}
		}
		return null;
	}
	
	public BookEntity deleteBook(long id) {
		BookEntity book = bookRepository.getBookById(id);
		if (book != null) {
			if (book.getRate() > rateAllowedToDelete) {
				bookRepository.deleteBook(book);
				// if success return old book
				return book;
			} else {
				System.out.println("Could not delete book, rate allowed to delete book is " + rateAllowedToDelete
						+ " but book rate is " + book.getRate());
				throw new BookException(id);
			}
		}
		else {
			System.out.println("Book not found");
			throw new BookException("Book with id: " + id + " does not exist");
		}
	}
	
	public BookDto updateBook(long id, BookDtoForUpdate book) {
		BookEntity bookFromDb = bookRepository.getBookById(id);
		if (bookFromDb != null) {
			BookEntity updateBookEntity = BookConverter.toEntityForUpdate(book);
			updateBookEntity.setId(id);
			BookEntity response = bookRepository.updateBook(updateBookEntity);
			
			return BookConverter.toDto(response);
		} else {
			System.out.println("Book not found");
			throw new BookException("Book with id: " + id + ", does not exist");
		}
	}
	
	public List<BookEntity> searchBooksByName(String name) {
		return bookRepository.searchByName(name);
	}
	
	public List<BookEntity> searchBooksByRate(int rate) {
		return bookRepository.searchByRate(rate);
	}
	
	public List<BookEntity> getAllBooks(){
		return bookRepository.getAllBooks();
	}
	
	public BookEntity getBookById(long id) {
		return bookRepository.getBookById(id);
	}
	
	public List<BookEntity> getAllBooksSortByPrice(String sort){
		if(!sort.equalsIgnoreCase("asc") && !sort.equalsIgnoreCase("desc")) {
			throw new BookException("Sort method not allowed");
		}
		
		return bookRepository.getBooksOrderedByPrice(sort);
	}
	
}
