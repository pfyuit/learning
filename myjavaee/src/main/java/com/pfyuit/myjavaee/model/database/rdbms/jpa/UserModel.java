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
@Table(name = "user")
@NamedQueries(
{ 
	@NamedQuery(name = "ufindById", query = "SELECT p FROM UserModel p WHERE p.userId=:userId"), 
	@NamedQuery(name = "ufindAll", query = "SELECT p FROM UserModel p") 
})
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "user_notes")
	private String userNotes;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNotes() {
		return userNotes;
	}

	public void setUserNotes(String userNotes) {
		this.userNotes = userNotes;
	}

}
