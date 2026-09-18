import java.util.ArrayList;
import java.util.List;

// Class representing an individual ticket
class TicketItem {
    private String seatNumber;

    public TicketItem(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
}

// Manages available tickets with synchronization
class TicketBooking {
    private List<TicketItem> tickets;

    public TicketBooking() {
        tickets = new ArrayList<>();
        // Available tickets
        tickets.add(new TicketItem("Seat-101"));
        tickets.add(new TicketItem("Seat-102"));
        tickets.add(new TicketItem("Seat-103"));
        tickets.add(new TicketItem("Seat-104"));
    }

    // Synchronized to prevent double booking across threads
    public synchronized void bookTicket(String customerName) {
        if (!tickets.isEmpty()) {
            TicketItem booked = tickets.remove(0);
            System.out.println(customerName + " booked: " + booked.getSeatNumber());
        } else {
            System.out.println(customerName + " failed: House full.");
        }
    }
}

// Counter thread
class BookingCounter implements Runnable {
    private TicketBooking booking;
    private String customerName;

    public BookingCounter(TicketBooking booking, String customerName) {
        this.booking = booking;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        booking.bookTicket(customerName);
    }
}

// Matches your file name "ticket.java" so the run button works
public class ticket {
    public static void main(String[] args) throws InterruptedException {
        TicketBooking booking = new TicketBooking();

        Thread t1 = new Thread(new BookingCounter(booking, "Customer 1"));
        Thread t2 = new Thread(new BookingCounter(booking, "Customer 2"));
        Thread t3 = new Thread(new BookingCounter(booking, "Customer 3"));
        Thread t4 = new Thread(new BookingCounter(booking, "Customer 4"));
        Thread t5 = new Thread(new BookingCounter(booking, "Customer 5"));
        Thread t6 = new Thread(new BookingCounter(booking, "Customer 6"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
    }
}