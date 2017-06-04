package com.pfyuit.myjavaee.dao.database.jpa;

import java.util.List;

import com.pfyuit.myjavaee.model.database.jpa.UserModel;

/**
 * Link dao interface for JPA.
 * @author yupengfei
 */
public interface UserDao {

	public void save(UserModel model);

	public void delete(UserModel model);

	public void update(UserModel model);

	public UserModel findById(int userId);

	public UserModel findByIdByNamedQuery(int userId);

	public UserModel findByIdByNativeQuery(int userId);

	public List<UserModel> findAll();

	public List<UserModel> findAllByNamedQuery();

}