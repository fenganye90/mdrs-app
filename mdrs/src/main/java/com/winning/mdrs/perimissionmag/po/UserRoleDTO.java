package com.winning.mdrs.perimissionmag.po;

public class UserRoleDTO {
	private Integer id;

	private String username;

	private String phone;
	/**
	 * 0为后端，1为前端
	 */
	private String defaultUrl;

	private String password;

	private String realName;

	private String insertTime;

	private String updateTime;
	/**
	 * 是否禁用，默认0为可使用，1为禁用
	 */
	private String isForbidden;
	/**
	 * 用户类型，0为平台用户，1位HIS用户
	 */
	private String type;

	private String description;

	private String perfessional;

	private String roleNames;
	private boolean flag;

	public UserRoleDTO() {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDefaultUrl() {
		return defaultUrl.equals("1")?"后台":"前端";
	}

	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getIsForbidden() {
		return isForbidden;
	}

	public void setIsForbidden(String isForbidden) {
		this.isForbidden = isForbidden;
	}

	public String getType() {
		return type.equals("0")?"平台用户":"HIS用户";
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPerfessional() {
		return perfessional;
	}

	public void setPerfessional(String perfessional) {
		this.perfessional = perfessional;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	public boolean isFlag() {
		return isForbidden.equals("0")?true:false;
	}

	@Override
	public String toString() {
		return "UserRoleDTO [id=" + id + ", username=" + username + ", phone=" + phone + ", defaultUrl=" + defaultUrl
				+ ", password=" + password + ", realName=" + realName + ", insertTime=" + insertTime + ", updateTime="
				+ updateTime + ", isForbidden=" + isForbidden + ", type=" + type + ", description=" + description
				+ ", perfessional=" + perfessional + ", roleNames=" + roleNames + ", flag=" + flag + "]";
	}
	
}