import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * ģ��ͣ��λ
 *
 *
 *  * ���ź��������Ƕ������ֲ�����
 *  * acquire����ȡ�� ��һ���̵߳���acquire����ʱ����Ҫôͨ���ɹ���ȡ�ź������ź�����1����
 *  * 					Ҫôһֱ����ȥ��ֱ�����߳��ͷ��ź�������ʱ��
 *  * release���ͷţ�ʵ���ϻὫ�ź�����ֵ��1��Ȼ���ѵȴ����̡߳�
 *  *
 *  * �ź�����Ҫ��������Ŀ�ģ�һ�������ڶ��������Դ�Ļ���ʹ�ã���һ�����ڲ����߳����Ŀ��ơ�
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4); // ģ��������λ

        for (int i = 1; i <= 6 ; i++) {  // 6����λ
            int tempInt = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+ tempInt +"�ų���������λ");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(8));
                    System.out.println(Thread.currentThread().getName() + "\t" +tempInt + "�ų����뿪");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
