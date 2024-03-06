package circles;

public interface ICircle {

    /**
     * Getter für den Mittelpunkt eines Kreises im Koordinatensystem.
     *
     * @return liefert den Mittelpunkt des Kreises.
     */
    Point getPoint();

    /**
     * Getter für den Radius eines Kreises im Koordinatensystem.
     *
     * @return Liefert den Radius des Kreises.
     */
    double getRadius();

    /**
     * Liefert einen neuen Kreis mit dem gleichen Radius dieses Kreises,
     * jedoch mit verschobenem Mittelpunkt (neues Point-Objekt!).
     *
     * @param dx Wert in x-Richtung (darf auch 0 oder negativ sein)
     * @param dy Wert in y-Richtung (darf auch 0 oder negativ sein)
     * @return neuen Kreis mit dem um dx und dy verschobenen Mittelpunkt
     * sowie dem gleichen Radius wie dieser Kreis.
     */
    Circle move(int dx, int dy);

    /**
     * Liefert einen neuen Kreis mit gleichem Mittelpunktwert (neues Point-Objekt!) wie dieser Kreis,
     * jedoch verändertem Radius.
     *
     * @param diff Wert um den der gegebene Radius verändert (größer oder kleiner) werden soll.
     *             Der Wert darf auch negativ oder 0 sein.
     * @return neuen Kreis mit dem gleichen Mittelpunktwert und verändertem Radius
     * @throws IllegalArgumentException falls der neu berechnete Radius 0 oder negativ werden sollte.
     */
    Circle resize(double diff);

    /**
     * Liefert einen neuen Kreis mit verschobenem Mittelpunkt (neues Point-Objekt!) und verändertem Radius.
     *
     * @param dx   Wert in x-Richtung (darf auch 0 oder negativ sein)
     * @param dy   Wert in y-Richtung (darf auch 0 oder negativ sein)
     * @param diff Wert um den der gegebene Radius verändert (größer oder kleiner) werden soll.
     *             Der Wert darf auch negativ oder 0 sein.
     * @return neuen Kreis mit verschobenem Mittelpunkt und verändertem Radius.
     * @throws IllegalArgumentException falls der neu berechnete Radius 0 oder negativ werden sollte.
     */
    default Circle moveAndResize(int dx, int dy, double diff){
        Circle newCircle = this.move(dx,dy);
        return newCircle.resize(diff);
        // IllegalArgumentException wird schon durch resize geworfen
    }
}
