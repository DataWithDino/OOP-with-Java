package a2;

/**
 * Klasse für Listenelemente.
 */
public class Element {

    /**
     * unveränderlicher Wert des Listenelements
     */
    private final int value;

    /**
     * Referenz auf das nächste Listenelement
     */
    private Element next;

    /**
     * Referenz auf das vorhergehende Listenelement
     */
    private Element previous;

    /**
     * Custom-Konstruktor. Setzt den Wert des Listenelements.
     *
     * @param value Wert für das Listenelement
     */
    public Element(int value) {
        this.value = value;
    }

    /**
     * Custom-Konstruktor. Setzt Wert, Vorgänger und Nachfolger des Listenelements.
     *
     * @param value    Wert für das Listenelement
     * @param previous Vorgänger des Listenelements
     * @param next     Nachfolger des Listenelements
     */
    public Element(int value, Element previous, Element next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    /**
     * Getter für den Wert.
     *
     * @return Wert des Listenelements
     */
    public int getValue() {
        return value;
    }

    /**
     * Getter für den Nachfolger des Listenelements.
     *
     * @return Nachfolger des Listenelements
     */
    public Element getNext() {
        return next;
    }

    /**
     * Setzt den Nachfolger des Listenelements.
     * @param next Neuer Nachfolger des Listenelements
     */
    public void setNext(Element next) {
        this.next = next;
    }

    /**
     * Getter für den Vorgänger des Listenelements.
     *
     * @return Vorgänger des Listenelements
     */
    public Element getPrevious() {
        return previous;
    }

    /**
     * Setzt den Vorgänger des Listenelements.
     * @param previous Neuer Vorgänger des Listenelements
     */
    public void setPrevious(Element previous) {
        this.previous = previous;
    }
}
