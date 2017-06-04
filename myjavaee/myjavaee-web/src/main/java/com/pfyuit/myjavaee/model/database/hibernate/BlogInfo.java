package com.pfyuit.myjavaee.model.database.hibernate;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author yupengfei
 */
public class BlogInfo {

	private Integer blog_id;
	private String blog_title;
	private String blog_author;
	private Timestamp create_date;
	private Timestamp last_modified;
	private String blog_content;
	private String blog_original;
	private BigInteger read_count;
	private Integer category_id;

	public Integer getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(Integer blog_id) {
		this.blog_id = blog_id;
	}

	public String getBlog_title() {
		return blog_title;
	}

	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}

	public String getBlog_author() {
		return blog_author;
	}

	public void setBlog_author(String blog_author) {
		this.blog_author = blog_author;
	}

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public Timestamp getLast_modified() {
		return last_modified;
	}

	public void setLast_modified(Timestamp last_modified) {
		this.last_modified = last_modified;
	}

	public String getBlog_content() {
		return blog_content;
	}

	public void setBlog_content(String blog_content) {
		this.blog_content = blog_content;
	}

	public String getBlog_original() {
		return blog_original;
	}

	public void setBlog_original(String blog_original) {
		this.blog_original = blog_original;
	}

	public BigInteger getRead_count() {
		return read_count;
	}

	public void setRead_count(BigInteger read_count) {
		this.read_count = read_count;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

}
