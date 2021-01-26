package com.xiaoxiao.data;

import com.xiaoxiao.bean.User;
import com.xiaoxiao.dao.UserBillData;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author xiaoxiao
 * @create 2021-01-24 1:46
 */
public class DataPool implements Serializable {
    private ArrayList<UserBillData> datas = new ArrayList<>(); //其他家庭用户信息
    private UserBillData manager = null; //存储管理员信息

    //初始化管理员信息
    public void init(User u) {
        manager = new UserBillData(u);
    }

    //增加家庭用户
    public boolean addUser(User u) {
        if (u == null || u.getNickName() == null || u.getPassword() == null) {
            return false;
        }

        if (u.getNickName().equals(manager.getUser().getNickName())) {
            return false;
        }

        for (UserBillData data : datas) {
            if (u.getNickName().equals(data.getUser().getNickName())) {
                return false;
            }
        }

        UserBillData ubd = new UserBillData(u);
        datas.add(ubd);

        return true;
    }

    //删除家庭用户
    public boolean removeUser(String nickName) {
        if (nickName == null) {
            return false;
        }

        int index = -1;
        for (int i = 0; i < datas.size(); i++) {
            if (nickName.equals(datas.get(i).getUser().getNickName())) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        datas.remove(index);

        return true;
    }

    //更新用户信息
    public boolean updateUser(User u) {
        if (u == null || u.getNickName() == null || u.getPassword() == null) {
            return false;
        }

        for (UserBillData data : datas) {
            if (u.getNickName().equals(data.getUser().getNickName())) {
                data.getUser().setPassword(u.getPassword());

                return true;
            }
        }

        return false;
    }

    //查找用户信息
    public ArrayList<User> findUsers() {
        ArrayList<User> users = new ArrayList<>();

        for (UserBillData data : datas) {
            users.add(data.getUser());
        }

        return users;
    }

    //用户登录（返回管理员或者普通家庭成员信息
    public UserBillData login(User u) {
        if (u == null || u.getNickName() == null || u.getPassword() == null) {
            return null;
        }

        for (UserBillData data : datas) {
            if (u.getNickName().equals(data.getUser().getNickName()) && u.getPassword().equals(data.getUser().getPassword())) {
                return data;
            }
        }

        if (u.getNickName().equals(manager.getUser().getNickName()) && u.getPassword().equals(manager.getUser().getPassword())) {
            return manager;
        }

        return null;
    }

    //获得所有家庭成员
    public ArrayList<UserBillData> getDatas() {
        return datas;
    }
}
