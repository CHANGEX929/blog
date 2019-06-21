package com.changex.blog.test.staticproxy;

/**
 * @author Xie Chenxi
 * @date 2019-02-12 18:45
 */
public class StudentsProxy implements Person {
    //被代理的学生
    Student stu;

    public StudentsProxy(Person stu) {
        // 只代理学生对象
        if (stu.getClass() == Student.class) {
            this.stu = (Student) stu;
        }
    }

    //代理上交班费，调用被代理学生的上交班费行为
    @Override
    public void giveMoney() {

        System.out.println("~~~~~");
        stu.giveMoney();
    }
}
