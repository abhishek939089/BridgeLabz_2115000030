class Ticket {
    int ticketId;
    String customerName, movieName;
    int seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = this;
    }
}

class TicketReservation {
    Ticket head;

    void addTicket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            return;
        }
        Ticket temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newTicket;
        newTicket.next = head;
    }

    void displayTickets() {
        if (head == null) return;
        Ticket temp = head;
        do {
            System.out.println(temp.ticketId + " " + temp.customerName + " " + temp.movieName + " " + temp.seatNumber + " " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        TicketReservation system = new TicketReservation();
        system.addTicket(1, "Alice", "Inception", 5, "10:00 AM");
        system.addTicket(2, "Bob", "Interstellar", 8, "2:00 PM");
        system.displayTickets();
    }
}
