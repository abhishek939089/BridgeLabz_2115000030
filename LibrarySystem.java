import java.util.ArrayList;
import java.util.List;

class Book {
    String title, author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class Library {
    String name;
    List<Book> books;

    Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void displayBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            System.out.println("Book: " + book.title + ", Author: " + book.author);
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library lib1 = new Library("City Library");
        Library lib2 = new Library("University Library");

        Book book1 = new Book("Java Programming", "John Doe");
        Book book2 = new Book("Data Structures", "Jane Smith");

        lib1.addBook(book1);
        lib2.addBook(book2);

        lib1.displayBooks();
        lib2.displayBooks();
    }
}
