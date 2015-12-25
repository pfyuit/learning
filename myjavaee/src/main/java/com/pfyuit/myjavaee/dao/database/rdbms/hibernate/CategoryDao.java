package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.CategoryModel;

/**
 * Category Dao interface for Hibernate.
 * @author yupengfei
 */
public interface CategoryDao {

	public void save(CategoryModel model);

	public void delete(CategoryModel model);

	public void update(CategoryModel model);

	public CategoryModel findById(int categoryId);

	public List<CategoryModel> findAll();

}