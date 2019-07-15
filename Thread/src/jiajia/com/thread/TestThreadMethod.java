package jiajia.com.thread;

public class TestThreadMethod extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i % 2 == 0){

                System.out.println(Thread.currentThread().getName() + ": " +  i );
            }

            if( 20 == 0){
                yield();  //释放CPU使用权
            }
        }
    }

    public TestThreadMethod(String threadName) {
        super(threadName);
    }
}
