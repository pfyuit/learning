package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.info.database.rdbms.hibernate.BlogInfo;
import com.pfyuit.myjavaee.model.database.rdbms.hibernate.BlogModel;
import com.pfyuit.myjavaee.model.database.rdbms.hibernate.CommentModel;

/**
 * Blog Dao implement for Hibernate.
 * @author yupengfei
 */
@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	@Qualifier("sessionFactoryMyblog")
	private SessionFactory sessionFactory;

	@Override
	public void saveWithSession(BlogModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void deleteWithSession(BlogModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public void deleteWithHQLQuery(int blogId) {
		Session session = sessionFactory.getCurrentSession();

		// Delete children first.
		BlogModel model = findByIdWithSession(blogId);
		for (CommentModel comment : model.getComments()) {
			String hql = "DELETE FROM CommentModel WHERE commentId=:commentId";
			Query query = session.createQuery(hql);
			query.setParameter("commentId", comment.getCommentId());
			query.executeUpdate();
		}

		String hql = "DELETE FROM BlogModel WHERE blogId=:blogId";
		Query query = session.createQuery(hql);
		query.setParameter("blogId", blogId);
		query.executeUpdate();
	}

	@Override
	public void deleteWithSQLQuery(int blogId) {
		Session session = sessionFactory.getCurrentSession();

		// Delete children first.
		BlogModel model = findByIdWithSession(blogId);
		for (CommentModel comment : model.getComments()) {
			String sql = "DELETE FROM comment WHERE comment_id=:commentId";
			SQLQuery query = session.createSQLQuery(sql);
			query.setParameter("commentId", comment.getCommentId());
			query.executeUpdate();
		}

		String sql = "DELETE FROM blog WHERE blog_id=:blogId";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("blogId", blogId);
		query.executeUpdate();
	}

	@Override
	public void updateWithSession(BlogModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void updateWithHQLQuery(int blogId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE BlogModel SET blogTitle=:blogTitle WHERE blogId=:blogId";
		Query query = session.createQuery(hql);
		query.setParameter("blogTitle", "newBlogTitle");
		query.setParameter("blogId", blogId);
		query.executeUpdate();
	}

	@Override
	public void updateWithSQLQuery(int blogId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "UPDATE blog SET blog_title=:blogTitle WHERE blog_id=:blogId";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("blogTitle", "newBlogTitle");
		query.setParameter("blogId", blogId);
		query.executeUpdate();
	}

	@Override
	public BlogModel findByIdWithSession(int blogId) {
		Session session = sessionFactory.getCurrentSession();
		BlogModel result = (BlogModel) session.get(BlogModel.class, blogId);
		return result;
	}

	@Override
	public BlogModel findByIdWithHQLQuery(int blogId) {
		// Query all properties from model.
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM BlogModel WHERE blogId=:blogId");
		query.setParameter("blogId", blogId);
		BlogModel result = (BlogModel) query.uniqueResult();

		// Query partial properties from model.
		query = session.createQuery("SELECT new BlogModel(blogTitle,blogAuthor) FROM BlogModel WHERE blogId=:blogId");
		query.setParameter("blogId", blogId);
		result = (BlogModel) query.uniqueResult();
		return result;
	}

	@Override
	public BlogInfo findByIdWithSQLQuery(int blogId) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM blog WHERE blog_id=:blogId");
		query.setParameter("blogId", blogId);
		query.setResultTransformer(Transformers.aliasToBean(BlogInfo.class));
		BlogInfo result = (BlogInfo) query.uniqueResult();
		return result;
	}

	@Override
	public BlogModel findByIdWithCriteria(int blogId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(BlogModel.class);
		cr.add(Restrictions.eq("blogId", blogId));
		cr.add(Restrictions.isNotNull("blogTitle"));
		cr.add(Restrictions.in("blogTitle", new String[] { "abc", "def" }));
		cr.addOrder(Order.asc("blogId"));
		cr.addOrder(Order.desc("blogTitle"));
		BlogModel result = (BlogModel) cr.uniqueResult();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BlogModel> findByAllWithHQLQuery() {
		// Query all properties from model.
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM BlogModel");
		List<BlogModel> result = query.list();

		// Query partial properties from model.
		query = session.createQuery("SELECT new BlogModel(blogTitle,blogAuthor) FROM BlogModel");
		result = query.list();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BlogInfo> findByAllWithSQLQuery() {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM blog");
		query.setResultTransformer(Transformers.aliasToBean(BlogInfo.class));
		List<BlogInfo> result = query.list();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BlogModel> findByAllWithCriteria() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(BlogModel.class);
		cr.addOrder(Order.asc("blogId"));
		cr.addOrder(Order.desc("blogTitle"));
		List<BlogModel> result = cr.list();
		return result;
	}

}
