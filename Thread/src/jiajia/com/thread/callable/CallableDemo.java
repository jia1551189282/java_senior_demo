package jiajia.com.thread.callable;

import java.util.concurrent.Callable;

/**
 * 线程创建的方式三   实现Callable接口
 * callable方式的优点
 * call（） 方法可以有返回值
 * call（） 方法可以抛出异常别外面捕获到
 * callable支持泛型
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
