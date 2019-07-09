package com.jiajia;


import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * buffer 在缓冲区中负责数据的存储，缓冲区就是一个数组，负责存储不同类型的数据
 *
 * *
 *  * 三、缓冲区中的四个核心属性：
 *  * capacity : 容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 *  * limit : 界限，表示缓冲区中可以操作数据的大小。（limit 后数据不能进行读写）
 *  * position : 位置，表示缓冲区中正在操作数据的位置。
 *  *
 *  * mark : 标记，表示记录当前 position 的位置。可以通过 reset() 恢复到 mark 的位置
 *  *
 *  * 0 <= mark <= position <= limit <= capacity
 *  *
 */
public class NIOBufferTest {

    /**
     * 非直接缓冲区的
     */
    @Test
    public void test1(){
        // 1 分配一个指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        System.out.println("============allocate()===================");
        System.out.println("position:" + byteBuffer.position() +"\n"+ "limit:" + byteBuffer.limit() +"\n"+ "capicity:" + byteBuffer.capacity());

        // 2 往缓冲区中存入数据
        // position 的开始索引位置是0
        String str = "abcde";
        byteBuffer.put(str.getBytes());
        System.out.println("===========插入数据后 各变量的变化 ==========================");
        System.out.println("position:" + byteBuffer.position() +"\n"+ "limit:" + byteBuffer.limit() +"\n"+ "capicity:" + byteBuffer.capacity());
        // 3 切换到读取数据模式
        byteBuffer.flip();

        System.out.println("===========切换到读取数据模式后的变化=========================");
        System.out.println("position:" + byteBuffer.position() +"\n"+ "limit:" + byteBuffer.limit() +"\n"+ "capicity:" + byteBuffer.capacity());

        // 4 读取缓冲区中的数据
        byte[] bytes = new byte[byteBuffer.limit()];
        //将数据读取到 bytes数组中去
        byteBuffer.get(bytes);
        System.out.println("缓冲区中读取到的数据" + new String(bytes,0,bytes.length));
        System.out.println("===============读取数据后的变化================================");
        System.out.println("position:" + byteBuffer.position() +"\n"+ "limit:" + byteBuffer.limit() +"\n"+ "capicity:" + byteBuffer.capacity());
        // 5 rewind : 可重复读
        byteBuffer.rewind();
        System.out.println("===============可重复读之后的变化=======================");
        System.out.println("position:" + byteBuffer.position() +"\n"+ "limit:" + byteBuffer.limit() +"\n"+ "capicity:" + byteBuffer.capacity());

        // 6 清除缓冲区 clear()  清除缓冲区后  ，缓冲区的数据依旧存在，只是处于被遗忘状态
        byteBuffer.clear();
        System.out.println("================清除缓冲区后数据的变化================================");
        System.out.println("position:" + byteBuffer.position() +"\n"+ "limit:" + byteBuffer.limit() +"\n"+ "capicity:" + byteBuffer.capacity());

        System.out.println("清除缓冲区后去获取缓冲区中的数据" + (char)byteBuffer.get());
    }
    /**
     * 非直接缓冲区操作2
     */
    @Test
    public void test2(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("abcde".getBytes());
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes,0,2);
        System.out.println(byteBuffer.position());
        // 标记
        byteBuffer.mark();
        byteBuffer.get(bytes,2,2);
        System.out.println(new String(bytes,2,2));
        System.out.println(byteBuffer.position());
        // reset() 恢复到标记的位置
        byteBuffer.reset();
        System.out.println(byteBuffer.position());
        // 判断缓冲区中是否还有剩余数据
        if(byteBuffer.hasRemaining()){
            System.out.println("如果有剩余操作数据，可操作数据是多少 " + byteBuffer.remaining());
        }
    }
    /**
     * 分配直接缓冲区
     * 直接缓冲区会将数据存在物理内存中去
     * 一旦存入动了物理 内存中了   程序就不可控制这部分数据
     */
    @Test
    public void test3(){
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer.isDirect());

    }
}
