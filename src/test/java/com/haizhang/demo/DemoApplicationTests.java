package com.haizhang.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.haizhang.demo.reflect.UserInvocation;
import com.haizhang.demo.reflect.UserServiceImpl;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		UserInvocation userInvocation = new UserInvocation();
		userInvocation.setUserService(new UserServiceImpl());
		UserServiceImpl proxy = (UserServiceImpl)userInvocation.getProxy();
		proxy.save();
		proxy.getName();
		proxy.other();
	}

}
