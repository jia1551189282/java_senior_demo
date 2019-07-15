package jiajia.com.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * callable 测试
 */
public class CallableTest {
    public static void main(String[] args) {
        // 创建实现callable接口的对象
        CallableDemo callableDemo  = new CallableDemo();
        // 将callable作为参数 传递到 futureTast 构造器中 ，创建 FutureTask对象
        FutureTask futureTask = new FutureTask(callableDemo);

        //将futureTask 当做参数传入到Thread构造函数中
        new Thread(futureTask).start(); // 开启线程
        // 获取到call（）方法的返回值
        try {
            // futureTask 的get（）方法的返回值 就是传入FutureTask 构造函数 中 callable实现类中重写的call（）方法的返回值
            Object sum = futureTask.get();
            System.out.println("实现的callable（）接口中重写call（）的返回值 ：" + sum );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
