import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个线程之间循序调用
 *多线程之间按顺序调用，实现A->B->C
 *  * 三个线程启动，要求如下：
 *  *
 *  * AA打印5次，BB打印10次，CC打印15次
 *  * 接着
 *  * AA打印5次，BB打印10次，CC打印15次
 *  * ......来10轮
 *
 */
public class ThreadOrderDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.printA(i);
            }
        },"AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.printB(i);
            }
        },"BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.printC(i);
            }
        },"cc").start();


    }

}


class ShareResource{
    private  int number = 1 ; // 1 - A   2 - B 3 - C
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    public void printA(int totalLoop){
        lock.lock();
        try {
            // 1 判断
            while(number != 1){
                condition1.await();
            }
            // 2 干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t totalloop" + totalLoop);
            }
            // 3 通知
            number = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB(int totalLoop){
        lock.lock();
        try {
            // 1 判断
            while (number != 2){
                condition2.await();
            }
            // 2 干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t totalLoop" + totalLoop);
            }

            // 3 通知
            number = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printC(int totalLoop){
        lock.lock();
        try {
            // 1 判断
            while(number != 3){
                condition3.await();
            }

            // 2 干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t totalLoop" + totalLoop);
            }
            // 3 通知
            number = 1;
            condition1.signal();
        }catch (Exception e){
                e.printStackTrace();
       }finally {
            lock.unlock();
        }
    }
}