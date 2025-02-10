abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    abstract int getLoanDuration();
}

class Book extends LibraryItem {
    Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    int getLoanDuration() {
        return 14;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryItem book = new Book(101, "Java Programming", "Herbert Schildt");
        System.out.println("Loan Duration: " + book.getLoanDuration() + " days");
    }
}
