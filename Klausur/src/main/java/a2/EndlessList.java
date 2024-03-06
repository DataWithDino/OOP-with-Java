package a2;

import java.util.ArrayList;
import java.util.List;

public class EndlessList {

    /**
     * Erstes Listenelement
     */
    private Element first;

    /**
     * Letztes Listenelement
     */
    private Element last;

    /**
     * Fügt ein neues Listenelement mit dem Wert value zwischen dem ersten und dem letzten Listenelement ein.
     * Das neue Element wird damit das aktuell letzte Listenelement.
     *
     * @param value Wert des neuen Listenelements
     */
    public void addValue(int value) {
        Element newElement = new Element(value);
        if (isEmpty()) {
            first = newElement;
            last = newElement;
            newElement.setNext(newElement);
            newElement.setPrevious(newElement);
        }else {
            newElement.setPrevious(last);
            newElement.setNext(first);
            first.setPrevious(newElement);
            last.setNext(newElement);
            last = newElement;
        }
    }

    /**
     * Durchläuft die Liste times Mal im Uhrzeigersinn und gibt die Werte aus.
     * Der Start ist immer beim ersten Element (first).
     *
     * @param times Anzahl der Durchläufe
     * @return Liste der Werte
     */
    public List<Integer> traverseForward(int times) {
        List<Integer> list = new ArrayList<>();
        if (!isEmpty()) {
            for (int i = 0; i < times; i++) {
                Element current = first;
                list.add(current.getValue());
                while (current.getNext() != null && current.getNext() != first) {
                    current = current.getNext();
                    list.add(current.getValue());
                }
            }
        }
        return list;
    }

    /**
     * Durchläuft die Liste times Mal gegen den Uhrzeigersinn und gibt die Werte aus.
     * Der Start ist immer beim ersten Element (first).
     *
     * @param times Anzahl der Durchläufe
     * @return Liste der Werte
     */
    public List<Integer> traverseBackward(int times) {
        List<Integer> list = new ArrayList<>();
        if (!isEmpty()) {
            for (int i = 0; i < times; i++) {
                Element current = last;
                list.add(current.getValue());
                while (current.getPrevious() != null && current.getPrevious() != last) {
                    current = current.getPrevious();
                    list.add(current.getValue());}
            }
        }
        return list;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
