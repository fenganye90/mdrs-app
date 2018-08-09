package com.winning.mdrs.perimissionmag.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private static final long serialVersionUID = -3096736268081409238L;
	private Integer id;
	/**
	 * 登录名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 默认登录界面，1为后端，2为前端
	 */
	private Integer defaultUrl;
	/**
	 * 用户实际姓名
	 */
	private String realName;
	/**
	 * 是否禁用，默认0为可使用，1为禁用
	 */
	private Integer isForbidden;
	/**
	 * 用户类型，0为平台用户，1位HIS用户
	 */
	private Integer type;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 用户描述
	 */
	private String description;
	/**
	 * 用户专业
	 */
	private String professional;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(Integer id, String username, String password, Integer defaultUrl, String realName, Integer isForbidden,
			Integer type, String phone, String description, String professional, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.defaultUrl = defaultUrl;
		this.realName = realName;
		this.isForbidden = isForbidden;
		this.type = type;
		this.phone = phone;
		this.description = description;
		this.professional = professional;
		this.createTime = createTime;
		this.updateTime = updateTime;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getDefaultUrl() {
		return defaultUrl;
	}
	public void setDefaultUrl(Integer defaultUrl) {
		this.defaultUrl = defaultUrl;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getIsForbidden() {
		return isForbidden;
	}
	public void setIsForbidden(Integer isForbidden) {
		this.isForbidden = isForbidden;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", defaultUrl=" + defaultUrl
				+ ", realName=" + realName + ", isForbidden=" + isForbidden + ", type=" + type + ", phone=" + phone
				+ ", description=" + description + ", professional=" + professional + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

}