package com.jiajia;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ͨ����channel)
 * ����Դ�ڵ��Ŀ��ڵ� ,���𻺳��������ݴ��䣬�����洢����
 */
public class NIOChannelTest {
    /**
     * 1 ����ͨ������ļ��ĸ���    ����ֱ�ӻ�������
     */
    @Test
    public void test1() throws IOException {
        long start = System.currentTimeMillis();
        // 1 ��ȡ�ֽ���
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\mx-chenz\\Desktop\\data.zip");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\mx-chenz\\Desktop\\data1.zip");
        // 2 ��ȡͨ��
        FileChannel channel = fileInputStream.getChannel();
        FileChannel channel1 = fileOutputStream.getChannel();
        // 3 ָ���������Ĵ�С
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 4 ��ͨ���е�����д�뵽������
        while(channel.read(byteBuffer) != -1){
            byteBuffer.flip(); //�л�������Ϊ��ȡģʽ
            // �� ������������д�뵽ͨ����
            channel1.write(byteBuffer);
            // ��ջ�����
            byteBuffer.clear();
        }
        // �ر���
        channel.close();
        channel1.close();
        fileInputStream.close();
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("��ʱΪ ��" +(end - start));
    }
}
