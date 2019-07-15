package jiajia.com.thread.threadpoll;

/**
 * 通过线程池的方式 创建线程
 *
 */
public class ThreadPoolDemo implements  Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0 ){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
