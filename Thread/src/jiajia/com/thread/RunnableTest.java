package jiajia.com.thread;

/**
 * ͨ��Runnable �ķ�ʽ�������߳�
 */
public class RunnableTest {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread thread = new Thread(myThread1);
        thread.setName("�߳�1");
        thread.start();

        Thread thread1 = new Thread(myThread1);
        thread1.setName("�߳�2");
        thread1.start();
    }
}
