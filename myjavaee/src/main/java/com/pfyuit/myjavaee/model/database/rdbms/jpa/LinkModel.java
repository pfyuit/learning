package com.pfyuit.myjavaee.model.database.rdbms.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity model for JPA/Hibernate.
 * @author yupengfei
 */
@Entity
@Table(name = "link")
@NamedQueries(
{ 
	@NamedQuery(name = "lfindById", query = "SELECT p FROM LinkModel p WHERE p.linkId=:linkId"), 
	@NamedQuery(name = "lfindAll", query = "SELECT p FROM LinkModel p") 
})
public class LinkModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "link_id")
	private int linkId;

	@Column(name = "link_name")
	private String linkName;

	@Column(name = "link_url")
	private String linkUrl;

	public int getLinkId() {
		return linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

}
