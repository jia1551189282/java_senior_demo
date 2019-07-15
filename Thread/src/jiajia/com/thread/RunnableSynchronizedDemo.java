package jiajia.com.thread;

/**
 * ʵ��Runnable�ķ�ʽ  ��֤�̰߳�ȫ
 *
 */
public class RunnableSynchronizedDemo implements  Runnable {
    private int ticket  = 100 ;

    @Override
    public void run() {
        while(true){

            synchronized(this){ // ÿ�ζ���ͬһ��ʵ����Ķ�����Ϊ�������뵽Thread��   ����this��ʾ���ǵ�ǰ���� ͬʱҲ��ͬһ������   ���������������Ķ��󶼿���
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(ticket >  0 ){
                    System.out.println(Thread.currentThread().getName() +":����ƱΪ:" + ticket );
                    ticket -- ;

                }
            }
        }
    }
}
