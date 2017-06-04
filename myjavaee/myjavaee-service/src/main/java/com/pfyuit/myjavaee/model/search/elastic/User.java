package com.pfyuit.myjavaee.model.search.elastic;

/**
 * User model for elastic search.
 * 
 * @author yupengfei
 */
public class User {

	private String userId;
	private String userName;
	private String userFavorite;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFavorite() {
		return userFavorite;
	}

	public void setUserFavorite(String userFavorite) {
		this.userFavorite = userFavorite;
	}

}
