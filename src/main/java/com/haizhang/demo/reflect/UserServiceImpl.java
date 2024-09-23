package com.haizhang.demo.reflect;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public String getName() {
        System.out.println("execute getname method");
        return "haizhang";
    }

    @Override
    public void save() {
        System.out.println("execute save method");
    }

    public void other(){
        System.out.println("invoke otehr ");
    }
}
