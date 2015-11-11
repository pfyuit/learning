package com.pfyuit.myjavaee.model.database.rdbms.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity model for JPA/Hibernate.
 * @author yupengfei
 */
@Entity
@Table(name = "link")
public class LinkModel {

	@Id
	@Column(name = "linkid")
	private int linkid;

	@Column(name = "name")
	private String name;

	@Column(name = "url")
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
