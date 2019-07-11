package com.jiajia;


import org.junit.Test;

/**
 * 测试静态代理
 * 这种方式  运行时 代理对象和被代理对象都被创建出来了
 */
public class ProxyTest {
    @Test
    public void test(){
        ClothFactory nike = new com.jiajia.NikeClothFactory();
        ProxyClothFactory clothFactory = new ProxyClothFactory(nike);

        clothFactory.produceCloth();

    }
}
