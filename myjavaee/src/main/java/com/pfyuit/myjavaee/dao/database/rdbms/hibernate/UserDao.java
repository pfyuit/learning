package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.UserModel;

/**
 * Link Dao interface for Hibernate.
 * @author yupengfei
 */
public interface UserDao {

	public void save(UserModel model);

	public void delete(UserModel model);

	public void update(UserModel model);

	public UserModel findById(int userId);

	public List<UserModel> findAll();

}