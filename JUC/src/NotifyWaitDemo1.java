/**
 *  *
 *  * @Description:
 *  * 现在两个线程，
 *  * 可以操作初始值为零的一个变量，
 *  * 实现一个线程对该变量加1，一个线程对该变量减1，
 *  * 交替，来10轮，变量初始值为零。
 *  * @author zzyy
 *  * @date 2018年3月15日
 *  * 1 多线程编写套路------上
 *  * 		1.1	线程		操作(实例方法)		资源类
 *  * 		1.2  高内聚  低耦合
 *  *
 *  * 2 多线程编写套路------下
 *  * 		2.1 判断
 *  * 		2.2 干活
 *  * 		2.3 通知
 *
 *
 *  这里是四个线程的话就会出问题，虚假唤醒
 *  多线程之间的通信 ，判断条件要用while 来判断条件  查看object中对 notify的描叙
 *
 *
 */
public class NotifyWaitDemo1 {
    public static void main(String[] args) {
        ShareData1 shareData = new ShareData1();
        new Thread(() -> {
            for (int i = 1;i <= 10; i++){
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"AA").start();
        new Thread(() -> {
            for (int i = 1; i<=10 ;i++){
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
        new Thread(() -> {
            for (int i = 1;i <= 10; i++){
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"CC").start();
        new Thread(() -> {
            for (int i = 1; i<=10 ;i++){
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }
}

/**
 * 等待  通知 唤醒
 */
class ShareData{
    private int number = 0 ;

    public synchronized  void increment() throws InterruptedException {
        // 1 判断
        if(number != 0){
            this.wait(); // 等待被唤醒
        }
        // 2 干活
        ++number ;
        System.out.println(Thread.currentThread().getName() +  "\t" + number);
        // 3 通知
        notifyAll();
    }


    public synchronized void decrement() throws InterruptedException {
        // 1 判断
        if(number == 0){
            this.wait();
        }
        // 2 干活
        --number ;
        System.out.println(Thread.currentThread().getName() +  "\t" + number);
        // 3 通知
        notifyAll();
    }
}


/**
 * 等待  通知 唤醒
 */
class ShareData1{
    private int number = 0 ;

    public synchronized  void increment() throws InterruptedException {
        // 1 判断
        while (number != 0){
            this.wait(); // 等待被唤醒
        }
        // 2 干活
        ++number ;
        System.out.println(Thread.currentThread().getName() +  "\t" + number);
        // 3 通知
        notifyAll();
    }


    public synchronized void decrement() throws InterruptedException {
        // 1 判断
        while(number == 0){
            this.wait();
        }
        // 2 干活
        --number ;
        System.out.println(Thread.currentThread().getName() +  "\t" + number);
        // 3 通知
        notifyAll();
    }
}
