package com.gmail.magiccircuit.recruitment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate(true)
@Entity(name = "t_accept_info")
@Table(indexes = { @Index(name = "idx_acceptinfo_recruitinfo_id", columnList = "recruitInfoId"),
		@Index(name = "idx_acceptinfo_user_id", columnList = "userId") })
public class AcceptInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = false)
	private Long recruitInfoId;

	@Column(nullable = false, unique = false)
	private Long userId;

	@Column(nullable = true, unique = false, length = 200)
	private String userName;

	@Column(nullable = true, unique = false, length = 20)
	private String userMobile;

	@Column(nullable = true, unique = false, length = 50)
	private String userEmail;

	@Column(nullable = true, unique = false, length = 500)
	private String userDesc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true, unique = false)
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRecruitInfoId() {
		return recruitInfoId;
	}

	public void setRecruitInfoId(Long recruitInfoId) {
		this.recruitInfoId = recruitInfoId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
