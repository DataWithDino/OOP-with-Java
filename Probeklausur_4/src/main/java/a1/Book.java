package a1;

import java.util.Objects;

public class Book {

    private final int isbn;
    private final String title;
    private boolean available = true;


    public Book(int isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public void switchAvailability() {
        this.available = !this.available;
    }
    public int getIsbn(){return isbn;}
    public String getTitle(){return title;}

    @Override
    public String toString() {
        return isbn + " " + title + " " + available;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Book book = (Book) object;
        return isbn == book.isbn && Objects.equals(title, book.title);
    }
    @Override
    public int hashCode(){
        return Objects.hash(isbn,title);
    }

}
