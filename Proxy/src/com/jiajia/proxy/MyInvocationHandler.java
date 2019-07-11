package com.jiajia.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object object;    //���������

    public  void bind(Object object){  //�󶨱��������
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.beforeMethod();
        Object invoke = method.invoke(object, args);  //ִ�к� �᷵��һ���������
        humanUtil.afterMethod();
        return invoke;        //�������Ҫ����ȥ  ����ſ���ʹ������������
    }
}
