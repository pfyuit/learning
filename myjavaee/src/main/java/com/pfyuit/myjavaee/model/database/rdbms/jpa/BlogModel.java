package com.pfyuit.myjavaee.model.database.rdbms.jpa;

import java.sql.Timestamp;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity model for JPA/Hibernate.
 * @author yupengfei
 */
@Entity
@Table(name = "blog")
@NamedQueries(
{ 
	@NamedQuery(name = "findById", query = "SELECT p FROM BlogModel p WHERE p.blogId=:blogId"), 
	@NamedQuery(name = "findAll", query = "SELECT p FROM BlogModel p") 
})
public class BlogModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blog_id")
	private int blogId;

	@Column(name = "blog_title")
	private String blogTitle;

	@Column(name = "blog_author")
	private String blogAuthor;

	@Column(name = "create_date")
	private Timestamp createDate;

	@Column(name = "last_modified")
	private Timestamp lastModified;

	@Column(name = "blog_content")
	private String blogContent;

	@Column(name = "blog_original")
	private String blogOriginal;

	@Column(name = "read_count")
	private Long readCount;

	@ManyToOne(targetEntity = CategoryModel.class)
	@JoinColumn(name = "category_id")
	private CategoryModel category;

	/** Not a real column in the table, query on demand **/
	@OneToMany(mappedBy = "blog", fetch = FetchType.LAZY)
	private List<CommentModel> comments;

	/** Field that not persist **/
	@Transient
	private String name;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogAuthor() {
		return blogAuthor;
	}

	public void setBlogAuthor(String blogAuthor) {
		this.blogAuthor = blogAuthor;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public String getBlogOriginal() {
		return blogOriginal;
	}

	public void setBlogOriginal(String blogOriginal) {
		this.blogOriginal = blogOriginal;
	}

	public Long getReadCount() {
		return readCount;
	}

	public void setReadCount(Long readCount) {
		this.readCount = readCount;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public List<CommentModel> getComments() {
		return comments;
	}

	public void setComments(List<CommentModel> comments) {
		this.comments = comments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
