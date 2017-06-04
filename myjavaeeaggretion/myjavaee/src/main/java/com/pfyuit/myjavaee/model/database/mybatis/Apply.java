package com.pfyuit.myjavaee.model.database.mybatis;

import java.sql.Timestamp;

/**
 * Domain class for MyBatis. The framework can automatically convert the snake
 * case fields (from MySQL) into camel case once we configure
 * mapUnderscoreToCamelCase in MyBatis configuration files.
 * @author yupengfei
 */
public class Apply {

	private int applyId;
	private int activityId;
	private int ownerId;
	private String ownerName;
	private String status;
	private Timestamp applyTime;
	private Timestamp lastModify;

	public int getApplyId() {
		return applyId;
	}

	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}

	public Timestamp getLastModify() {
		return lastModify;
	}

	public void setLastModify(Timestamp lastModify) {
		this.lastModify = lastModify;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}
