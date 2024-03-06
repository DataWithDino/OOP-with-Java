package a3;

/**
 * Interface für Songs (Liedtexte).
 */
public interface ISong {

    /**
     * Liefert die Zeile eines Liedtextes am Index index.
     *
     * @param index Index der Zeile (0 = erste Zeile).
     * @return Zeile am Index oder null nach der letzten Zeile.
     * @throws IndexOutOfBoundsException falls der Index negativ ist.
     */
    Line getLine(int index);

    /**
     * Liefert den Refrain des Lieds, der jeweils die letzte Zeile einer Strophe markiert.
     *
     * @return Refrain des Lieds.
     */
    default Line getRefrain(){
        return getLine(length()-1);
    }

    /**
     * Liefert die Länge des Liedtextes (entspricht Gesamtanzahl der Zeilen).
     *
     * @return Anzahl aller Zeilen des Lieds.
     */
    int length();

    /**
     * Liefert die Anzahl der Strophen des Lieds.
     * Strophen können unterschiedlich lang sein, aber
     * jede Strophe endet mit der gleichen Zeile, dem Refrain.
     *
     * @return Anzahl der Strophen des Lieds.
     */
    int numberOfStrophes();

}
