package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="login")
@Inheritance(strategy=InheritanceType.JOINED)


public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="login")
	@SequenceGenerator(name="login", sequenceName="login_seq", allocationSize=1)
	private Integer id;
	private String username;
	@Column(name="user_password")
	private String userPassword;
	private String firstname;
	private String lastname;
	@Column(name="user_level")
	private String userLevel;
	
	
	
	






	public User() {
		super();
		// TODO Auto-generated constructor stub
	}







	public Integer getId() {
		return id;
	}







	public void setId(Integer id) {
		this.id = id;
	}







	public String getUsername() {
		return username;
	}







	public void setUsername(String username) {
		this.username = username;
	}







	public String getUserPassword() {
		return userPassword;
	}







	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}







	public String getFirstname() {
		return firstname;
	}







	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}







	public String getLastname() {
		return lastname;
	}







	public void setLastname(String lastname) {
		this.lastname = lastname;
	}







	public String getUserLevel() {
		return userLevel;
	}







	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}







	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", userPassword=" + userPassword + ", firstname="
				+ firstname + ", lastname=" + lastname + ", userLevel=" + userLevel + "]";
	}
	
	
	

}
