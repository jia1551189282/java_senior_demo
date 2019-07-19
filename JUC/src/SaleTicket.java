import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  1 ���̱߳�д��·------��
 *  * 		1.1	�߳�		����(ʵ������)		��Դ��
 *  * 		1.2  ���ھ�  �����
 */
public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        /**
         * 1 �����ڲ���ķ�ʽ
         */
       /* new Thread(new Runnable() {
            @Override
            public void run()
            {
                for (int i = 1; i <=40; i++)
                {
                    ticket.sale();
                }
            }
        },"AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=40; i++)
                {
                    ticket.sale();
                }
            }
        },"BB").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=40; i++)
                {
                    ticket.sale();
                }
            }
        },"CC").start();*/


       // 2 lamada ���ʽ�ķ�ʽ
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"AA").start();
        new Thread(() -> {for(int i = 0 ; i < 40 ; i++) ticket.sale();},"BB").start();
        new Thread(() -> {for(int i = 0 ; i < 40 ; i++) ticket.sale();},"CC").start();
    }
}
//��Դ��
class Ticket{
    private int number = 30;

    private Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if(number > 0){
                System.out.println(Thread.currentThread().getName()+"\t ������:"+(number--)+"\t ��ʣ��: "+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}


//1 class MyThread implements Runnable

//2 �����ڲ���

//3 lambda Express

