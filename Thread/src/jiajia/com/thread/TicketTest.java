package jiajia.com.thread;

public class TicketTest {

    public static void main(String[] args) {
        TicketDemo ticketDemo = new TicketDemo();
        TicketDemo ticketDemo1 = new TicketDemo();
        TicketDemo ticketDemo2 = new TicketDemo();

        ticketDemo.setName("����1");
        ticketDemo1.setName("����2");
        ticketDemo2.setName("����3");

        ticketDemo.start();
        ticketDemo1.start();
        ticketDemo2.start();

    }
}
