package com.pfyuit.myjavaee.model.database.jpa;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity model for JPA.
 * @author yupengfei
 */
@Entity
@Table(name = "comment")
@NamedQueries(
{ 
	@NamedQuery(name = "cofindById", query = "SELECT p FROM CommentModel p WHERE p.commentId=:commentId"), 
	@NamedQuery(name = "cofindAll", query = "SELECT p FROM CommentModel p") 
})
public class CommentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private int commentId;

	@Column(name = "create_time")
	private Timestamp createTime;

	@Column(name = "comment_author")
	private String commentAuthor;

	@Column(name = "comment_content")
	private String commentContent;

	@ManyToOne(targetEntity = BlogModel.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "blog_id")
	private BlogModel blog;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public BlogModel getBlog() {
		return blog;
	}

	public void setBlog(BlogModel blog) {
		this.blog = blog;
	}

}
