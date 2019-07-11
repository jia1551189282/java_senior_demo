package com.jiajia.proxy;


import java.lang.reflect.Proxy;

public class MyProxyFactory {


    public static Object produceProxyInstance(Object obj){//obj:��������Ķ���
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }


}
