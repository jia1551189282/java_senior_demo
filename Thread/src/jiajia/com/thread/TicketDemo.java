package jiajia.com.thread;

/**
 * �̳� Thread�ķ�ʽ ��Ʊ
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
            System.out.println("��ǰ������ ��" + Thread.currentThread().getName() + "Ʊ��Ϊ��" + ticket);
            ticket -- ;
        }
    }
}
