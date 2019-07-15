package jiajia.com.thread.lock;

public class ThreadLockTest {
    public static void main(String[] args) {
        LockThreadDemo lockThreadDemo = new LockThreadDemo();

        Thread thread = new Thread(lockThreadDemo);
        Thread thread1 = new Thread(lockThreadDemo);
        Thread thread2 = new Thread(lockThreadDemo);

        thread.setName("´°¿Ú1");
        thread1.setName("´°¿Ú2");
        thread2.setName("´°¿Ú3");

        thread.start();
        thread1.start();
        thread2.start();


    }
}
