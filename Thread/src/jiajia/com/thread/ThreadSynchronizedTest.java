package jiajia.com.thread;

/**
 * 测试加了同步代码块后的卖票
 */
public class ThreadSynchronizedTest {
    public static void main(String[] args) {
        ThreadSynchronizedDemo thread = new ThreadSynchronizedDemo();
        ThreadSynchronizedDemo thread1 = new ThreadSynchronizedDemo();
        ThreadSynchronizedDemo thread2 = new ThreadSynchronizedDemo();

        thread.setName("窗口1");
        thread1.setName("窗口2");
        thread2.setName("窗口3");

        thread.start();
        thread1.start();
        thread2.start();

    }


}
