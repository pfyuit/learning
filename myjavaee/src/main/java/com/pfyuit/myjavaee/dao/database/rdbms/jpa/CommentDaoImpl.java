package com.pfyuit.myjavaee.dao.database.rdbms.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.database.rdbms.jpa.CommentModel;

/**
 * Comment Dao implement for JPA.
 * @author yupengfei
 */
@Repository
public class CommentDaoImpl implements CommentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(CommentModel model) {
		entityManager.persist(model);
	}

	@Override
	public void delete(CommentModel model) {
		entityManager.remove(model);
	}

	@Override
	public void update(CommentModel model) {
		entityManager.merge(model);
	}

	@Override
	public CommentModel findById(int commentId) {
		return entityManager.find(CommentModel.class, commentId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CommentModel> findAll() {
		Query query = entityManager.createQuery("SELECT p FROM CommentModel p");
		return query.getResultList();
	}

	@Override
	public CommentModel findByIdByNamedQuery(int commentId) {
		TypedQuery<CommentModel> query = entityManager.createNamedQuery("cofindById", CommentModel.class);
		query.setParameter("commentId", commentId);
		return query.getSingleResult();
	}

	@Override
	public CommentModel findByIdByNativeQuery(int commentId) {
		Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM comment WHERE comment_id=:commentId", CommentModel.class);
		nativeQuery.setParameter("commentId", commentId);
		return (CommentModel) nativeQuery.getResultList().get(0);
	}

	@Override
	public List<CommentModel> findAllByNamedQuery() {
		Query query = entityManager.createNamedQuery("cofindAll", CommentModel.class);
		return query.getResultList();
	}

}
