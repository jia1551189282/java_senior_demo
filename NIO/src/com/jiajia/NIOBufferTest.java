package com.jiajia;


import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * buffer �ڻ������и������ݵĴ洢������������һ�����飬����洢��ͬ���͵�����
 *
 * *
 *  * �����������е��ĸ��������ԣ�
 *  * capacity : ��������ʾ�����������洢���ݵ�������һ���������ܸı䡣
 *  * limit : ���ޣ���ʾ�������п��Բ������ݵĴ�С����limit �����ݲ��ܽ��ж�д��
 *  * position : λ�ã���ʾ�����������ڲ������ݵ�λ�á�
 *  *
 *  * mark : ��ǣ���ʾ��¼��ǰ position ��λ�á�����ͨ�� reset() �ָ��� mark ��λ��
 *  *
 *  * 0 <= mark <= position <= limit <= capacity
 *  *
 */
public class NIOBufferTest {

    /**
     * ��ֱ�ӻ�������
     */
    @Test
    public void test1(){
        // 1 ����һ��ָ����С�Ļ�����
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        System.out.println("============allocate()===================");
        System.out.println("position:" + byteBuffer.position() +"\n"+ "limit:" + byteBuffer.limit() +"\n"+ "capicity:" + byteBuffer.capacity());

        // 2 ���������д�������
        // position �Ŀ�ʼ����λ����0
        String str = "abcde";
        byteBuffer.put(str.getBytes());
        System.out.println("===========�������ݺ� �������ı仯 ==========================");
        System.out.println("position:" + byteBuffer.position() +"\n"+ "limit:" + byteBuffer.limit() +"\n"+ "capicity:" + byteBuffer.capacity());
        // 3 �л�����ȡ����ģʽ
        byteBuffer.flip();

        System.out.println("===========�л�����ȡ����ģʽ��ı仯=========================");
        System.out.println("position:" + byteBuffer.position() +"\n"+ "limit:" + byteBuffer.limit() +"\n"+ "capicity:" + byteBuffer.capacity());

        // 4 ��ȡ�������е�����
        byte[] bytes = new byte[byteBuffer.limit()];
        //�����ݶ�ȡ�� bytes������ȥ
        byteBuffer.get(bytes);
        System.out.println("�������ж�ȡ��������" + new String(bytes,0,bytes.length));
        System.out.println("===============��ȡ���ݺ�ı仯================================");
        System.out.println("position:" + byteBuffer.position() +"\n"+ "limit:" + byteBuffer.limit() +"\n"+ "capicity:" + byteBuffer.capacity());
        // 5 rewind : ���ظ���
        byteBuffer.rewind();
        System.out.println("===============���ظ���֮��ı仯=======================");
        System.out.println("position:" + byteBuffer.position() +"\n"+ "limit:" + byteBuffer.limit() +"\n"+ "capicity:" + byteBuffer.capacity());

        // 6 ��������� clear()  �����������  �����������������ɴ��ڣ�ֻ�Ǵ��ڱ�����״̬
        byteBuffer.clear();
        System.out.println("================��������������ݵı仯================================");
        System.out.println("position:" + byteBuffer.position() +"\n"+ "limit:" + byteBuffer.limit() +"\n"+ "capicity:" + byteBuffer.capacity());

        System.out.println("�����������ȥ��ȡ�������е�����" + (char)byteBuffer.get());
    }
    /**
     * ��ֱ�ӻ���������2
     */
    @Test
    public void test2(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("abcde".getBytes());
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes,0,2);
        System.out.println(byteBuffer.position());
        // ���
        byteBuffer.mark();
        byteBuffer.get(bytes,2,2);
        System.out.println(new String(bytes,2,2));
        System.out.println(byteBuffer.position());
        // reset() �ָ�����ǵ�λ��
        byteBuffer.reset();
        System.out.println(byteBuffer.position());
        // �жϻ��������Ƿ���ʣ������
        if(byteBuffer.hasRemaining()){
            System.out.println("�����ʣ��������ݣ��ɲ��������Ƕ��� " + byteBuffer.remaining());
        }
    }
    /**
     * ����ֱ�ӻ�����
     * ֱ�ӻ������Ὣ���ݴ��������ڴ���ȥ
     * һ�����붯������ �ڴ�����   ����Ͳ��ɿ����ⲿ������
     */
    @Test
    public void test3(){
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer.isDirect());

    }
}
