package io.test;

import io.domain.Person;
import org.junit.Test;

import java.io.*;

/**
 * 将java对象转成二进制流  或者将二进制流转成java对象
 */
public class IOObjectOUtputstreamDemo {

    /**
     * 将java对象转成二进制流
     */
    @Test
    public void test1() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.bat"));

        objectOutputStream.writeObject(new String("测试对象流"));
        objectOutputStream.flush();
        objectOutputStream.writeObject(new Person("玊玊",22,"mail"));
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    /**
     * 反序列化
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
