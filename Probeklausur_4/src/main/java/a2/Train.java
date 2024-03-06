package a2;

enum Type {ENGINE, FIRST, SECOND, BISTRO}

public class Train {

    /** Referenz auf die Lok */
    private final Wagon engine;

    /** Referenz auf Bistrowagen */
    private final Wagon bistro;

    /**
     * Custom-Kontruktor: Aufbau eines neuen Zuges bestehend aus Lok und Bistrowagen.
     */
    public Train() {
        this.bistro = new Wagon(Type.BISTRO,null, null);
        this.engine = new Wagon(Type.ENGINE, null, bistro);
        bistro.setPrevious(engine);
    }

    /**
     * Fügt einen Wagen der ersten Klasse direkt hinter der Lok ein.
     */
    public void insertFirst() {
        Wagon newWagon = new Wagon(Type.FIRST, engine, engine.getNext());
    }

    /**
     * Fügt einen Wagen der zweiten Klasse direkt hinter dem Bistrowagen ein.
     */
    public void insertSecond() {
        Wagon newWagon = new Wagon(Type.SECOND, bistro, bistro.getNext());
    }

    @Override
    public String toString() {
        String result = String.format("%s%n", engine.toString());
        Wagon current = engine.getNext();
        while(current != null) {
            result += String.format("%s%n", current.toString());
            current = current.getNext();
        }
        return result;
    }
}
