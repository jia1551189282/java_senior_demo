package com.jiajia;

public class ProxyClothFactory implements com.jiajia.ClothFactory {
    private com.jiajia.ClothFactory clothFactory ; //�ô����������������

    public ProxyClothFactory(com.jiajia.ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }


    @Override
    public void produceCloth() {
        System.out.println("��������һЩ׼��=======");
        clothFactory.produceCloth();
        System.out.println("����������β����");
    }
}
