import java.util.concurrent.CountDownLatch;

/**
 * Talk is cheap,show me your code
 *
 * @Description: CountDownLatch
 * @author zzyy
 * @date 2018��3��17��
 *��һЩ�߳�����ֱ����һЩ�߳����һϵ�в�����ű����ѡ�
 *
 * CountDownLatch��Ҫ��������������һ�������̵߳���await����ʱ����Щ�̻߳�������
 * �����̵߳���countDown�����Ὣ��������1(����countDown�������̲߳�������)��
 * ����������ֵ��Ϊ0ʱ����await�����������̻߳ᱻ���ѣ�����ִ�С�
 *
 * ���ͣ�5��ͬѧ½���뿪���Һ�ֵ��ͬѧ�ſ��Թ��š�
 * Ҳ��	����6����һͳ����
 * main���̱߳���Ҫ��ǰ��5���߳����ȫ���������Լ����ܿ���
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "������");
                countDownLatch.countDown();
            },CountryEnums.forEachCountEnums(i).getRetMsg()).start();
        }
        countDownLatch.await();

        System.out.println("����������ͳһ����");


    }
}
