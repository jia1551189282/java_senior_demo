package jiajia.com.thread;

/**
 * ͬ������� �����Ʊ���̲߳���ȫ����
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
            synchronized (obj){  //Ҫ��֤����̳߳��еĶ�����ͬһ�������¿���  Ҫ��Ȼ���ǲ�ͬ����   ���ܱ�֤�̰߳�ȫ  ����Ҳ����ʹ�� ��ǰ���class������Ϊ
                // synchronized �ĳ��ж���
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + ":��ƱΪ��" + ticket);
                    ticket -- ;
                }
            }
        }


    }
}
