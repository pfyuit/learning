package com.pfyuit.myjavaee.dao.database.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.hibernate.UserModel;

/**
 * Link dao interface for hibernate.
 * @author yupengfei
 */
public interface UserDao {

	public void saveWithSession(UserModel model);

	public void deleteWithSession(UserModel model);

	public void deleteWithHQLQuery(int userId);

	public void deleteWithSQLQuery(int userId);

	public void updateWithSession(UserModel model);

	public void updateWithHQLQuery(int userId);

	public void updateWithSQLQuery(int userId);

	public UserModel findByIdWithSession(int userId);

	public UserModel findByIdWithHQLQuery(int userId);

	public UserModel findByIdWithSQLQuery(int userId);

	public UserModel findByIdWithCriteria(int userId);

	public List<UserModel> findByAllWithHQLQuery();

	public List<UserModel> findByAllWithSQLQuery();

	public List<UserModel> findByAllWithCriteria();

}