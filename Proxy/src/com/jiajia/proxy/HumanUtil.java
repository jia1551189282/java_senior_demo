package com.jiajia.proxy;

/**
 * 抽取的公用方法
 */
public class HumanUtil {
    public void beforeMethod(){
        System.out.println("==========方法执行之前");
    }

    public void afterMethod(){
        System.out.println("=========方法执行之后");
    }
}
