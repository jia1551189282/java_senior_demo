package jiajia.com.thread.threadpoll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 测试 通过线程池的方式创建线程
 * 线程池的好处
 *      1 提高反应速度 减少创建新线程的速度
 *      2 减少资源的消耗 重复的利用线程池中的线程，不用每次都创建线程
 *      3 便于线程的管理
 *
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService; //转换成线程池执行对象

        // 设置线程池有关的操作
        threadPoolExecutor.setCorePoolSize(17); //设置线程池的大小
        // threadPoolExecutor.setKeepAliveTime();  设置线程没有操作的时间就回收
        //执行指定的线程   需要提供实现Runnable接口 或者 Callable 接口的实现类
        threadPoolExecutor.execute(new ThreadPoolDemo());
        threadPoolExecutor.execute(new ThreadPoolDemo1());

        //关闭数据库连接池
        threadPoolExecutor.shutdown();

    }
}
