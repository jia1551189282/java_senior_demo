package jiajia.com.thread;

import org.junit.Test;

/**
 * jdk5 之前创建线程的两种方式
 * 同一个线程不能多次被start  要重新开一个线程
 *
 */
public class TestThread {
    @Test
    public void test1(){
            // 创建线程对象   并开启线程   会去运行run()方法
            MyThread myThread = new MyThread();
            myThread.start();

            MyThread myThread1 = new MyThread();
            myThread1.start();

        System.out.println("==============");
        for (int i = 0; i < 100 ; i++) {
            System.out.println(Thread.currentThread().getName() + " test中的线程 : " + i );
        }
    }
    @Test
    public void test2(){
        TestThreadMethod testThreadMethod = new TestThreadMethod("测试线程");

        //设置线程名字
         testThreadMethod.setName("线程1");

        testThreadMethod.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }

    }

    public static void main(String[] args) {
        TestThreadMethod testThreadMethod = new TestThreadMethod("测试线程");
        testThreadMethod.setName("线程1");
        testThreadMethod.setPriority(Thread.MAX_PRIORITY);
        testThreadMethod.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0 ; i < 100 ; i++) {
            if( i % 2 == 0){

                System.out.println(Thread.currentThread().getName()  + " : " + i);
            }
            if( i  == 20){
                try {
                    testThreadMethod.join();   //加入到testThreadMethod 线程释放cpu的地方
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
