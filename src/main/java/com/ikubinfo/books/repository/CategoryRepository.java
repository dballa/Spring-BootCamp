package com.ikubinfo.books.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ikubinfo.books.entity.CategoryEntity;

@Repository
@Transactional
public class CategoryRepository {
	
	private EntityManager entityManager;

	public CategoryRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	private static final String CATEGORY_BY_ID = "SELECT category FROM CategoryEntity category WHERE category.id =?1 AND category.active=true";

	private static final String CATEGORY_BY_NAME = "SELECT category FROM CategoryEntity category where category.name =?1 and category.active = true";
	
	private static final String ALL_CATEGORIES_FETCHED = "SELECT category FROM CategoryEntity category";
	

	public List<CategoryEntity> getAllCategories() {
		TypedQuery<CategoryEntity> query = entityManager.createQuery(ALL_CATEGORIES_FETCHED, CategoryEntity.class);
		return query.getResultList();
	}
	
	public CategoryEntity getCategoryById(int id) {
		TypedQuery<CategoryEntity> query = entityManager.createQuery(CATEGORY_BY_ID, CategoryEntity.class).setParameter(1,id);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public CategoryEntity getCategoryByName(String name) {
		TypedQuery<CategoryEntity> query = entityManager.createQuery(CATEGORY_BY_NAME, CategoryEntity.class).setParameter(1,name);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public void addCategory(CategoryEntity category) {
		entityManager.persist(category);
	}

	public void updateCategory(CategoryEntity category) {
		entityManager.merge(category);
	}

	public void softDeleteCategory(CategoryEntity category) {
		category.setActive(Boolean.FALSE);
		updateCategory(category);
	}

	public void hardDeleteCategory(CategoryEntity category) {
		entityManager.remove(category);
	}


}
