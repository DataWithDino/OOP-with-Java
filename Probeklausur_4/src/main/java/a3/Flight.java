package a3;

/**
 * Interface für alle Arten von Flügen.
 */
public interface Flight {

    /**
     * Liefert den Startflughafen des Gesamtflugs.
     *
     * @return Startflughafen
     */
    Airport getFrom();

    /**
     * Liefert den Zielflughafen des Gesamtflugs.
     *
     * @return Zielflughafen
     */
    Airport getTo();

    /**
     * Berechnet den Ticketpreis für den Gesamtflug abhängig von der Sitzklasse.
     *
     * @param flightclass Sitzklasse für das Ticket
     * @return Preis des Ticktes (ohne Runden)
     */
    double getFinalPrice(FlightClass flightclass);

    /**
     * Berechnet die Gesamtdistanz, die während des Flugs zurückgelegt wird.
     *
     * @return Distanz in Kilometer
     */
    int getDistance();
}
