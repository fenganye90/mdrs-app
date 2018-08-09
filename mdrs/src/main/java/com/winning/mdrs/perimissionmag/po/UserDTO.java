package com.winning.mdrs.perimissionmag.po;

import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.ValidateWithMethod;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class UserDTO {

	private Integer id;
	@NotNull(message = "用户名不能为空，请您先填写用户名")
	private String username;
	@NotNull(message = "手机号不能为空，请您先填写手机号")
	private String phone;
	@NotNull(message = "默认登录界面")
	private String defaultUrl;
	@NotNull(message = "密码不能为空")
	@MatchPattern(pattern = "^[0-9_a-zA-Z]{6,20}$", message = "用户名或密码有误，请您重新填写")
	private String password;
	@NotNull(message = "真实姓名")
	private String realName;

	private String isForbidden;
	
	private String type;
	
	private String description;
	
	private String perfessional;

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
		return defaultUrl;
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

	public String getIsForbidden() {
		return isForbidden;
	}

	public void setIsForbidden(String isForbidden) {
		this.isForbidden = isForbidden;
	}

	public String getType() {
		return type;
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

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", phone=" + phone + ", defaultUrl=" + defaultUrl
				+ ", password=" + password + ", realName=" + realName + ", isForbidden=" + isForbidden + ", type="
				+ type + ", description=" + description + ", perfessional=" + perfessional + "]";
	}



}