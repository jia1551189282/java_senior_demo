package jiajia.com.thread;

/**
 * ���Լ���ͬ�����������Ʊ
 */
public class ThreadSynchronizedTest {
    public static void main(String[] args) {
        ThreadSynchronizedDemo thread = new ThreadSynchronizedDemo();
        ThreadSynchronizedDemo thread1 = new ThreadSynchronizedDemo();
        ThreadSynchronizedDemo thread2 = new ThreadSynchronizedDemo();

        thread.setName("����1");
        thread1.setName("����2");
        thread2.setName("����3");

        thread.start();
        thread1.start();
        thread2.start();

    }


}
