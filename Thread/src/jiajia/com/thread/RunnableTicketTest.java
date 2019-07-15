package jiajia.com.thread;

public class RunnableTicketTest {
    public static void main(String[] args) {
        RunnableTicketDemo ticketTest = new RunnableTicketDemo();

        Thread thread = new Thread(ticketTest);

        Thread thread1 = new Thread(ticketTest);

        Thread thread2 =  new Thread(ticketTest);

        thread.start();
        thread1.start();
        thread2.start();

    }
}
