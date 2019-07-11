package com.jiajia;

public class ProxyClothFactory implements com.jiajia.ClothFactory {
    private com.jiajia.ClothFactory clothFactory ; //用代理对象来创建对象

    public ProxyClothFactory(com.jiajia.ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }


    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备=======");
        clothFactory.produceCloth();
        System.out.println("代理工厂做收尾工作");
    }
}
