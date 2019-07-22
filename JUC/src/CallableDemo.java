import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ͨ��ʵ��Callable�ӿ��������߳�
 *
 *
 *
 *  *
 *  *
 * �����߳�����Ҫִ�бȽϺ�ʱ�Ĳ���ʱ�����ֲ����������߳�ʱ�����԰���Щ��ҵ����Future�����ں�̨��ɣ�
 * �����߳̽�����Ҫʱ���Ϳ���ͨ��Future�����ú�̨��ҵ�ļ���������ִ��״̬��
 *
 * һ��FutureTask�����ں�ʱ�ļ��㣬���߳̿���������Լ����������ȥ��ȡ�����
 *
 * ���ڼ������ʱ���ܼ�����������������δ��ɣ������� get ������һ��������ɣ�
 * �Ͳ��������¿�ʼ��ȡ�����㡣get��������ȡ���ֻ���ڼ������ʱ��ȡ�������һֱ����ֱ������ת�����״̬��
 * Ȼ��᷵�ؽ�������׳��쳣��
 *
 * ֻ����һ��
 * get�����ŵ����
 *
 *  */

public class CallableDemo {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable() );
        new Thread(futureTask,"aaa").start();
        new Thread(futureTask,"bbb").start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    }



class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("callable ");
        return 1024;
    }
}

