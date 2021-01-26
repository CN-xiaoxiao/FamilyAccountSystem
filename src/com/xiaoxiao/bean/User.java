package com.xiaoxiao.bean;

import java.io.Serializable;

/**
 * @author xiaoxiao
 * @create 2021-01-23 23:00
 */
public class User implements Serializable {
    private String nickName; //昵称
    private String password; //密码
    private boolean manager; //是否为管理员

    public User(String nickName, String password, boolean manager) {
        this.nickName = nickName;
        this.password = password;
        this.manager = manager;
    }

    public User(String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "家庭成员登录名："+ nickName +
                "\t\t家庭成员密码：" + password;
    }
}
