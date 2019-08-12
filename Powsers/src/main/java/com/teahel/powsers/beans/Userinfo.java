
package com.teahel.powsers.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Userinfo {
	@Id
	@GeneratedValue
	private long userid;
    @Column(nullable = false, unique = true)
	private String username;
    @Column(nullable = false, unique = true)
	private String password;
    @Column(nullable = false, unique = true)
	private String userclazz;

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserclazz() {
		return userclazz;
	}

	public void setUserclazz(String userclazz) {
		this.userclazz = userclazz;
	}

}
