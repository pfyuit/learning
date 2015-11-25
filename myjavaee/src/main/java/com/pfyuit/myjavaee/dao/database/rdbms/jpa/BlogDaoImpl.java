package com.pfyuit.myjavaee.dao.database.rdbms.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.database.rdbms.jpa.BlogModel;

/**
 * Blog Dao implement for JPA.
 * @author yupengfei
 */
@Repository
public class BlogDaoImpl implements BlogDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(BlogModel model) {
		entityManager.persist(model);
	}

	public void delete(BlogModel model) {
		entityManager.remove(model);
	}

	public void update(BlogModel model) {
		entityManager.merge(model);
	}

	public BlogModel findById(int blogId) {
		BlogModel result = entityManager.find(BlogModel.class, blogId);
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BlogModel> findAll() {
		Query query = entityManager.createQuery("SELECT m FROM BlogModel m");
		List<BlogModel> result = query.getResultList();
		return result;
	}
}
