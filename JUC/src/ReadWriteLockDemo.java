import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ¶ÁÐ´Ëø
 *
 * ÊµÏÖÐ´Ò»´Î ¶ÁÒ»Ç§´Î
 * 
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
            MyQueue myQueue = new MyQueue();
            
            new Thread(() ->{
                myQueue.Write("²âÊÔ¶ÁÐ´·ÖÀëËø");  
            },"write").start();
            
            new Thread(() ->{
                for (int i = 0; i < 1000; i++) {
                    myQueue.read();
                }
            },"BB").start();
    }
}

class MyQueue{
    private Object object;
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void Write(Object object){
        reentrantReadWriteLock.writeLock().lock();
        try {
            this.object = object;
            System.out.println(Thread.currentThread().getName() + "\t" + object);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public  void read(){
        reentrantReadWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t object: " + object);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}
