package io.test;

import io.domain.Person;
import org.junit.Test;

import java.io.*;

/**
 * ��java����ת�ɶ�������  ���߽���������ת��java����
 */
public class IOObjectOUtputstreamDemo {

    /**
     * ��java����ת�ɶ�������
     */
    @Test
    public void test1() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.bat"));

        objectOutputStream.writeObject(new String("���Զ�����"));
        objectOutputStream.flush();
        objectOutputStream.writeObject(new Person("�T�T",22,"mail"));
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    /**
     * �����л�
     */
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.bat"));
        String str = (String)objectInputStream.readObject();
        Person person = (Person)objectInputStream.readObject();

        System.out.println(str);
        System.out.println(person);

        objectInputStream.close();

    }
}
