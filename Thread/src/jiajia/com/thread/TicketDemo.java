package jiajia.com.thread;

/**
 * 继承 Thread的方式 卖票
 */
public class TicketDemo extends Thread {
    private static int ticket = 100;
    @Override
    public void run() {
        while (ticket > 0 ){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前窗口是 ：" + Thread.currentThread().getName() + "票号为：" + ticket);
            ticket -- ;
        }
    }
}
