class Book {
    String title, author, genre;
    int id;
    boolean isAvailable;
    Book prev, next;

    Book(int id, String title, String author, String genre, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.prev = this.next = null;
    }
}

class Library {
    Book head, tail;

    void addBook(int id, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(id, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newBook;
            return;
        }
        tail.next = newBook;
        newBook.prev = tail;
        tail = newBook;
    }

    void removeBook(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            if (head != null) head.prev = null;
            return;
        }
        Book temp = head;
        while (temp != null && temp.id != id) temp = temp.next;
        if (temp == null) return;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
    }

    void displayBooks() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.id + " " + temp.title + " " + temp.author + " " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(1, "Harry Potter", "J.K. Rowling", "Fantasy", true);
        library.addBook(2, "The Hobbit", "J.R.R. Tolkien", "Adventure", false);
        library.displayBooks();
        library.removeBook(1);
        library.displayBooks();
    }
}
