package bank.accounts;

/**
 * Klasse für Konten innerhalb der Bank.
 */
public class Account {

    /**
     * Aktueller Kontostand. Darf nicht negativ werden.
     */
     private double balance=0;

    /**
     * Eindeutige Kontonummer innerhalb der Bank.
     */
    private final int accountNumber;

    /**
     * Besitzer des Kontos.
     */
    private final AccountOwner owner;

    /**
     * Custom-Konstruktor. Erzeugt ein neues Konto.
     * Setzt den Kontobesitzer und die Kontonummer.
     *
     * @param owner Name des Kontobesitzers.
     * @param accountNumber Kontonummer des neuen Kontos.
     */
    public Account(String owner, int accountNumber) {

        this.owner= new AccountOwner(owner);
        this.accountNumber=accountNumber;
    }

    /**
     * Zahlt den Betrag amount in das Konto ein. Falls amount negativ ist,
     * ändert sich der Kontostand nicht.
     *
     * @param amount Betrag zum Einzahlen.
     * @return Betrag, der tatsächlich eingezahlt wurde oder -1 bei negativem Betrag.
     */
    public double deposit(double amount) {
        if(amount>=0) {
            balance += amount;
            return amount;
        }
        return -1;
    }

    /**
     * Hebt den Betrag amount vom Konto ab. Falls der Kontostand nicht ausreicht
     * oder amount negativ ist, bleibt der Kontostand unverändert.
     *
     * @param amount Betrag zum Abheben.
     * @return abgehobener Betrag oder -1, falls nichts abgehoben werden konnte.
     */
    public double withdraw(double amount) {
        if (balance-amount>=0 && amount>0){
            balance-=amount;
            return amount;
        }
        else {
            return -1;
        }
    }

    /**
     * Getter für den Kontostand.
     *
     * @return aktuellen Kontostand des Kontos.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Getter für die Kontonummer.
     *
     * @return die Kontonummer des Kontos.
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Getter für den Namen des Account Owners.
     * @return Name des Account Owners
     */
    public String getName() {
        return owner.getName();
    }

    @Override
    public String toString() {
        return String.format("[%d, %s, %.2f]", accountNumber, owner.getName(), balance);
    }

}
