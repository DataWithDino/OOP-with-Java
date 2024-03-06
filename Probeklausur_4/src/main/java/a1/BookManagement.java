package a1;

import java.util.ArrayList;
import java.util.List;

public class BookManagement {

    /**
     * Containerklasse zur Verwaltung von Büchern.
     */
    private final List<Book> list = new ArrayList<>();

    /**
     * Fügt ein neues Buch zur Liste hinzu. Falls ein Book mit gleichem Titel und gleicher ISBN
     * bereits in der Liste vorhanden ist, passiert nichts. Dies ist unabhängig vom Zustand available.
     *
     * @param book Buch das neu in die Liste aufgenommen werden soll.
     * @return true, falls das Buch in der Liste aufgenommen wurde,
     *      false, falls es nicht aufgenommen werden konnte, da bereits vorhanden.
     * @throws NullPointerException falls book null ist.
     */
    public boolean addBook(Book book) {
        if(book==null){
            throw new NullPointerException("Buch darf nicht NULL sein!");
        }
        if(!list.contains(book)){
            list.add(book);
            return true;
        }
        return false;
    }

    /**
     * Löscht das Buch book aus der Liste, falls dort ein Buch mit gleicher ISBN und gleichem
     * Titel existiert. Der Zustand available spielt keine Rolle.
     *
     * @param book, Buch das aus der Liste gelöscht werden soll.
     * @return true, falls das Buch gelöscht werden konnte,
     *      false, falls in der Liste kein entsprechendes Buch gefunden wurde.
     * @throws NullPointerException falls book null ist.
     */
    public boolean removeBook(Book book) {
        if(book==null){
            throw new NullPointerException("Buch darf nicht NULL sein!");
        }
        if(list.contains(book)){
            list.remove(book);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
