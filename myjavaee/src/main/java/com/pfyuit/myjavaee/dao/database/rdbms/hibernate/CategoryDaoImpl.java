package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.CategoryModel;

/**
 * Category Dao implement for Hibernate.
 * @author yupengfei
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	@Qualifier("sessionFactoryMyblog")
	private SessionFactory sessionFactory;

	public void save(CategoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	public void delete(CategoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	public void update(CategoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	public CategoryModel findById(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		CategoryModel result = (CategoryModel) session.get(CategoryModel.class, categoryId);
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CategoryModel> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM CategoryModel");
		List<CategoryModel> result = query.list();
		return result;
	}
}
