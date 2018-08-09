package com.winning.mdrs.permissionmag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.winning.mdrs.perimissionmag.mapper.UserMapper;
import com.winning.mdrs.perimissionmag.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserMapper {
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testInsert() {
		User user=new User(null, "1", "111111", 1, "11", 0, 0, "123", "1", "1", null, null);
		int id=userMapper.insert(user);
		System.out.println(user.getId());
		System.out.println(user);
	} 

}
