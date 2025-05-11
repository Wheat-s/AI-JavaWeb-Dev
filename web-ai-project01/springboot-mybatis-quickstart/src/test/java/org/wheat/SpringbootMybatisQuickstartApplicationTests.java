package org.wheat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.wheat.mapper.UserMapper;
import org.wheat.pojo.User;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void findAll() {
		List<User> userList = userMapper.findAll();
		System.out.println("\n========================================================================");
		userList.forEach(System.out::println);
		// userList.forEach(user -> System.out.println(user));
		System.out.println("========================================================================\n");
		
	}

}
