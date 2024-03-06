package a2;

public class Wagon {

    /** Wagentyp */
    private final Type type;

    /** Vorgänger */
    private Wagon previous;

    /** Nachfolger */
    private Wagon next;

    /**
     * Erzeugt einen neuen Wagen eingehängt zwischen zwei andere Wagen.
     *
     * @param type     Art des Wagens.
     * @param previous Vorhergehender Wagen
     * @param next     Nachfolgender Wagen
     */
    public Wagon(Type type, Wagon previous, Wagon next) {
        this.type = type;
        this.previous = previous;
        this.next = next;
    }

    /**
     * Getter für den Typ des Wagens.
     *
     * @return Wagentyp
     */
    public Type getType() {
        return type;
    }

    /**
     * Getter vor den vorhergehenden Wagen.
     *
     * @return vorhergehenden Wagen
     */
    public Wagon getPrevious() {
        return previous;
    }

    /**
     * Setter für den vorhergehenden Wagen.
     *
     * @param previous neuer vorhergehender Wagen
     */
    public void setPrevious(Wagon previous) {
        this.previous = previous;
    }

    /**
     * Getter für den nachfolgenden Wagen.
     *
     * @return nachfolgender Wagen
     */
    public Wagon getNext() {
        return next;
    }

    /**
     * Setter für den vorhergehenden Wagen.
     *
     * @param next neuer nachfolgender Wagen
     */
    public void setNext(Wagon next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return type.name();
    }
}
