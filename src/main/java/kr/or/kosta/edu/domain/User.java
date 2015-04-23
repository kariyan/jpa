package kr.or.kosta.edu.domain; 

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(UserPk.class)
public class User {
	
	@Id
	private String userId;
	@Id
	private String userName;
	
	@Embedded
	private Address address;
	
	public User() {
		super();
	}
	public User(String userId, String userName, Address address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
	}
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
