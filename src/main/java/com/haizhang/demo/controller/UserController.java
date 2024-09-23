package com.haizhang.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haizhang.demo.bean.UserInfo;
import com.haizhang.demo.reflect.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public UserInfo getMsg(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(10);
        Map<String,String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        userInfo.setInfo(map);
        userInfo.setName("haizhang");
        return userInfo ;
    }

    @GetMapping("/test")
    public String test(){

        userService.save();
        // UserInvocation userInvocation = new UserInvocation();
		// userInvocation.setUserService(userService);
		// UserService proxy = (UserService)userInvocation.getProxy();
		// proxy.save();
		// proxy.getName();
        return  "success";
    }
}
