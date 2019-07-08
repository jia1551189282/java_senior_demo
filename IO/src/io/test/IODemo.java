package io.test;

import org.junit.Test;

import java.io.*;

/**
 * �ַ����Ļ�������
 */
public class IODemo {
    /**
     * �����ļ�
     * ��һ���ļ����Ƶ�����һ���ļ�
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
     * �ڴ���д�����ݵ������ļ���
     * File��Ӧ���ļ���������ڵĻ� ���Զ�����
     */
    @Test
    public void test3() throws IOException {
        File file = new File("hello.txt");
        File file1 = new File("hello1.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("I hava a dream");
        fileWriter.write("I hava a dream too");
        fileWriter.close();
        // true��ʾд���ļ�����׷�ӵķ�ʽ ��Ҫ��Ȼ���Ǹ��ǵķ�ʽ
        FileWriter fileWriter1 = new FileWriter(file1,true);
        fileWriter1.write("I have a dream ");
        fileWriter1.write("I hava a dream too");
        fileWriter1.close();

    }
    /**
     * ��������  ʹ��read(char[]);
     */
    @Test
    public void test2() throws IOException {
        File file = new File("test.txt");
        FileReader fileReader = new FileReader(file);

        char[] buffer =new char[5];
        int len ;
        // read(char[]) ���ض�ȡ������char[]�������ַ��ĸ����� ����ﵽ��ĩβ ��᷵��-1
        while((len = fileReader.read(buffer)) != -1){
            String str = new String(buffer,0,len);
            System.out.println(str);
        }
        fileReader.close();
    }
    /**
     *���ļ��е����ݣ����뵽����̨
     */
    @Test
    public void test1() throws IOException {
        File file = new File("test.txt");
        FileReader fileReader = new FileReader(file);
        //��ȡ��ʽһ read()�����᷵��һ���ַ�������Ƕ�ȡ���˽�β���ͷ���-1
        /*int read = fileReader.read();
        while (read != -1){
            System.out.println((char)read);
            read = fileReader.read();
        }*/
        //������ �Է�ʽһ�����޸�
        int data ;
        while((data = fileReader.read()) != -1){
            System.out.println((char)data);
        }

        // �ر���
        fileReader.close();

    }
}
