package jiajia.com.thread.threadpoll;

/**
 * ͨ���̳߳صķ�ʽ �����߳�
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
