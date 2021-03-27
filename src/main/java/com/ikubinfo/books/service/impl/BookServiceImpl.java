package com.ikubinfo.books.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ikubinfo.books.converter.BookConverter;
import com.ikubinfo.books.dto.BookDto;
import com.ikubinfo.books.dto.BookDtoForCreate;
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
	
	public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository) {
		super();
		this.bookRepository = bookRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<BookEntity> getAllBooks() {
		
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
			if(book.getIsbn()!=null) {
				if (book.getTitle() != null) {
					if (book.getDescription() != null) {
						if (book.getEdition() > 0 ) {
							if(book.getNumberOfPages()>0){
								if(book.getPublisher() != null) {
									CategoryEntity categoryFound = categoryRepository.getCategoryById(book.getCategory());
									if(categoryFound != null){
										BookEntity bookToAdd = BookConverter.toEntityForCreate(book, categoryFound);
										bookRepository.addBook(bookToAdd);
										return bookToAdd;
									}else {
										throw new CostumBookException("Category is mandatory");
									}

								}else {
									throw new CostumBookException("Publisher is mandatory");
								}
							}else {
								throw new CostumBookException("Number of pages must be greater than 0");
							}
						} else {
							throw new CostumBookException("Edition is mandatory");
						}
					} else {
						throw new CostumBookException("Description is mandatory");
	
					}
				} else {
					throw new CostumBookException("Title is mandatory");
				}
			}else {
				throw new CostumBookException("Isbn is mandatory");
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
				if(book.getIsbn()!=null) {
					if (book.getTitle() != null) {
						if (book.getDescription() != null) {
							if (book.getEdition() > 0 ) {
								if(book.getNumberOfPages()>0){
									if(book.getPublisher() != null) {
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
									}else {
										throw new CostumBookException("Publisher is mandatory");
									}
								}else {
									throw new CostumBookException("Number of pages must be greater than 0");
								}
							} else {
								throw new CostumBookException("Edition is mandatory");
							}
						} else {
							throw new CostumBookException("Description is mandatory");
		
						}
					} else {
						throw new CostumBookException("Title is mandatory");
					}
				}else {
					throw new CostumBookException("Isbn is mandatory");
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


}
