package com.changex.blog.test.staticproxy;

/**
 * @author Xie Chenxi
 * @date 2019-02-12 18:44
 */
public class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(name + "上交班费50元");
    }
}
