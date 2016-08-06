package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.CategoryModel;

/**
 * Category Dao interface for Hibernate.
 * @author yupengfei
 */
public interface CategoryDao {

	public void saveWithSession(CategoryModel model);

	public void deleteWithSession(CategoryModel model);

	public void deleteWithHQLQuery(int categoryId);

	public void deleteWithSQLQuery(int categoryId);

	public void updateWithSession(CategoryModel model);

	public void updateWithHQLQuery(int categoryId);

	public void updateWithSQLQuery(int categoryId);

	public CategoryModel findByIdWithSession(int categoryId);

	public CategoryModel findByIdWithHQLQuery(int categoryId);

	public CategoryModel findByIdWithSQLQuery(int categoryId);

	public CategoryModel findByIdWithCriteria(int categoryId);

	public List<CategoryModel> findByAllWithHQLQuery();

	public List<CategoryModel> findByAllWithSQLQuery();

	public List<CategoryModel> findByAllWithCriteria();

}