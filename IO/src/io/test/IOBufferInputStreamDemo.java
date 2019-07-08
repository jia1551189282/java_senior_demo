package io.test;

import org.junit.Test;

import java.io.*;

/**
 * ������
 *  1 ��������һ��
 *  2 ������Ķ�ȡ��д���ٶ� ���ڲ��ṩ��һ��������)
 *  3 ���������е����ϰ�װ��һ��
 */
public class IOBufferInputStreamDemo {
    /**
     * ������ ���Ʒ��ı��ļ�
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
     * ������ �����ı��ļ�
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
        //������ر���  �ڲ���Ҳ����Źر�
        bufferedReader.close();
        bufferedWriter.close();
    }
}
