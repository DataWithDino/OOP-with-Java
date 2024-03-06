package bank.utility;

/**
 * Generator für eindeutige Kontonummern.
 */
public class NumberGenerator {

    private static final int SEED = 1000;

    /**
     * Nächste verfügbare Kontonummer.
     */
    private int counter = SEED;

    /**
     * Liefert die nächste Kontonummer.
     * Zählt die Kontonummer um eins hoch.
     *
     * @return nächste verfügbare Kontonummer.
     */
    public int next() {
        return counter++;
    }

    /**
     * Setzt den Startwert für die Kontonummern
     * wieder zurück.
     */
    public void reset() {
        counter = SEED;
    }

    /**
     * Liefert die nächste verfügbare Kontonummer.
     * Verändert die Kontonummer nicht.
     *
     * @return nächste verfügbare Kontonummer.
     */
    public int current() {
        return counter;
    }
}
