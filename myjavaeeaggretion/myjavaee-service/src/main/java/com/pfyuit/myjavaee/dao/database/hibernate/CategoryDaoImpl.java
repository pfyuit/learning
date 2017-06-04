package com.pfyuit.myjavaee.dao.database.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.database.hibernate.CategoryModel;

/**
 * Category dao implement for hibernate.
 * @author yupengfei
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	@Qualifier("sessionFactoryMyblog")
	private SessionFactory sessionFactory;

	@Override
	public void saveWithSession(CategoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void deleteWithSession(CategoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public void deleteWithHQLQuery(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "DELETE FROM CategoryModel WHERE categoryId=:categoryId";
		Query query = session.createQuery(hql);
		query.setParameter("categoryId", categoryId);
		query.executeUpdate();
	}

	@Override
	public void deleteWithSQLQuery(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "DELETE FROM category WHERE category_id=:categoryId";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("categoryId", categoryId);
		query.executeUpdate();
	}

	@Override
	public void updateWithSession(CategoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void updateWithHQLQuery(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE CategoryModel SET categoryName=:categoryName WHERE categoryId=:categoryId";
		Query query = session.createQuery(hql);
		query.setParameter("categoryName", "newCategoryName");
		query.setParameter("categoryId", categoryId);
		query.executeUpdate();
	}

	@Override
	public void updateWithSQLQuery(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "UPDATE category SET category_name=:categoryName WHERE category_id=:categoryId";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("categoryName", "newCategoryName");
		query.setParameter("categoryId", categoryId);
		query.executeUpdate();
	}

	@Override
	public CategoryModel findByIdWithSession(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		CategoryModel result = (CategoryModel) session.get(CategoryModel.class, categoryId);
		return result;
	}

	@Override
	public CategoryModel findByIdWithHQLQuery(int categoryId) {
		// Query all properties from model.
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM CategoryModel WHERE categoryId=:categoryId");
		query.setParameter("categoryId", categoryId);
		CategoryModel result = (CategoryModel) query.uniqueResult();

		// Query partial properties from model.
		query = session.createQuery("SELECT new CategoryModel(categoryName,createTime) FROM CategoryModel WHERE categoryId=:categoryId");
		query.setParameter("categoryId", categoryId);
		result = (CategoryModel) query.uniqueResult();
		return result;
	}

	@Override
	public CategoryModel findByIdWithSQLQuery(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM category WHERE category_id=:categoryId");
		query.setParameter("categoryId", categoryId);
		CategoryModel result = (CategoryModel) query.uniqueResult();
		return result;
	}

	@Override
	public CategoryModel findByIdWithCriteria(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(CategoryModel.class);
		cr.add(Restrictions.eq("categoryId", categoryId));
		cr.add(Restrictions.isNotNull("categoryName"));
		cr.add(Restrictions.in("categoryName", new String[] { "abc", "def" }));
		cr.addOrder(Order.asc("categoryId"));
		cr.addOrder(Order.desc("categoryName"));
		CategoryModel result = (CategoryModel) cr.uniqueResult();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CategoryModel> findByAllWithHQLQuery() {
		// Query all properties from model.
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM CategoryModel");
		List<CategoryModel> result = query.list();

		// Query partial properties from model.
		query = session.createQuery("SELECT new CategoryModel(categoryName,createTime) FROM CategoryModel");
		result = query.list();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CategoryModel> findByAllWithSQLQuery() {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM category");
		List<CategoryModel> result = query.list();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CategoryModel> findByAllWithCriteria() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(CategoryModel.class);
		cr.addOrder(Order.asc("categoryId"));
		cr.addOrder(Order.desc("categoryName"));
		List<CategoryModel> result = cr.list();
		return result;
	}

}
