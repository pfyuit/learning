package com.pfyuit.myjavaee.model.database.rdbms.hibernate;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity model for JPA/Hibernate.
 * @author yupengfei
 */
@Entity
@Table(name = "category")
public class CategoryModel {

	@Id
	@Column(name = "categoryid")
	private int categoryid;

	@Column(name = "name")
	private String name;

	@Column(name = "createTime")
	private Timestamp createTime;

	@Column(name = "sort_id")
	private int sortId;

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
