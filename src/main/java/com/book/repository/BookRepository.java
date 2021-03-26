package com.book.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.book.Entity.BookEntity;

import java.util.List;

@Repository
public class BookRepository {
    private EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    private static final String BOOK_BY_ID ="select book from BookEntity where book.book_id=?1";

    public List<BookEntity>getAllBooks() {
        TypedQuery<BookEntity> query = entityManager.createQuery("Book.findAll", BookEntity.class);
        return query.getResultList();
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
    public void updateBook(BookEntity book){
        entityManager.merge(book);
    }
    public void deleteBook(BookEntity book){
        entityManager.remove(book);
    }
}


