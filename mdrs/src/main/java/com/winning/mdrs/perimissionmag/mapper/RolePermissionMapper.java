package com.winning.mdrs.perimissionmag.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.winning.mdrs.perimissionmag.model.RolePermissionKey;

import java.util.List;

@Mapper
public interface RolePermissionMapper {
    int deleteByPrimaryKey(RolePermissionKey key);

    int insert(RolePermissionKey record);

    int insertSelective(RolePermissionKey record);

	List<RolePermissionKey> findByRole(int roleId);
}