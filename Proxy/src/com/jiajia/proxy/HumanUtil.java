package com.jiajia.proxy;

/**
 * ��ȡ�Ĺ��÷���
 */
public class HumanUtil {
    public void beforeMethod(){
        System.out.println("==========����ִ��֮ǰ");
    }

    public void afterMethod(){
        System.out.println("=========����ִ��֮��");
    }
}
