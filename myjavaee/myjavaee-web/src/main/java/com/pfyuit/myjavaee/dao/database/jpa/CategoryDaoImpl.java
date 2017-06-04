package com.pfyuit.myjavaee.dao.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.database.jpa.CategoryModel;

/**
 * Category dao implement for JPA.
 * @author yupengfei
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(CategoryModel model) {
		entityManager.persist(model);
	}

	@Override
	public void delete(CategoryModel model) {
		entityManager.remove(model);
	}

	@Override
	public void update(CategoryModel model) {
		entityManager.merge(model);
	}

	@Override
	public CategoryModel findById(int categoryId) {
		return entityManager.find(CategoryModel.class, categoryId);
	}

	@Override
	public CategoryModel findByIdByNamedQuery(int categoryId) {
		TypedQuery<CategoryModel> query = entityManager.createNamedQuery("cfindById", CategoryModel.class);
		query.setParameter("categoryId", categoryId);
		return query.getSingleResult();
	}

	@Override
	public CategoryModel findByIdByNativeQuery(int categoryId) {
		Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM category WHERE category_id=:categoryId", CategoryModel.class);
		nativeQuery.setParameter("categoryId", categoryId);
		return (CategoryModel) nativeQuery.getResultList().get(0);
	}

	@Override
	public List<CategoryModel> findAll() {
		Query query = entityManager.createQuery("SELECT p FROM CategoryModel p");
		return query.getResultList();
	}

	@Override
	public List<CategoryModel> findAllByNamedQuery() {
		TypedQuery<CategoryModel> query = entityManager.createNamedQuery("cfindAll", CategoryModel.class);
		return query.getResultList();
	}

}
