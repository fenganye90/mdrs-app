package com.winning.mdrs.perimissionmag.mapper;

import com.winning.mdrs.perimissionmag.model.User;
import com.winning.mdrs.perimissionmag.po.UserRoleDTO;
import com.winning.mdrs.perimissionmag.po.UserRolesVO;
import com.winning.mdrs.perimissionmag.po.UserSearchDTO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
	int deleteByPrimaryKey(Integer id);
	/**
	 * 如果要使用自返回主键，则此处不能加@Param
	 * @param record
	 * @return
	 */
	int insert(User record);

	int insertSelective(@Param("record")User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(@Param("record")User record);

	int updateByPrimaryKey(@Param("record")User record);

	/**
	 * 分页查询用户数据
	 * @return
	 */
	List<UserRoleDTO> getUsers(@Param("userSearch") UserSearchDTO userSearch);


	/**
	 * 设置用户是否禁用
	 * @param id
	 * @param isJob
	 * @return
	 */
	int setJobUser(@Param("id") Integer id, @Param("isForbidden") Integer isForbidden);

	/**
	 * 查询用户及对应的角色
	 * @param id
	 * @return
	 */
	UserRolesVO getUserAndRoles(Integer id);

	/**
	 * 根据用户名和密码查找用户
	 * @param username
	 * @param password
	 * @return
	 */
	User findUser(@Param("username") String username,
			@Param("password") String password);


	/**
	 * 根据用户名获取用户数据
	 * @param username
	 * @return
	 */
	User findUserByName(String username);

	/**
	 * 修改用户密码
	 * @param id
	 * @param password
	 * @return
	 */
	int updatePwd(@Param("id") Integer id, @Param("password") String password);

	/**
	 * 是否禁用用户
	 * @param id
	 * @param isLock
	 * @return
	 */
	int setUserLockNum(@Param("id") Integer id,@Param("isLock") int isLock);
}