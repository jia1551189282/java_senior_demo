package jiajia.com.thread.callable;

import java.util.concurrent.Callable;

/**
 * �̴߳����ķ�ʽ��   ʵ��Callable�ӿ�
 * callable��ʽ���ŵ�
 * call���� ���������з���ֵ
 * call���� ���������׳��쳣�����沶��
 * callable֧�ַ���
 *
 */
public class CallableDemo implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100 ; i++) {
            sum = sum + i ;
        }
        return sum;
    }
}
