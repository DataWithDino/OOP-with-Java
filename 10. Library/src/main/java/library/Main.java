package library;
import library.media.EBook;
import library.media.EBookFormat;
import library.media.Book;
import library.media.Game;
import library.media.IMedium;
public class Main {

    // Zum Testen den Blockkommentar entfernen
    public static void main(String[] args) {

        // Initialisierung der Medien
        IMedium book = new Book(1, "Harry Potter und der Halbblutprinz", "Joanne Rowling", "3551557462");
        IMedium eBook = new EBook(2, "Herr der Ringe", "J.R.R. Tolkien", "9783608939842", EBookFormat.EPUB);
        eBook.borrowMedium();
        IMedium game = new Game(3, "Die Siedler von Catan");

        // Aufbau der Bibliothek
        Library lib = new Library();
        lib.addMedia(book, eBook, game);
        System.out.println(lib.toString());
    }
     //

}
