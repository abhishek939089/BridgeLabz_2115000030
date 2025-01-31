class BookDetails {
    public String ISBN;
    protected String title;
    private String author;

    BookDetails(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public static void main(String[] args) {
        EBook eBook = new EBook("123-456", "Java Programming", "John Doe", 2.5);
        eBook.displayBookDetails();
        System.out.println("File Size: " + eBook.fileSize + "MB");
    }
}

class EBook extends BookDetails {
    double fileSize;

    EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    @Override
    void displayBookDetails() {
        super.displayBookDetails();
    }
}
