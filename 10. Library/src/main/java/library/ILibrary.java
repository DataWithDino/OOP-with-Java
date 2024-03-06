package library;

import library.media.IMedium;

public interface ILibrary {

    /**
     * Fügt der Bibliothek an der aktuell ersten freien Stelle innerhalb der Liste ein neues Medium hinzu.
     * Medien dürfen auch mehrfach enthalten sein. Falls das Medium null ist, wird es nicht hinzugefügt.
     *
     * @param medium zum Hinzufügen
     * @return true, falls das Medium erfolgreich hinzugefügt wurde, false falls das Medium null ist.
     */
    boolean addMedium(IMedium medium);

    /**
     * Entfernt das Medium mit dem gesuchten Identifikator aus der Bibliothek.
     *
     * @param id Identifikator des gesuchten Mediums
     * @return Das gesuchte Medium oder null, falls kein Medium mit dieser id gefunden werden konnte.
     */
    IMedium removeMedium(int id);


    /**
     * Fügt alle Medien der Liste newMedia dieser Bibliothek hinzu.
     * Medien die null sind, werden ausgefiltert,
     *
     * @param newMedia Liste von neuen Medien zum Hinzufügen.
     */
    default void addMedia(IMedium... newMedia) {
        for(IMedium medium : newMedia){
            if(medium!=null){
                addMedium(medium);
            }
        }
    }
    /**
     * Löscht alle Medien mit den IDs in der Liste ids aus dieser Bibliothek.
     *
     * @param ids Liste von neuen Medien zum Löschen.
     *            Ids, die nicht existieren, werden ignoriert (es passiert nichts).
     */
    default void removeMedia(int... ids) {
        for(int x : ids){
            if(removeMedium(x)!=null){
                removeMedium(x);
            }

        }
    }
}
