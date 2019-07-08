package io.test;

import org.junit.Test;

import java.io.*;

/**
 * 字符流的操作
 */
public class IOFileInputStreamDemo {

    /**
     * 用字节流操作文本可能会出现乱码
     */
    @Test
    public void test1() throws IOException {
        File file = new File("inputstream.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[5];
        int len;//记录每次读取字节的个数 到文件末尾会返回-1
        while((len = fileInputStream.read(bytes))
                != -1){
            String str = new String(bytes,0,len);
            System.out.println(str);

        }
    }
    /**
     * 复制图片
     */
    @Test
    public void test2() throws IOException {
        File srcfile = new File("1.jpg");
        File dirfile = new File("2.jpg");

        FileInputStream fileInputStream = new FileInputStream(srcfile);
        FileOutputStream fileOutputStream = new FileOutputStream(dirfile);

        byte[] bytes = new byte[5];
        int len ;
        while ((len = fileInputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes);
        }
        fileInputStream.close();
        fileInputStream.close();

    }
}
