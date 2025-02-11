class Ticket {
    int ticketId;
    String customerName, movieName;
    int seatNumber, bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, int seatNumber, int bookingTime) {
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

    void addTicket(int ticketId, String customerName, String movieName, int seatNumber, int bookingTime) {
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

    void removeTicket(int ticketId) {
        if (head == null) return;
        if (head.ticketId == ticketId && head.next == head) {
            head = null;
            return;
        }
        Ticket temp = head, prev = null;
        do {
            if (temp.ticketId == ticketId) {
                if (prev != null) prev.next = temp.next;
                else head = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void displayTickets() {
        if (head == null) return;
        Ticket temp = head;
        do {
            System.out.println(temp.ticketId + " " + temp.customerName + " " + temp.movieName + " " + temp.seatNumber + " " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public static void main(String[] args) {
        TicketReservation system = new TicketReservation();
        system.addTicket(1, "Alice", "Inception", 5, 1000);
        system.addTicket(2, "Bob", "Interstellar", 8, 1400);
        system.displayTickets();
        System.out.println("Total Tickets: " + system.countTickets());
        system.removeTicket(1);
        system.displayTickets();
        System.out.println("Total Tickets: " + system.countTickets());
    }
}
