package com.ikubinfo.books.repository;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ikubinfo.books.entity.BookEntity;

@Repository
@Transactional
public class BookRepository{
	
	private EntityManager entityManager;

	public BookRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	private static final String BOOK_BY_ID = "SELECT book FROM BookEntity book where book.id =?1";

	private static final String BOOK_BY_PUBLISHER = "SELECT book FROM BookEntity book where book.publisher =?1";
	
	private static final String ALL_BOOKS = "SELECT book FROM BookEntity book";
	
	public List<BookEntity> getAllBooks() {
		TypedQuery<BookEntity> query = entityManager.createQuery(ALL_BOOKS, BookEntity.class);
		return query.getResultList();
	}
	
	public BookEntity getBookById(int id) {
		TypedQuery<BookEntity> query = entityManager.createQuery(BOOK_BY_ID, BookEntity.class).setParameter(1,id);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<BookEntity> getBooksSortedByFieldAndOrder(String field,String order)
	{
		String bookSortedBy;
		if(order!=null  && !order.isEmpty())
			bookSortedBy="SELECT book FROM BookEntity book ORDER BY book."+field+" "+order.toUpperCase();
		else 
			bookSortedBy="SELECT book FROM BookEntity book ORDER BY book."+field;
		TypedQuery<BookEntity> query = entityManager.createQuery(bookSortedBy, BookEntity.class);
		return query.getResultList();
	}
	
	public List<BookEntity> getFilteredByPublisher(String publisher){
		TypedQuery<BookEntity> query = entityManager.createQuery(BOOK_BY_PUBLISHER, BookEntity.class).setParameter(1,publisher);
		return query.getResultList();
	}
	
	public void addBook(BookEntity book) {
		entityManager.persist(book);
	}

	public void updateBook(BookEntity book) {
		entityManager.merge(book);
	}

	public void hardDeleteBook(BookEntity book) {
		entityManager.remove(book);
	}

}
