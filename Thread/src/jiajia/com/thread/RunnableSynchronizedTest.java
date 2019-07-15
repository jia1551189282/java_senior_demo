package jiajia.com.thread;

/**
 * 测试实现Runnable 接口的卖票
 */
public class RunnableSynchronizedTest {
    public static void main(String[] args) {

        RunnableSynchronizedDemo runnableSynchronizedDemo  = new RunnableSynchronizedDemo();
        Thread thread = new Thread(runnableSynchronizedDemo);
        Thread thread1 = new Thread(runnableSynchronizedDemo);
        Thread thread2 = new Thread(runnableSynchronizedDemo);

        thread.setName("窗口1");
        thread1.setName("窗口2");
        thread2.setName("窗口3");

        thread.start();
        thread1.start();
        thread2.start();

    }
}
