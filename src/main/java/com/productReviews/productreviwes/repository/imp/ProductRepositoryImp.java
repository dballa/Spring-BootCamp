package com.productReviews.productreviwes.repository.imp;

import com.productReviews.productreviwes.entity.ProductEntity;
import com.productReviews.productreviwes.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@AllArgsConstructor
@Transactional
public class ProductRepositoryImp implements ProductRepository {

    private final EntityManager entityManager;

    private final String GET_ALL = "SELECT product FROM ProductEntity product LEFT JOIN product.reviews";
    private final String GET_BY_ID = "SELECT product FROM ProductEntity product LEFT JOIN product.reviews WHERE product.id = ?1";
    private final String GET_BY_NAME = "SELECT product FROM ProductEntity product WHERE product.name = ?1";


    @Override
    public void save(ProductEntity productEntity) {
        entityManager.persist(productEntity);
    }

    @Override
    public List<ProductEntity> all() {
        return entityManager.createQuery(GET_ALL, ProductEntity.class).getResultList();
    }

    @Override
    public ProductEntity getById(Long id) {
        TypedQuery<ProductEntity> query = entityManager.createQuery(GET_BY_ID, ProductEntity.class).setParameter(1, id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public ProductEntity getByName(String name) {
        TypedQuery<ProductEntity> query = entityManager.createQuery(GET_BY_NAME, ProductEntity.class).setParameter(1, name);
        try{
            return query.getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void delete(ProductEntity productEntity) {
        entityManager.remove(productEntity);
    }

    @Override
    public ProductEntity update(ProductEntity productEntity) {
         return entityManager.merge(productEntity);
    }

}
