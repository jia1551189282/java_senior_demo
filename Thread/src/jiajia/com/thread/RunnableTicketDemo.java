package jiajia.com.thread;

/**
 * ʵ��Runnable�ӿ� ��ʵ����Ʊ�Ĺ���
 */
public class RunnableTicketDemo implements Runnable {

    private  int  ticket = 100 ;


    @Override
    public void run() {
        while (ticket > 0 ){
            System.out.println(Thread.currentThread().getName() + "����ƱΪ �� " + ticket);
            ticket -- ;
        }
    }
}
