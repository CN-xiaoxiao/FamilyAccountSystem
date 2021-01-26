package com.xiaoxiao.dao;

import com.xiaoxiao.bean.Bill;
import com.xiaoxiao.bean.User;
import com.xiaoxiao.util.DateFormatUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author xiaoxiao
 * @create 2021-01-24 1:22
 */
public class UserBillData implements Serializable {
    private User user; //一个账户对象
    private ArrayList<Bill> data = new ArrayList<Bill>();

    public UserBillData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    /**
     * 添加账单
     * @param b
     */
    public void add(Bill b) {
        data.add(b);
    }

    /**
     * 获取登录者所有账单
     *
     * @return
     */
    public ArrayList<Bill> findAll() {
        return data;
    }

    /**
     * 根据索引修改账单
     * @param index
     * @param newBill
     */
    public void updata(int index, Bill newBill) {
        if (index == -1) {
            return;
        }
        Bill oldBill = data.get(index);
        oldBill.setType(newBill.getType());
        oldBill.setMoney(newBill.getMoney());
        oldBill.setDescription(newBill.getDescription());

    }

    /**
     * 根据索引删除账单
     * @param index
     */
    public void remove(int index) {
        if (index == -1) {
            //System.out.println("没有数据，请添加后在进行操作！");
            return;
        } else {
            data.remove(index);
        }
    }

    /**
     * 根据账单类型获取
     *
     * @param type
     * @return
     */
    public ArrayList<Bill> findByType(String type) {
        if ("所有账单".equals(type)) {
            return data;
        }

        ArrayList<Bill> typeData = new ArrayList<>();
        for (Bill datum : data) {
            if (type != null && type.equals(datum.getType())) {
                typeData.add(datum);
            }
        }

        return typeData;
    }

    /**
     * 根据时间区间获取
     *
     * @param start 开始时间
     * @param end 结束时间
     * @return
     */
    public ArrayList<Bill> findByDataInterval(Date start, Date end) {
        ArrayList<Bill> typeData = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            Date date = data.get(i).getDate();
            if (date.getTime() >= start.getTime() && date.getTime() <= end.getTime()) {
                typeData.add(data.get(i));
            }
        }

        return typeData;
    }

    /**
     *根据日期获取
     * @param date 日期时间
     * @return
     */
    public ArrayList<Bill> findByDate(Date date) {
        ArrayList<Bill> typeData = new ArrayList<>();
        String ymd1 = DateFormatUtil.formatYMD(date);

        for (Bill datum : data) {
            String ymd2 = DateFormatUtil.formatYMD(datum.getDate());
            if (ymd1.equals(ymd2)) {
                typeData.add(datum);
            }
        }

        return typeData;
    }
}
