package com.pfyuit.myjavaee.model.database.jpa;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity model for JPA/Hibernate.
 * @author yupengfei
 */
@Entity
@Table(name = "category")
@NamedQueries(
{ 
	@NamedQuery(name = "cfindById", query = "SELECT p FROM CategoryModel p WHERE p.categoryId=:categoryId"), 
	@NamedQuery(name = "cfindAll", query = "SELECT p FROM CategoryModel p") 
})
public class CategoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "create_time")
	private Timestamp createTime;

	@Column(name = "sort_id")
	private int sortId;

	/** Not a real column in the table, query on demand **/
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<BlogModel> blogs;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public List<BlogModel> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<BlogModel> blogs) {
		this.blogs = blogs;
	}

}
