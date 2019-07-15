package jiajia.com.thread;

/**
 * 同步代码块 解决卖票的线程不安全问题
 *
 */
public class ThreadSynchronizedDemo extends  Thread {
    private static int ticket  =100 ;
    static Object obj  = new Object(); //

    @Override
    public void run() {

        while (true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj){  //要保证多个线程持有的对象是同一个对象下可以  要不然就是不同的锁   不能保证线程安全  这里也可以使用 当前类的class对象作为
                // synchronized 的持有对象
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + ":卖票为：" + ticket);
                    ticket -- ;
                }
            }
        }


    }
}
