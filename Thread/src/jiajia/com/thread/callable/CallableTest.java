package jiajia.com.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * callable ����
 */
public class CallableTest {
    public static void main(String[] args) {
        // ����ʵ��callable�ӿڵĶ���
        CallableDemo callableDemo  = new CallableDemo();
        // ��callable��Ϊ���� ���ݵ� futureTast �������� ������ FutureTask����
        FutureTask futureTask = new FutureTask(callableDemo);

        //��futureTask �����������뵽Thread���캯����
        new Thread(futureTask).start(); // �����߳�
        // ��ȡ��call���������ķ���ֵ
        try {
            // futureTask ��get���������ķ���ֵ ���Ǵ���FutureTask ���캯�� �� callableʵ��������д��call���������ķ���ֵ
            Object sum = futureTask.get();
            System.out.println("ʵ�ֵ�callable�����ӿ�����дcall�����ķ���ֵ ��" + sum );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
