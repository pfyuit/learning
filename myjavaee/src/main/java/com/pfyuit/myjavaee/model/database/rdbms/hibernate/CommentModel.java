package com.pfyuit.myjavaee.model.database.rdbms.hibernate;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity model for JPA/Hibernate.
 * @author yupengfei
 */
@Entity
@Table(name = "comment")
public class CommentModel {

	@Id
	@Column(name = "commentid")
	private int commentid;

	@Column(name = "createTime")
	private Timestamp createTime;

	@Column(name = "author")
	private String author;

	@Column(name = "content")
	private String content;

	@ManyToOne(targetEntity = BlogModel.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "blogid")
	private BlogModel blog;

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BlogModel getBlog() {
		return blog;
	}

	public void setBlog(BlogModel blog) {
		this.blog = blog;
	}

}
