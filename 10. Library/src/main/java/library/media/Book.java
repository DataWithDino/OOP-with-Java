package library.media;

public class Book extends Medium{
    private final String author;
    private final String isbn;

    public Book(int id, String title,  String author, String isbn) {
        super(id, title);
        this.author=author;
        this.isbn=isbn;
    }
    @Override
    public String toString() {
        return String.format(super.toString() + ", " + author + ", " + isbn);
    }
}
