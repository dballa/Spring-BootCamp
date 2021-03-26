package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.book.Entity.BookEntity;
import com.book.Entity.PublisherEntity;
import com.book.converter.BookConverter;
import com.book.dto.BookDtoForCreate;
import com.book.exception.BookException;
import com.book.repository.BookRepository;
import com.book.repository.PublisherRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@Value("${rateForPublisher}")
	private int rateForPublisher;
	
	@Value("${rateAllowedToDelete}")
	private int rateAllowedToDelete;
	
	public BookEntity addBook(BookDtoForCreate book) {
		if (book != null) {
			if (book.getName() != null) {
				if (book.getPrice() != 0) {
					if ((book.getRate()) > rateForPublisher) {
						PublisherEntity publisherFound = publisherRepository.getPublisherById(book.getPublisher());
						
						BookEntity bookToAdd = BookConverter.toEntityForCreate(book, publisherFound);

						bookRepository.addBook(bookToAdd);
						return bookToAdd;
					} else {
						System.out.println("Publisher not allowed because minimal rate is " + rateForPublisher
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
	
	public void deleteBook(long id) {
		BookEntity book = bookRepository.getBookById(id);
		if (book != null) {
			if (book.getPublisher() == null) {
				if (book.getRate() > rateAllowedToDelete) {
					bookRepository.deleteBook(book);

				} else {
					System.out.println("Could not delete book, rate allowed to delete id " + rateAllowedToDelete
							+ " but book rate id " + book.getRate());
					throw new BookException(id);
				}

				} else {
					System.out.println("Book not found");
					throw new BookException(id);
				}
			}
	}
}
