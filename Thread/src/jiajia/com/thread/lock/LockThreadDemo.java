package jiajia.com.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ���Ļ�����������Ʊ���̰߳�ȫ����
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
                    System.out.println(Thread.currentThread().getName() + ":��ǰ��ƱΪ �� " + ticket);
                    ticket--;

                }
            }finally {
                reentrantLock.unlock();  //�ͷ���
            }

        }
    }
}
