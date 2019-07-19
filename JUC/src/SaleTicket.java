import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  1 多线程编写套路------上
 *  * 		1.1	线程		操作(实例方法)		资源类
 *  * 		1.2  高内聚  低耦合
 */
public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        /**
         * 1 匿名内部类的方式
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


       // 2 lamada 表达式的方式
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"AA").start();
        new Thread(() -> {for(int i = 0 ; i < 40 ; i++) ticket.sale();},"BB").start();
        new Thread(() -> {for(int i = 0 ; i < 40 ; i++) ticket.sale();},"CC").start();
    }
}
//资源类
class Ticket{
    private int number = 30;

    private Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if(number > 0){
                System.out.println(Thread.currentThread().getName()+"\t 卖出第:"+(number--)+"\t 还剩下: "+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}


//1 class MyThread implements Runnable

//2 匿名内部类

//3 lambda Express

