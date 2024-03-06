package bank.accounts;

/**
 * Klasse für Kontenbesitzer.
 */
public class AccountOwner {

    /**
     * Name des Kontobesitzers.
     */
    private final String name;

    /**
     * Custom-Konstruktor. Setzt den Namen des Kontobesitzers.
     *
     * @param name Name des Kontobesitzers
     */
    public AccountOwner(String name) {
        this.name = name;
    }

    /**
     * Getter für den Kundennamen.
     *
     * @return Kundennamen
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
