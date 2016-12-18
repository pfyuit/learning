package com.pfyuit.myjavaee.dao.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.database.jpa.CommentModel;
import com.pfyuit.myjavaee.model.database.jpa.LinkModel;

/**
 * Link dao implement for JPA.
 * @author yupengfei
 */
@Repository
public class LinkDaoImpl implements LinkDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(LinkModel model) {
		entityManager.persist(model);
	}

	@Override
	public void delete(LinkModel model) {
		entityManager.remove(model);
	}

	@Override
	public void update(LinkModel model) {
		entityManager.merge(model);
	}

	@Override
	public LinkModel findById(int linkId) {
		return entityManager.find(LinkModel.class, linkId);
	}

	@Override
	public LinkModel findByIdByNamedQuery(int linkId) {
		TypedQuery<LinkModel> query = entityManager.createNamedQuery("lfindById", LinkModel.class);
		query.setParameter("linkId", linkId);
		return query.getSingleResult();
	}

	@Override
	public LinkModel findByIdByNativeQuery(int linkId) {
		Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM link WHERE link_id=:linkId", LinkModel.class);
		nativeQuery.setParameter("linkId", linkId);
		return (LinkModel) nativeQuery.getResultList().get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<LinkModel> findAll() {
		Query query = entityManager.createQuery("SELECT p FROM LinkModel p");
		return query.getResultList();
	}

	@Override
	public List<LinkModel> findAllByNamedQuery() {
		TypedQuery<LinkModel> query = entityManager.createNamedQuery("lfindAll", LinkModel.class);
		return query.getResultList();
	}

}
