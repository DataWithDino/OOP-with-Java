package a1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagementTest {

    private BookManagement sm;

    @BeforeEach
    void init() {
        sm = new BookManagement();
        sm.addBook(new Book(567890, "Analysis"));
        sm.addBook(new Book(567891, "Diskrete Strukturen"));
        sm.addBook(new Book(567892, "Lineare Algebra"));
    }

    @Test
    void addBook1() {
        // Kein Einfluss der Availability
        BookManagement bm = new BookManagement();
        // Buch darf einmal aufgenommen werden
        Book book1 = new Book(567890, "Lineare Algebra");
        Assertions.assertTrue(bm.addBook(book1));
        // Buch mit gleichen Daten darf nicht noch einmal aufgenommen werden
        Book book2 = new Book(567890, "Lineare Algebra");
        Assertions.assertFalse(bm.addBook(book2));
        // Dies ist unabhängig von der Verfügbarkeit
        Book book3 = new Book(567890, "Lineare Algebra");
        book3.switchAvailability();
        Assertions.assertFalse(bm.addBook(book3));
        // Es sollte nur ein Buch enthalten sein
        Assertions.assertEquals("[567890 Lineare Algebra true]", bm.toString());
    }

    @Test
    void addBook2() {
        BookManagement sm = new BookManagement();
        sm.addBook(new Book(567890, "Lineare Algebra"));
        // Neues Buch mit gleicher ISBN aber anderem Titel einfügen.
        Assertions.assertTrue(sm.addBook(new Book(567890, "Analysis")));
        Assertions.assertEquals("[567890 Lineare Algebra true, 567890 Analysis true]", sm.toString());
    }

    @Test
    void addBook3() {
        BookManagement sm = new BookManagement();
        sm.addBook(new Book(567891, "Analysis"));
        sm.addBook(new Book(567890, "Lineare Algebra"));
        // Neues Buch mit anderer ISBN aber gleichem Titel einfügen.
        Assertions.assertTrue(sm.addBook(new Book(8765534, "Analysis")));
        Assertions.assertEquals("[567891 Analysis true, 567890 Lineare Algebra true, 8765534 Analysis true]", sm.toString());
    }


    @Test
    void addBook4() {
        // Neues Buch mit gleichen Daten einfügen.
        Assertions.assertFalse(sm.addBook(new Book(567891, "Diskrete Strukturen")));
        Assertions.assertEquals("[567890 Analysis true, 567891 Diskrete Strukturen true, 567892 Lineare Algebra true]", sm.toString());
    }

    @Test
    void addBook5() {
        BookManagement sm = new BookManagement();
        Assertions.assertThrows(NullPointerException.class, () -> sm.addBook(null));
    }

    @Test
    void removeBook1() {
        // Buch mit gleichen Daten löschen
        Assertions.assertTrue(sm.removeBook(new Book(567891, "Diskrete Strukturen")));
        Assertions.assertEquals("[567890 Analysis true, 567892 Lineare Algebra true]", sm.toString());
    }

    @Test
    void removeBook2() {
        // Nicht existierendes Buch mit gleicher ISBN aber anderem Titel löschen.
        Assertions.assertFalse(sm.removeBook(new Book(567891, "Analysis Band 2")));
        Assertions.assertEquals("[567890 Analysis true, 567891 Diskrete Strukturen true, 567892 Lineare Algebra true]", sm.toString());
    }

    @Test
    void removeBook3() {
        BookManagement sm = new BookManagement();
        Assertions.assertThrows(NullPointerException.class, () -> sm.removeBook(null));
    }

}