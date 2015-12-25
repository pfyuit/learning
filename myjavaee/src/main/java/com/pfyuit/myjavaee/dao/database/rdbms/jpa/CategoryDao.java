package com.pfyuit.myjavaee.dao.database.rdbms.jpa;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.jpa.CategoryModel;

/**
 * Category Dao interface for JPA.
 * @author yupengfei
 */
public interface CategoryDao {

	public void save(CategoryModel model);

	public void delete(CategoryModel model);

	public void update(CategoryModel model);

	public CategoryModel findById(int categoryId);

	public CategoryModel findByIdByNamedQuery(int categoryId);

	public CategoryModel findByIdByNativeQuery(int categoryId);

	public List<CategoryModel> findAll();

	public List<CategoryModel> findAllByNamedQuery();

}