package com.pfyuit.myjavaee.dao.database.rdbms.jpa;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.jpa.CommentModel;

/**
 * Comment Dao interface for JPA.
 * @author yupengfei
 */
public interface CommentDao {

	public void save(CommentModel model);

	public void delete(CommentModel model);

	public void update(CommentModel model);

	public CommentModel findById(int commentId);

	public CommentModel findByIdByNamedQuery(int commentId);

	public CommentModel findByIdByNativeQuery(int commentId);

	public List<CommentModel> findAll();

	public List<CommentModel> findAllByNamedQuery();

}