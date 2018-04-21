package com.gmail.magiccircuit.recruitment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "t_user")
@Table(indexes = { @Index(name = "idx_user_open_id", columnList = "openId") })
@DynamicUpdate
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true, unique = false, length = 100)
	private String openId;

	@Column(nullable = true, unique = false, length = 200)
	private String wxNickName;

	@Column(nullable = true, unique = false, length = 10)
	private String wxGender;

	@Column(nullable = true, unique = false, length = 500)
	private String wxAvatarUrl;

	@Column(nullable = true, unique = false, length = 50)
	private String wxCountry;

	@Column(nullable = true, unique = false, length = 50)
	private String wxProvince;

	@Column(nullable = true, unique = false, length = 50)
	private String wxCity;

	@Column(nullable = true, unique = false, length = 200)
	private String userName;

	@Column(nullable = true, unique = false, length = 20)
	private String userMobile;

	@Column(nullable = true, unique = false, length = 50)
	private String userEmail;

	@Column(nullable = true, unique = false, length = 500)
	private String userDesc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getWxNickName() {
		return wxNickName;
	}

	public void setWxNickName(String wxNickName) {
		this.wxNickName = wxNickName;
	}

	public String getWxGender() {
		return wxGender;
	}

	public void setWxGender(String wxGender) {
		this.wxGender = wxGender;
	}

	public String getWxAvatarUrl() {
		return wxAvatarUrl;
	}

	public void setWxAvatarUrl(String wxAvatarUrl) {
		this.wxAvatarUrl = wxAvatarUrl;
	}

	public String getWxCountry() {
		return wxCountry;
	}

	public void setWxCountry(String wxCountry) {
		this.wxCountry = wxCountry;
	}

	public String getWxProvince() {
		return wxProvince;
	}

	public void setWxProvince(String wxProvince) {
		this.wxProvince = wxProvince;
	}

	public String getWxCity() {
		return wxCity;
	}

	public void setWxCity(String wxCity) {
		this.wxCity = wxCity;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
}
