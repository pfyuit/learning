package com.pfyuit.myjavaee.dao.database.rdbms.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

	@Override
	public void save(BlogModel model) {
		entityManager.persist(model);
	}

	@Override
	public void delete(BlogModel model) {
		entityManager.remove(model);
	}

	@Override
	public void update(BlogModel model) {
		entityManager.merge(model);
	}

	@Override
	public BlogModel findById(int blogId) {
		BlogModel result = entityManager.find(BlogModel.class, blogId);
		return result;
	}

	@Override
	public BlogModel findByIdByNamedQuery(int blogId) {
		BlogModel result = entityManager.createNamedQuery("findById", BlogModel.class).setParameter("blogId", blogId).getResultList().get(0);
		return result;
	}

	@Override
	public BlogModel findByIdByNativeQuery(int blogId) {
		Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM blog WHERE blog_id=:blogId", BlogModel.class);
		nativeQuery.setParameter("blogId", blogId);
		return (BlogModel)nativeQuery.getResultList().get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BlogModel> findAll() {
		Query query = entityManager.createQuery("SELECT m FROM BlogModel m");
		List<BlogModel> result = query.getResultList();
		return result;
	}

	@Override
	public List<BlogModel> findAllByNamedQuery() {
		TypedQuery<BlogModel> query = entityManager.createNamedQuery("findAll", BlogModel.class);
		return query.getResultList();
	}

}
