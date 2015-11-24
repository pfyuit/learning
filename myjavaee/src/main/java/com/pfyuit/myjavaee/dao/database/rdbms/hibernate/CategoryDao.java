package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.CategoryModel;

/**
 * Category Dao interface for Hibernate.
 * @author yupengfei
 */
public interface CategoryDao {

	public abstract void save(CategoryModel model);

	public abstract void delete(CategoryModel model);

	public abstract void update(CategoryModel model);

	public abstract CategoryModel findById(int categoryId);

	public abstract List<CategoryModel> findAll();

}