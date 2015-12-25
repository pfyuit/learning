package com.pfyuit.myjavaee.dao.database.rdbms.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.database.rdbms.jpa.LinkModel;
import com.pfyuit.myjavaee.model.database.rdbms.jpa.UserModel;

/**
 * User Dao implement for JPA.
 * @author yupengfei
 */
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(UserModel model) {
		entityManager.persist(model);
	}

	@Override
	public void delete(UserModel model) {
		entityManager.remove(model);
	}

	@Override
	public void update(UserModel model) {
		entityManager.merge(model);
	}

	@Override
	public UserModel findById(int userId) {
		return entityManager.find(UserModel.class, userId);
	}

	@Override
	public UserModel findByIdByNamedQuery(int userId) {
		TypedQuery<UserModel> query = entityManager.createNamedQuery("ufindById", UserModel.class);
		query.setParameter("userId", userId);
		return query.getSingleResult();
	}

	@Override
	public UserModel findByIdByNativeQuery(int userId) {
		Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM user WHERE user_id=:userId", UserModel.class);
		nativeQuery.setParameter("userId", userId);
		return (UserModel) nativeQuery.getResultList().get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserModel> findAll() {
		Query query = entityManager.createQuery("SELECT p FROM UserModel p");
		return query.getResultList();
	}

	@Override
	public List<UserModel> findAllByNamedQuery() {
		TypedQuery<UserModel> query = entityManager.createNamedQuery("ufindAll", UserModel.class);
		return query.getResultList();
	}

}
