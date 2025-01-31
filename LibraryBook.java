class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;

    LibraryBook() {
        title = "Harry Potter";
        author = "J.K. Rowling";
        price = 699.99;
        available = true;
    }

    LibraryBook(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    void borrowBook() {
        if (available) available = false;
    }

    public static void main(String[] args) {
        LibraryBook libraryBook1 = new LibraryBook();
        LibraryBook libraryBook2 = new LibraryBook("Effective Java", "Joshua Bloch", 899.99, true);

        libraryBook1.borrowBook();

        System.out.println(libraryBook1.title + " - " + libraryBook1.author + " - " + (libraryBook1.available ? "Available" : "Borrowed"));
        System.out.println(libraryBook2.title + " - " + libraryBook2.author + " - " + (libraryBook2.available ? "Available" : "Borrowed"));
    }
}
