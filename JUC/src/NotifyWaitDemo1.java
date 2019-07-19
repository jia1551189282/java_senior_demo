/**
 *  *
 *  * @Description:
 *  * ���������̣߳�
 *  * ���Բ�����ʼֵΪ���һ��������
 *  * ʵ��һ���̶߳Ըñ�����1��һ���̶߳Ըñ�����1��
 *  * ���棬��10�֣�������ʼֵΪ�㡣
 *  * @author zzyy
 *  * @date 2018��3��15��
 *  * 1 ���̱߳�д��·------��
 *  * 		1.1	�߳�		����(ʵ������)		��Դ��
 *  * 		1.2  ���ھ�  �����
 *  *
 *  * 2 ���̱߳�д��·------��
 *  * 		2.1 �ж�
 *  * 		2.2 �ɻ�
 *  * 		2.3 ֪ͨ
 *
 *
 *  �������ĸ��̵߳Ļ��ͻ�����⣬��ٻ���
 *  ���߳�֮���ͨ�� ���ж�����Ҫ��while ���ж�����  �鿴object�ж� notify������
 *
 *
 */
public class NotifyWaitDemo1 {
    public static void main(String[] args) {
        ShareData1 shareData = new ShareData1();
        new Thread(() -> {
            for (int i = 1;i <= 10; i++){
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"AA").start();
        new Thread(() -> {
            for (int i = 1; i<=10 ;i++){
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
        new Thread(() -> {
            for (int i = 1;i <= 10; i++){
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"CC").start();
        new Thread(() -> {
            for (int i = 1; i<=10 ;i++){
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }
}

/**
 * �ȴ�  ֪ͨ ����
 */
class ShareData{
    private int number = 0 ;

    public synchronized  void increment() throws InterruptedException {
        // 1 �ж�
        if(number != 0){
            this.wait(); // �ȴ�������
        }
        // 2 �ɻ�
        ++number ;
        System.out.println(Thread.currentThread().getName() +  "\t" + number);
        // 3 ֪ͨ
        notifyAll();
    }


    public synchronized void decrement() throws InterruptedException {
        // 1 �ж�
        if(number == 0){
            this.wait();
        }
        // 2 �ɻ�
        --number ;
        System.out.println(Thread.currentThread().getName() +  "\t" + number);
        // 3 ֪ͨ
        notifyAll();
    }
}


/**
 * �ȴ�  ֪ͨ ����
 */
class ShareData1{
    private int number = 0 ;

    public synchronized  void increment() throws InterruptedException {
        // 1 �ж�
        while (number != 0){
            this.wait(); // �ȴ�������
        }
        // 2 �ɻ�
        ++number ;
        System.out.println(Thread.currentThread().getName() +  "\t" + number);
        // 3 ֪ͨ
        notifyAll();
    }


    public synchronized void decrement() throws InterruptedException {
        // 1 �ж�
        while(number == 0){
            this.wait();
        }
        // 2 �ɻ�
        --number ;
        System.out.println(Thread.currentThread().getName() +  "\t" + number);
        // 3 ֪ͨ
        notifyAll();
    }
}
