package jiajia.com.thread.threadpoll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ���� ͨ���̳߳صķ�ʽ�����߳�
 * �̳߳صĺô�
 *      1 ��߷�Ӧ�ٶ� ���ٴ������̵߳��ٶ�
 *      2 ������Դ������ �ظ��������̳߳��е��̣߳�����ÿ�ζ������߳�
 *      3 �����̵߳Ĺ���
 *
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // �ṩָ���߳��������̳߳�
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService; //ת�����̳߳�ִ�ж���

        // �����̳߳��йصĲ���
        threadPoolExecutor.setCorePoolSize(17); //�����̳߳صĴ�С
        // threadPoolExecutor.setKeepAliveTime();  �����߳�û�в�����ʱ��ͻ���
        //ִ��ָ�����߳�   ��Ҫ�ṩʵ��Runnable�ӿ� ���� Callable �ӿڵ�ʵ����
        threadPoolExecutor.execute(new ThreadPoolDemo());
        threadPoolExecutor.execute(new ThreadPoolDemo1());

        //�ر����ݿ����ӳ�
        threadPoolExecutor.shutdown();

    }
}
