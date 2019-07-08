package io.test;

import org.junit.Test;

import java.io.*;

/**
 * �ַ����Ĳ���
 */
public class IOFileInputStreamDemo {

    /**
     * ���ֽ��������ı����ܻ��������
     */
    @Test
    public void test1() throws IOException {
        File file = new File("inputstream.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[5];
        int len;//��¼ÿ�ζ�ȡ�ֽڵĸ��� ���ļ�ĩβ�᷵��-1
        while((len = fileInputStream.read(bytes))
                != -1){
            String str = new String(bytes,0,len);
            System.out.println(str);

        }
    }
    /**
     * ����ͼƬ
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
