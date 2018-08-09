package com.winning.mdrs.perimissionmag.mapper;

import org.apache.ibatis.annotations.Param;

import com.winning.mdrs.perimissionmag.model.Test;

public interface TestMapper {
	int insertTest(@Param("test")Test test);

}
