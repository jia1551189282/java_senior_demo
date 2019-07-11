package com.jiajia.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object object;    //被代理对象

    public  void bind(Object object){  //绑定被代理对象
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.beforeMethod();
        Object invoke = method.invoke(object, args);  //执行后 会返回一个代理对象
        humanUtil.afterMethod();
        return invoke;        //这个代理要返出去  外面才可以使用这个代理对象
    }
}
