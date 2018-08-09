package com.winning.mdrs.perimissionmag.service;

import com.winning.mdrs.perimissionmag.model.User;
import com.winning.mdrs.perimissionmag.po.UserDTO;
import com.winning.mdrs.perimissionmag.po.UserRolesVO;
import com.winning.mdrs.perimissionmag.po.UserSearchDTO;
import com.winning.mdrs.utils.PageDataResult;

/**
 * @类描述：
 * @创建人：Johney
 * @创建时间：2017-12-20 15:52
 * @version：V1.0
 */
public interface UserService {
	/**
	 * 分页查询用户列表
	 * @param page
	 * @param limit
	 * @return
	 */
	PageDataResult getUsers(UserSearchDTO userSearch, int page, int limit);

	/**
	 *	设置用户【新增或更新】
	 * @param user
	 * @param roleIds
	 * @return
	 */
	String setUser(User user, String roleIds);

	/**
	 * 设置用户是否离职
	 * @param id
	 * @param isJob
	 * @return
	 */
	int setJobUser(Integer id, Integer isJob);


	/**
	 * 查询用户数据
	 * @param id
	 * @return
	 */
	UserRolesVO getUserAndRoles(Integer id);


	/**
	 * 根据用户名获取用户数据
	 * @param username
	 * @return
	 */
	User findUserByName(String username);

	/**
	 * 修改用户手机号
	 * @param id
	 * @param password
	 * @return
	 */
	int updatePwd(Integer id, String password);

	/**
	 * 禁用用户
	 * @param id
	 * @param isLock  0:解锁；1：锁定
	 * @return
	 */
	int setUserLockNum(Integer id,int isLock);
}
