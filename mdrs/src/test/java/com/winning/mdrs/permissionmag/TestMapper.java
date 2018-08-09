package com.winning.mdrs.permissionmag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapper {
	@Autowired
	private com.winning.mdrs.perimissionmag.mapper.TestMapper testMapper;
	
	@Test
	public void test() {
		com.winning.mdrs.perimissionmag.model.Test test =new com.winning.mdrs.perimissionmag.model.Test("12111");
		testMapper.insertTest(test);
		System.out.println(test.getId());
	}

}
