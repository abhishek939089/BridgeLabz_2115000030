class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    HotelBooking() {
        guestName = "Default Guest";
        roomType = "Standard";
        nights = 2;
    }

    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public static void main(String[] args) {
        HotelBooking booking1 = new HotelBooking();
        HotelBooking booking2 = new HotelBooking("John", "Deluxe", 3);
        HotelBooking booking3 = new HotelBooking(booking2);

        System.out.println(booking1.guestName + " - " + booking1.roomType + " - " + booking1.nights);
        System.out.println(booking2.guestName + " - " + booking2.roomType + " - " + booking2.nights);
        System.out.println(booking3.guestName + " - " + booking3.roomType + " - " + booking3.nights);
    }
}
