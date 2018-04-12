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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate(true)
@Entity(name = "t_recruit_info")
@Table(indexes = { @Index(name = "idx_recruitinfo_user_id", columnList = "userId"),
		@Index(name = "idx_recruitinfo_status", columnList = "status") })
public class RecruitInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String STATUS_OPENING = "0";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = false)
	private Long userId;

	@Column(nullable = false, unique = false)
	private String status;

	@Column(nullable = true, unique = false)
	@NotBlank(message = "招聘标题不能为空")
	private String title;

	@Column(nullable = true, unique = false)
	private String remuneration;

	@Column(nullable = true, unique = false)
	@NotBlank(message = "公司名称不能为空")
	private String companyName;

	@Column(nullable = true, unique = false)
	private String region;

	@Column(nullable = true, unique = false)
	private String requireSex;

	@Column(nullable = true, unique = false)
	private String requireAge;

	@Column(nullable = true, unique = false)
	private String jobDesc;

	@Column(nullable = true, unique = false)
	private String recruitNumber;

	@Column(nullable = true, unique = false, length = 200)
	@NotBlank(message = "联系人不能为空")
	private String userName;

	@Column(nullable = true, unique = false, length = 20)
	@NotBlank(message = "手机不能为空")
	private String userMobile;

	@Column(nullable = true, unique = false, length = 50)
	@NotBlank(message = "邮箱不能为空")
	@Email
	private String userEmail;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true, unique = false)
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(String remuneration) {
		this.remuneration = remuneration;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRequireSex() {
		return requireSex;
	}

	public void setRequireSex(String requireSex) {
		this.requireSex = requireSex;
	}

	public String getRequireAge() {
		return requireAge;
	}

	public void setRequireAge(String requireAge) {
		this.requireAge = requireAge;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRecruitNumber() {
		return recruitNumber;
	}

	public void setRecruitNumber(String recruitNumber) {
		this.recruitNumber = recruitNumber;
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
}
