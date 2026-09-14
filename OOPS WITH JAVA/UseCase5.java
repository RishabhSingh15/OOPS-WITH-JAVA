class TicketCounter implements Runnable {

    private int availableTickets = 3;

    // synchronized method
    public synchronized void bookTicket() {

        if (availableTickets > 0) {
            availableTickets=availableTickets-1;
            System.out.println(Thread.currentThread().getName() +" booked Ticket No. " + availableTickets
            );

        } else {
            System.out.println(
                Thread.currentThread().getName() +
                " - No tickets available"
            );
        }
    }

    @Override
    public void run() {
        bookTicket();
    }
}

public class UseCase5 {
    public static void main(String[] args) {

        // One shared TicketCounter object
        TicketCounter counter = new TicketCounter();

        Thread t1 = new Thread(counter, "Counter-1");
        Thread t2 = new Thread(counter, "Counter-2");

        // Set t1 to maximum priority
        t1.setPriority(Thread.MAX_PRIORITY);

        // Start both threads
        t1.start();
        t2.start();
    }
}