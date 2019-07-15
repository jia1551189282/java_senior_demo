package jiajia.com.thread;

/**
 * 实现Runnable的方式  保证线程安全
 *
 */
public class RunnableSynchronizedDemo implements  Runnable {
    private int ticket  = 100 ;

    @Override
    public void run() {
        while(true){

            synchronized(this){ // 每次都是同一个实现类的对象作为参数放入到Thread中   所以this表示的是当前对象 同时也是同一个对象   这里可以声明任意的对象都可以
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(ticket >  0 ){
                    System.out.println(Thread.currentThread().getName() +":卖的票为:" + ticket );
                    ticket -- ;

                }
            }
        }
    }
}
