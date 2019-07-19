import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock �ķ�ʽ ��ʵ���߳�֮���ͨ��
 */
public class NotifyWaitDemo2 {
    public static void main(String[] args) {
        ShareData3 shareData  = new ShareData3();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        shareData.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        shareData.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"BB").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        shareData.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"CC").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        shareData.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"DD").start();
    }


}

class ShareData3{
    private int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try{
            // 1 �ж�
            while (number != 0){
                condition.await(); // �൱���� synchronized ����wait����
            }
            // 2 �ɻ�
            ++number;
            System.out.println(Thread.currentThread().getName() +"\t" + number );
            // 3 ֪ͨ
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try{
        // 1 �ж�
        while (number == 0){
            condition.await(); // �൱���� synchronized ����wait����
        }
        // 2 �ɻ�
        --number;
        System.out.println(Thread.currentThread().getName() +"\t" + number );
        // 3 ֪ͨ
        condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
