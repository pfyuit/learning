package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.UserModel;

/**
 * Link Dao interface for Hibernate.
 * @author yupengfei
 */
public interface UserDao {

	public abstract void save(UserModel model);

	public abstract void delete(UserModel model);

	public abstract void update(UserModel model);

	public abstract UserModel findById(int userId);

	public abstract List<UserModel> findAll();

}