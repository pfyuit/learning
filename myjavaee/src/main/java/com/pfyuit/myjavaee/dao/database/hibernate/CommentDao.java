package com.pfyuit.myjavaee.dao.database.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.hibernate.CommentModel;

/**
 * Comment dao interface for hibernate.
 * @author yupengfei
 */
public interface CommentDao {

	public void saveWithSession(CommentModel model);

	public void deleteWithSession(CommentModel model);

	public void deleteWithHQLQuery(int commentId);

	public void deleteWithSQLQuery(int commentId);

	public void updateWithSession(CommentModel model);

	public void updateWithHQLQuery(int commentId);

	public void updateWithSQLQuery(int commentId);

	public CommentModel findByIdWithSession(int commentId);

	public CommentModel findByIdWithHQLQuery(int commentId);

	public CommentModel findByIdWithSQLQuery(int commentId);

	public CommentModel findByIdWithCriteria(int commentId);

	public List<CommentModel> findByAllWithHQLQuery();

	public List<CommentModel> findByAllWithSQLQuery();

	public List<CommentModel> findByAllWithCriteria();

}