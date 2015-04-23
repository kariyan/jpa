package kr.or.kosta.edu.domain;

import java.io.Serializable;

public class UserPk implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String userId;
	String userName;

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
	
	public boolean equals(Object other) {
		if (other instanceof UserPk) {
			final UserPk userPk = (UserPk) other;
			return userPk.userId.equals(userId) && userPk.getUserName().equals(userName);
		}
		return false;
	}
	
	public int hashCode() {
		return super.hashCode();
	}
}
