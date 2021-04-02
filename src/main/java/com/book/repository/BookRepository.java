package com.book.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.book.entity.BookEntity;

import java.util.List;

@Transactional
@Repository
public class BookRepository {
    private EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    private static final String BOOK_BY_ID ="select book from BookEntity book where book.id=?1";

    public List<BookEntity> getAllBooks() {
        TypedQuery<BookEntity> query = entityManager.createNamedQuery("Book.findAll", BookEntity.class);
        List<BookEntity> response = query.getResultList();
        System.out.println(response);
        return response;
    }
    public  BookEntity getBookById(long id){
        TypedQuery<BookEntity> query=entityManager.createQuery(BOOK_BY_ID,BookEntity.class).setParameter(1,id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            System.out.println("No results");
            return null;
        }
    }
    public void addBook(BookEntity book){
        entityManager.persist(book);
    }
    public BookEntity updateBook(BookEntity book) {
		return entityManager.merge(book);
	}
    public void deleteBook(BookEntity book){
        entityManager.remove(book);
    }
    
    public List<BookEntity> searchByName(String name) {
    	name = "%" + name + "%";
		TypedQuery<BookEntity> query = entityManager.createQuery("SELECT book from BookEntity book where book.name like ?1", BookEntity.class).setParameter(1, name);
		return query.getResultList();
	}
  
    public List<BookEntity> searchByRate(int rate) {
		TypedQuery<BookEntity> query = entityManager.createQuery("SELECT book from BookEntity book where book.rate=?1", BookEntity.class).setParameter(1, rate);
		return query.getResultList();
	}
    
    public List<BookEntity> getBooksOrderedByPrice(String sort) {
    	String query = "";
    	if(sort.equalsIgnoreCase("asc")) {
    		query = "SELECT book from BookEntity book ORDER BY book.price asc";
    	} else {
    		query = "SELECT book from BookEntity book ORDER BY book.price desc";
    	}
    	
    	
		return entityManager.createQuery(query, BookEntity.class).getResultList();
	}
}


