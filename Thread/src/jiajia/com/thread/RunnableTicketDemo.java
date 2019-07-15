package jiajia.com.thread;

/**
 * 实现Runnable接口 来实现卖票的功能
 */
public class RunnableTicketDemo implements Runnable {

    private  int  ticket = 100 ;


    @Override
    public void run() {
        while (ticket > 0 ){
            System.out.println(Thread.currentThread().getName() + "卖的票为 ： " + ticket);
            ticket -- ;
        }
    }
}
