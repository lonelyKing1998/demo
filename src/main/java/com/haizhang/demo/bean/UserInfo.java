package com.haizhang.demo.bean;

import java.util.Map;

public class UserInfo {

    private String name ;
    private int age;
    private Map<String,String> info ;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Map<String, String> getInfo() {
        return info;
    }
    public void setInfo(Map<String, String> info) {
        this.info = info;
    }
    

}
