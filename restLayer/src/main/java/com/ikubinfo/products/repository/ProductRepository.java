package com.ikubinfo.products.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ikubinfo.products.entity.ProductEntity;
import com.ikubinfo.products.entity.SubcategoryEntity;

@Repository
@Transactional
public class ProductRepository {
	
	private EntityManager entityManager;

	public ProductRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	private static final String PRODUCTS_BY_ID = "SELECT products FROM ProductEntity products where products.id =?1";

	private static final String PRODUCTS_BY_NAME = "SELECT products FROM ProductEntity products where products.name =?1 and products.active = true";
	
	private static final String ALL_PRODUCTS = "SELECT products FROM ProductEntity products";

	private static final String GET_ALL_PRODUCTS_BY_SUBCATEGORY = "SELECT products FROM ProductEntity products where products.subcategory_id=?1 ";

	private static final String GET_ALL_PRODUCTS_ORDERED = "SELECT products FROM ProductEntity product ORDER BY products.name";

	private static final String GET_ALL_PRODUCTS_BY_SUBCATEGORY_AND_ORDERED ="SELECT products FROM ProductEntity WHERE products.subcategory_id=?1 ORDER BY products.name" ;
	
	
	
	public List<ProductEntity> getAllProducts() {
		TypedQuery<ProductEntity> query = entityManager.createQuery(ALL_PRODUCTS, ProductEntity.class);
		return query.getResultList();
	}
	
	
	public ProductEntity getProductById(int id) {
		TypedQuery<ProductEntity> query = entityManager.createQuery(PRODUCTS_BY_ID, ProductEntity.class).setParameter(1,id);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public ProductEntity getProductByName(String name) {
		TypedQuery<ProductEntity> query = entityManager.createQuery(PRODUCTS_BY_NAME, ProductEntity.class).setParameter(1,name);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public void addProduct(ProductEntity products) {
		entityManager.persist(products);
	}

	public void updateProduct(ProductEntity products) {
		entityManager.merge(products);
	}

	public void deleteProduct(ProductEntity products) {
		entityManager.remove(products);
	}
	public List<ProductEntity> getFilterBySubcategory(SubcategoryEntity name) {
		return entityManager.createQuery(GET_ALL_PRODUCTS_BY_SUBCATEGORY, ProductEntity.class).setParameter("subcategory", name).getResultList();
	}

	public List<ProductEntity> getProductsOrderedBy() {
		return entityManager.createQuery(GET_ALL_PRODUCTS_ORDERED, ProductEntity.class).getResultList();
	}

	public List<ProductEntity> getFilteredAndOrdered(SubcategoryEntity name) {
		return entityManager.createQuery(GET_ALL_PRODUCTS_BY_SUBCATEGORY_AND_ORDERED, ProductEntity.class).setParameter("subcategory", name).getResultList();
	}

	public List<ProductEntity> getProductsSortedByFieldAndOrder(String field,String order)
	{
		String bookSortedBy;
		if(order!=null  && !order.isEmpty())
			bookSortedBy="SELECT products FROM ProductEntity products ORDER BY products."+field+" "+order.toUpperCase();
		else 
			bookSortedBy="SELECT products FROM ProductEntity products ORDER BY products."+field;
		TypedQuery<ProductEntity> query = entityManager.createQuery(bookSortedBy, ProductEntity.class);
		return query.getResultList();
	}
	

}
