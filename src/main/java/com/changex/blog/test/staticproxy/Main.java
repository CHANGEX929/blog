package com.changex.blog.test.staticproxy;

import com.changex.blog.test.staticproxy.Person;
import com.changex.blog.test.staticproxy.Student;
import com.changex.blog.test.staticproxy.StudentsProxy;

/**
 * @author Xie Chenxi
 * @date 2019-02-12 18:45
 */
public class Main {

    public static void main(String[] args) {
        Person student = new Student("小白");
        Person studentsProxy = new StudentsProxy(student);
        studentsProxy.giveMoney();
    }
}
