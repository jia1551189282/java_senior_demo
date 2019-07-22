import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *  * @Description: TODO(������һ�仰��������������)
 *  * @author zzyy
 *  * @date 2018��3��3��
 *  * CyclicBarrier
 *  * ��������˼�ǿ�ѭ����Cyclic��ʹ�õ����ϣ�Barrier������Ҫ���������ǣ�
 *  * ��һ���̵߳���һ�����ϣ�Ҳ���Խ�ͬ���㣩ʱ��������
 *  * ֱ�����һ���̵߳�������ʱ�����ϲŻῪ�ţ�����
 *  * ���������ص��̲߳Ż�����ɻ
 *  * �߳̽�������ͨ��CyclicBarrier��await()������
 *  *
 *  * ����7������Ϳ����ٻ�����
 */
public class CyclicBarrierDemo {
    private static final  Integer NUMBER = 7;
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER,() -> {
            System.out.println("================= �ٻ�����");
        });

        for (int i = 1; i <= 7; i++) {
            int tempInt = i;
            new Thread(() -> {
                System.out.println("�ռ���,��" + "\t " + tempInt + "������");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
