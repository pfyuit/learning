package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.CommentModel;

/**
 * Comment Dao interface for Hibernate.
 * @author yupengfei
 */
public interface CommentDao {

	public void save(CommentModel model);

	public void delete(CommentModel model);

	public void update(CommentModel model);

	public CommentModel findById(int commentId);

	public List<CommentModel> findAll();

}