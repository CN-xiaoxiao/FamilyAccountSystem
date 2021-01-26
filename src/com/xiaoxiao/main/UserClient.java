package com.xiaoxiao.main;

import com.xiaoxiao.bean.Bill;
import com.xiaoxiao.dao.UserBillData;
import com.xiaoxiao.data.DataPool;
import com.xiaoxiao.view.Views;
import com.xiaoxiao.util.DataFileUtil;

import java.util.ArrayList;
import java.util.Date;

/**
 * 家庭用户账单管理
 * @author xiaoxiao
 * @create 2021-01-24 13:02
 */
public class UserClient {
    private Views v;
    private DataPool dp;
    private UserBillData ubd;

    //构造方法
    public UserClient(Views v, DataPool dp, UserBillData ubd) {
        this.v = v;
        this.dp = dp;
        this.ubd = ubd;
    }

    //启动菜单
    public void start() {
        v.welcomeUser(ubd.getUser().getNickName());

        while (true) {
            int key = v.userClientMenu();

            switch (key) {
                case 1: {
                    //录入账单
                    Bill b = v.addBill();
                    ubd.add(b);
                    v.success();

                    break;
                }

                case 2: {
                    //修改账单
                    int index = v.updateSelectBillIndex(ubd.findAll());

                    if (index == -1) {
                        System.out.println("无法进行修改操作！");
                    } else {
                        Bill b = v.updateBill();
                        ubd.updata(index, b);
                        v.success();
                    }

                    break;
                }

                case 3: {
                    //删除账单
                    int index = v.deleteSelectBillIndex(ubd.findAll());
                    ubd.remove(index);
                    if (index == -1) {
                        System.out.println("无法进行删除操作！");
                    } else {
                        v.success();
                    }

                    break;
                }

                case 4: {
                    //我的账单
                    int t = v.printBillByTypeOrDate();

                    if (t == 1) {
                        String type = v.printType();
                        ArrayList<Bill> data = ubd.findByType(type);
                        v.printBills(data);

                    } else {
                        int byDate = v.printBillByDate();

                        if (byDate == 1) {
                            Date date = v.printBillByDay();
                            ArrayList<Bill> data = ubd.findByDate(date);
                            v.printBills(data);

                        } else {
                            Date start = v.printBillByStartDateInterval();
                            Date end = v.printBillByEndDateInterval(start);
                            ArrayList<Bill> data = ubd.findByDataInterval(start, end);
                            v.printBills(data);
                        }
                    }

                    break;
                }

                case 0: {
                    //退出程序
                    System.exit(0);
                }
            }

            switch (key) {
                case 1:
                case 2:
                case 3:
                    //增删改保存到本地
                    save();

                    break;
            }
        }
    }

    public void save() {
        DataFileUtil.save(dp);
    }
}
