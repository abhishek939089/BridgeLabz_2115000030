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

    void addBookAtBeginning(int id, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(id, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newBook;
            return;
        }
        newBook.next = head;
        head.prev = newBook;
        head = newBook;
    }

    void addBookAtEnd(int id, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(id, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newBook;
            return;
        }
        tail.next = newBook;
        newBook.prev = tail;
        tail = newBook;
    }

    void addBookAtPosition(int id, String title, String author, String genre, boolean isAvailable, int position) {
        if (position <= 1) {
            addBookAtBeginning(id, title, author, genre, isAvailable);
            return;
        }
        Book newBook = new Book(id, title, author, genre, isAvailable);
        Book temp = head;
        int count = 1;
        while (temp.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        newBook.next = temp.next;
        newBook.prev = temp;
        if (temp.next != null) temp.next.prev = newBook;
        temp.next = newBook;
        if (newBook.next == null) tail = newBook;
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
        if (temp == tail) tail = temp.prev;
    }

    Book searchBookById(int id) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    Book searchBookByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) return temp;
            temp = temp.next;
        }
        return null;
    }

    void updateAvailability(int id, boolean status) {
        Book book = searchBookById(id);
        if (book != null) book.isAvailable = status;
    }

    void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.id + " " + temp.title + " " + temp.author + " " + temp.isAvailable);
            temp = temp.next;
        }
    }

    void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.id + " " + temp.title + " " + temp.author + " " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.addBookAtEnd(1, "Harry Potter", "J.K. Rowling", "Fantasy", true);
        library.addBookAtEnd(2, "The Hobbit", "J.R.R. Tolkien", "Adventure", false);
        library.displayBooksForward();
        library.removeBook(1);
        library.displayBooksForward();
    }
}
