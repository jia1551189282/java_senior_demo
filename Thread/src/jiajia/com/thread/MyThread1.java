package jiajia.com.thread;

/**
 * 通过实现 Runnable 接口的方式  创建线程
 */
public class MyThread1 implements  Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }

        }
    }
}
