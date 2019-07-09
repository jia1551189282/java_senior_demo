package com.jiajia;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通道（channel)
 * 连接源节点和目标节点 ,负责缓冲区的数据传输，本身不存储数据
 */
public class NIOChannelTest {
    /**
     * 1 利用通道完成文件的复制    （非直接缓冲区）
     */
    @Test
    public void test1() throws IOException {
        long start = System.currentTimeMillis();
        // 1 获取字节流
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\mx-chenz\\Desktop\\data.zip");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\mx-chenz\\Desktop\\data1.zip");
        // 2 获取通道
        FileChannel channel = fileInputStream.getChannel();
        FileChannel channel1 = fileOutputStream.getChannel();
        // 3 指定缓冲区的大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 4 将通道中的数据写入到缓冲区
        while(channel.read(byteBuffer) != -1){
            byteBuffer.flip(); //切换缓冲区为读取模式
            // 将 缓冲区的数据写入到通道中
            channel1.write(byteBuffer);
            // 清空缓冲区
            byteBuffer.clear();
        }
        // 关闭流
        channel.close();
        channel1.close();
        fileInputStream.close();
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("耗时为 ：" +(end - start));
    }
}
