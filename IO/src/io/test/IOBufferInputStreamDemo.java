package io.test;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流
 *  1 处理流的一种
 *  2 提高流的读取和写入速度 （内部提供了一个缓冲区)
 *  3 就是在已有的流上包装了一层
 */
public class IOBufferInputStreamDemo {
    /**
     * 缓冲流 复制非文本文件
     */
    @Test
    public void test2() throws IOException {
        File  file = new File("3.jpg");
        File  file1 = new File("4.jpg");

        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file1);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] bytes = new byte[1024];
        int len;
        while((len = bufferedInputStream.read(bytes)) != -1){
            bufferedOutputStream.write(bytes,0,len);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    /**
     * 缓冲流 复制文本文件
     */
    @Test
    public void test1() throws IOException {
        File copysrc = new File("buffersrc.txt");
        File copydri = new File("bufferdec.txt");

        FileReader fileReader = new FileReader(copysrc);
        FileWriter fileWriter = new FileWriter(copydri);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        char[] chars = new char[8];
        int len ;
        while ((len = bufferedReader.read(chars)) != -1){

            bufferedWriter.write(chars,0,len);
        }
        //外层流关闭了  内层流也会跟着关闭
        bufferedReader.close();
        bufferedWriter.close();
    }
}
