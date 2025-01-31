class Book {
    String title;
    String author;
    double price;

    Book() {
        title = "The Alchemist";
        author = "Paulo Coelho";
        price = 299.99;
    }

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("Java Programming", "James Gosling", 499.99);

        System.out.println(book1.title + " by " + book1.author + " - $" + book1.price);
        System.out.println(book2.title + " by " + book2.author + " - $" + book2.price);
    }
}
