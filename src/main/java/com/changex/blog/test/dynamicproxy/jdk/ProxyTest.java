package com.changex.blog.test.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author Xie Chenxi
 * @date 2019-02-12 18:49
 */
public class ProxyTest {
    public static void main(String[] args) {

        testMethodTimeAop(new Test(), TestInterface.class).test();

        testMethodTimeAop(new Student("小明"), Person.class).giveMoney();
    }

    /**
     * 计算方法调用时间AOP
     *
     * @param target
     * @param <T>
     * @return
     */
    public static <T extends S, S> S testMethodTimeAop(T target, Class<S> intclas) {
        return (S) Proxy.newProxyInstance(intclas.getClassLoader(), new Class<?>[]{intclas}, new StuInvocationHandler<>(target));
    }
}
