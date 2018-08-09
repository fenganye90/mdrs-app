package com.winning.mdrs.perimissionmag.po;

/**
 * @类描述：
 * @创建人：Johney
 * @创建时间：2018-01-02 17:10
 * @version：V1.0
 */
public class UserSearchDTO {

	private Integer page;

	private Integer limit;

	private String username;

	private String isForbidden;

	private String insertTimeStart;

	private String insertTimeEnd;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getInsertTimeStart() {
		return insertTimeStart;
	}

	public void setInsertTimeStart(String insertTimeStart) {
		this.insertTimeStart = insertTimeStart;
	}

	public String getInsertTimeEnd() {
		return insertTimeEnd;
	}

	public void setInsertTimeEnd(String insertTimeEnd) {
		this.insertTimeEnd = insertTimeEnd;
	}
	

	public String getIsForbidden() {
		return isForbidden;
	}

	public void setIsForbidden(String isForbidden) {
		this.isForbidden = isForbidden;
	}

	@Override
	public String toString() {
		return "UserSearchDTO [page=" + page + ", limit=" + limit + ", username=" + username + ", isForbidden="
				+ isForbidden + ", insertTimeStart=" + insertTimeStart + ", insertTimeEnd=" + insertTimeEnd + "]";
	}

}
