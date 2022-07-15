package com.zlt.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 有什么表就有什么类
 * 表中有哪些列，类中就设置哪些属性
 * 表中的每一行数据，可以使用该类的对象来进行存储
 *
 * ORM映射：把数据库中的数据映射为java代码中的对象来存储
 */
public class User {

    private int id;
    private String ename;
    private double sal;

    //alt+insert
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", sal=" + sal +
                '}';
    }
}
