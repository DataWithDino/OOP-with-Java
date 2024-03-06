package library;

import library.media.IMedium;
import java.util.ArrayList;
import java.util.List;

public class Library implements ILibrary{

    private final List<IMedium> media = new ArrayList<>();

    /**
     * Liefert eine Stringrepräsentation des aktuellen Bestands in der Bibliothek, d.h. es
     * werden die Stringrepräsentationen zu allen vorhandenen Medien ausgegeben.
     *
     * Die Werte werden in folgender Reihenfolge ausgegeben:
     *  Bei Büchern: Id, aktueller Ausleihzustand, ISBN Nummer, Autor, Titel
     *  Bei EBooks: Id, aktueller Ausleihzustand, ISBN Nummer, Autor, Titel, Format
     *  Bei Spielen: Id, aktueller Ausleihzustand, Titel
     *
     *  Beispiele:
     *  1, false, Harry Potter und der Halbblutprinz, Joanne Rowling, 3551557462
     *  2, true, Herr der Ringe, J.R.R. Tolkien, 9783608939842, EPUB
     *  3, false, Die Siedler von Catan
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < media.size(); i++) {
            result += String.format("%s%n", media.get(i).toString());
        }
        // Alternative Schleife
//        for (IMedium next: media) {
//            result += String.format("%s%n", next.toString());
//        }
        return result;
    }

    @Override
    public boolean addMedium(IMedium medium) {
        if(medium==null){
            return false;
        }
        media.add(medium);
        return  true;
    }

    @Override
    public IMedium removeMedium(int id) {
        for(IMedium medium : media){
            if (medium.getId() == id){
                media.remove(medium);
                return medium;
            }
        }
        return null;
    }

}
