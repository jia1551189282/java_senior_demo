package jiajia.com.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁的机制来处理卖票的线程安全问题
 */
public class LockThreadDemo extends  Thread{
    private static int ticket = 100 ;
    ReentrantLock reentrantLock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                reentrantLock.lock();
                try {

                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":当前卖票为 ： " + ticket);
                    ticket--;

                }
            }finally {
                reentrantLock.unlock();  //释放锁
            }

        }
    }
}
