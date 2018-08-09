package com.winning.mdrs.perimissionmag.po;

import java.util.Date;
import java.util.List;

import com.winning.mdrs.perimissionmag.model.UserRoleKey;

public class UserRolesVO {
	private Integer id;

	private String username;

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
	 * 用户类型，  
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
	private String createTime;
	/**
	 * 更新时间
	 */
	private String updateTime;

	private List<UserRoleKey> userRoles;

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
		this.username = username == null ? null : username.trim();
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public List<UserRoleKey> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoleKey> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRolesVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserRolesVO [id=" + id + ", username=" + username + ", password=" + password + ", defaultUrl="
				+ defaultUrl + ", realName=" + realName + ", isForbidden=" + isForbidden + ", type=" + type + ", phone="
				+ phone + ", description=" + description + ", professional=" + professional + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", userRoles=" + userRoles + "]";
	}

}