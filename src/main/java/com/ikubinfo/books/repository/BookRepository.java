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
public class BookRepository {
	
	private EntityManager entityManager;

	public BookRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	private static final String BOOK_BY_ID = "SELECT book FROM BookEntity book where book.id =?1";

	private static final String BOOK_BY_NAME = "SELECT book FROM BookEntity book where book.name =?1 and book.active = true";
	
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
	
	public BookEntity getBookByName(String name) {
		TypedQuery<BookEntity> query = entityManager.createQuery(BOOK_BY_NAME, BookEntity.class).setParameter(1,name);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
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
