package com.jiajia;


import org.junit.Test;

/**
 * ���Ծ�̬����
 * ���ַ�ʽ  ����ʱ �������ͱ�������󶼱�����������
 */
public class ProxyTest {
    @Test
    public void test(){
        ClothFactory nike = new com.jiajia.NikeClothFactory();
        ProxyClothFactory clothFactory = new ProxyClothFactory(nike);

        clothFactory.produceCloth();

    }
}
