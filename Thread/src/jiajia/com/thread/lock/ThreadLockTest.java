package jiajia.com.thread.lock;

public class ThreadLockTest {
    public static void main(String[] args) {
        LockThreadDemo lockThreadDemo = new LockThreadDemo();

        Thread thread = new Thread(lockThreadDemo);
        Thread thread1 = new Thread(lockThreadDemo);
        Thread thread2 = new Thread(lockThreadDemo);

        thread.setName("����1");
        thread1.setName("����2");
        thread2.setName("����3");

        thread.start();
        thread1.start();
        thread2.start();


    }
}
