package com.xiaoxiao.bean;

import com.xiaoxiao.util.DateFormatUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaoxiao
 * @create 2021-01-23 23:13
 */
public class Bill implements Serializable {
    private String type; //餐饮/购物/交通/娱乐/旅行/其他
    private double money; //账单金额
    private Date date; //账单日期
    private String description; //描述

    @Override
    public String toString() {
        return "账单信息:\n\r" +
                "\t时间：" + DateFormatUtil.formatYMDHm(date) +
                "\n\r\t类型:" + type +
                "\t金额：" + money +
                "\n\r\t账单详细：" + description;
    }

    public Bill() {
    }

    public Bill(String type, double money, Date date, String description) {
        this.type = type;
        this.money = money;
        this.date = date;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
