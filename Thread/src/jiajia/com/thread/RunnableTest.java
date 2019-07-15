package jiajia.com.thread;

/**
 * 通过Runnable 的方式来创建线程
 */
public class RunnableTest {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread thread = new Thread(myThread1);
        thread.setName("线程1");
        thread.start();

        Thread thread1 = new Thread(myThread1);
        thread1.setName("线程2");
        thread1.start();
    }
}
