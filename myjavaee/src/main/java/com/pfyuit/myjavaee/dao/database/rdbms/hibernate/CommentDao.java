package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.CommentModel;

/**
 * Comment Dao interface for Hibernate.
 * @author yupengfei
 */
public interface CommentDao {

	public abstract void save(CommentModel model);

	public abstract void delete(CommentModel model);

	public abstract void update(CommentModel model);

	public abstract CommentModel findById(int commentId);

	public abstract List<CommentModel> findAll();

}