package jiajia.com.thread;

import org.junit.Test;

/**
 * jdk5 ֮ǰ�����̵߳����ַ�ʽ
 * ͬһ���̲߳��ܶ�α�start  Ҫ���¿�һ���߳�
 *
 */
public class TestThread {
    @Test
    public void test1(){
            // �����̶߳���   �������߳�   ��ȥ����run()����
            MyThread myThread = new MyThread();
            myThread.start();

            MyThread myThread1 = new MyThread();
            myThread1.start();

        System.out.println("==============");
        for (int i = 0; i < 100 ; i++) {
            System.out.println(Thread.currentThread().getName() + " test�е��߳� : " + i );
        }
    }
    @Test
    public void test2(){
        TestThreadMethod testThreadMethod = new TestThreadMethod("�����߳�");

        //�����߳�����
         testThreadMethod.setName("�߳�1");

        testThreadMethod.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }

    }

    public static void main(String[] args) {
        TestThreadMethod testThreadMethod = new TestThreadMethod("�����߳�");
        testThreadMethod.setName("�߳�1");
        testThreadMethod.setPriority(Thread.MAX_PRIORITY);
        testThreadMethod.start();

        Thread.currentThread().setName("���߳�");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0 ; i < 100 ; i++) {
            if( i % 2 == 0){

                System.out.println(Thread.currentThread().getName()  + " : " + i);
            }
            if( i  == 20){
                try {
                    testThreadMethod.join();   //���뵽testThreadMethod �߳��ͷ�cpu�ĵط�
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
