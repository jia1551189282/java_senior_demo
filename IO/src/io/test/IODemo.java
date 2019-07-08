package io.test;

import org.junit.Test;

import java.io.*;

/**
 * 字符流的基本操作
 */
public class IODemo {
    /**
     * 复制文件
     * 将一个文件复制到另外一个文件
     *
     */
    @Test
    public void test4() throws IOException {
        File srcFile = new File("copysrc.txt");
        File decFile = new File("copydec.txt");

        FileReader fileReader = new FileReader(srcFile);
        FileWriter fileWriter = new FileWriter(decFile,true);

        char[] buffer  =new  char[8];
        int len ;
        while ((len = fileReader.read(buffer)) != -1){
            fileWriter.write(buffer);
        }
        fileWriter.close();
        fileReader.close();
    }

    /**
     * 内存中写出数据到磁盘文件中
     * File对应的文件如果不存在的话 会自动创建
     */
    @Test
    public void test3() throws IOException {
        File file = new File("hello.txt");
        File file1 = new File("hello1.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("I hava a dream");
        fileWriter.write("I hava a dream too");
        fileWriter.close();
        // true表示写入文件的是追加的方式 ，要不然就是覆盖的方式
        FileWriter fileWriter1 = new FileWriter(file1,true);
        fileWriter1.write("I have a dream ");
        fileWriter1.write("I hava a dream too");
        fileWriter1.close();

    }
    /**
     * 升级操作  使用read(char[]);
     */
    @Test
    public void test2() throws IOException {
        File file = new File("test.txt");
        FileReader fileReader = new FileReader(file);

        char[] buffer =new char[5];
        int len ;
        // read(char[]) 返回读取到插入char[]数组中字符的个数， 如果达到了末尾 则会返回-1
        while((len = fileReader.read(buffer)) != -1){
            String str = new String(buffer,0,len);
            System.out.println(str);
        }
        fileReader.close();
    }
    /**
     *将文件中的内容，输入到控制台
     */
    @Test
    public void test1() throws IOException {
        File file = new File("test.txt");
        FileReader fileReader = new FileReader(file);
        //读取方式一 read()方法会返回一个字符，如果是读取到了结尾，就返回-1
        /*int read = fileReader.read();
        while (read != -1){
            System.out.println((char)read);
            read = fileReader.read();
        }*/
        //方法二 对方式一进行修改
        int data ;
        while((data = fileReader.read()) != -1){
            System.out.println((char)data);
        }

        // 关闭流
        fileReader.close();

    }
}
