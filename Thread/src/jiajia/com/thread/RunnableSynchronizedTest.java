package jiajia.com.thread;

/**
 * ����ʵ��Runnable �ӿڵ���Ʊ
 */
public class RunnableSynchronizedTest {
    public static void main(String[] args) {

        RunnableSynchronizedDemo runnableSynchronizedDemo  = new RunnableSynchronizedDemo();
        Thread thread = new Thread(runnableSynchronizedDemo);
        Thread thread1 = new Thread(runnableSynchronizedDemo);
        Thread thread2 = new Thread(runnableSynchronizedDemo);

        thread.setName("����1");
        thread1.setName("����2");
        thread2.setName("����3");

        thread.start();
        thread1.start();
        thread2.start();

    }
}
