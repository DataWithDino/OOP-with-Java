package bank;

import bank.accounts.Account;
import bank.utility.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse für Banken mit unterschiedlichen Namen.
 */
public class Bank {

    /**
     * Liste zur Verwaltung der Konten in der Bank.
     */
    private final List<Account> accounts = new ArrayList<>();

    /**
     * Unveränderlicher Name der Bank.
     */
    private final String bankname;

    /**
     * Nummerngenerator der Bank für Kontonummern.
     */
     private final NumberGenerator numberGenerator = new NumberGenerator();

    /**
     * Custom-Konstruktor. Setzt den Namen der Bank.
     * @param_name Name der Bank.
     */
    public Bank(String bankname) {
        this.bankname=bankname;
    }

    /**
     * Erzeugt ein neues Konto für einen Kunden.
     *
     * @param owner Name des Kontobesitzers
     * @return Kontonummer des neuen Account
     */
    public int createAccount(String owner) {
        Account createdAccount = new Account(owner,numberGenerator.next());
        accounts.add(createdAccount);
        return createdAccount.getAccountNumber();
    }

    /**
     * Liefert die aktuelle Anzahl an Konten in der Bank.
     *
     * @return Anzahl der vorhandenen Konten.
     */
    public int getAccountCount() {
        return accounts.size();
    }

    /**
     * Liefert die aktuelle Liste an Konten in der Bank.
     *
     * @return Liste der vorhandenen Konten.
     */
    public List<Account> getAccounts() {
        return new ArrayList<>(accounts);
    }

    /**
     * Prüft, ob ein Konto mit der gesuchten Nummer in der Bank vorhanden ist.
     *
     * @param number Nummer des gesuchten Kontos.
     * @return true, falls das Konto vorhanden ist, sonst false.
     */
    public boolean exists(int number) {
        for (Account account : accounts){
            if (account.getAccountNumber()==number) {
                return true;
            }
        }
        return false;
    }


    /**
     * Löscht das Konto mit der gesuchten Kontonummer, falls der Kontostand 0 ist.
     *
     * @param number Nummer des zu löschenden Kontos.
     * @return true, falls das Konto existiert und der Kontostand null ist sonst false.
     */
    public boolean deleteAccount(int number) {
        Account accountToDelete = findAccount(number);
        if (accountToDelete != null && accountToDelete.getBalance() == 0) {
            accounts.remove(accountToDelete);
            return true;
        }
        return false;
    }

    /**
     * Zahlt den Betrag amount in das Konto mit der gegebenen Kontonummer ein.
     *
     * @param number Kontonummer des gesuchten Kontos.
     * @param amount Einzuzahlender Betrag.
     * @return der Betrag der eingezahlt wurde. In jedem anderen Fall -1.
     */
    public double deposit(int number, double amount) {
        Account account = findAccount(number);
        if (account != null && amount > 0) {
            return account.deposit(amount);
        }
        return -1;
    }

    /**
     * Hebt den Betrag amount vom Konto mit der Kontonummer number ab.
     *
     * @param number Kontonummer des gesuchten Kontos.
     * @param amount Betrag, der abgehoben werden soll.
     * @return den Betrag der abgehoben wurde. In jedem anderen Fall -1.
     */
    public double withdraw(int number, double amount) {
        Account account = findAccount(number);
        if (account != null && account.getBalance()-amount>=0 && amount>0){
            return account.withdraw(amount);
        }
        return -1;
    }

    /**
     * Überweist den Betrag amount von einem Konto dieser Bank mit der Nummer from
     * auf ein Konto der gleichen Bank mit der Nummer to.
     *
     * @param from   Konto von dem der Betrag abgehoben werden soll.
     * @param to     Konto, auf das der Betrag überwiesen werden soll.
     * @param amount Betrag zum Überweisen.
     * @return true, falls beide Konten existieren und der Betrag tatsächlich überwiesen werden konnte.
     *          In jedem anderen Fall false.
     */
    public boolean transferMoney(int from, int to, double amount) {
        Account accountFrom = findAccount(from);
        Account accountTo = findAccount(to);
        if(accountFrom != null && accountTo != null && accountFrom.getBalance()-amount>=0){
            accountFrom.withdraw(amount);
            accountTo.deposit(amount);
            return true;
        }
        return false;
    }


    /**
     * Liefert den Kontostand zum Konto mit der gesuchten Kontonummer.
     *
     * @param number Kontonummer des gesuchten Kontos
     * @return aktuellen Kontostand des Kontos oder -1,
     *      falls das Konto nicht gefunden wurde.
     */
    public double getBalance(int number) {
        Account account = findAccount(number);
        if(account != null){
            return account.getBalance();
        }
        return -1;
    }

    /**
     * Getter für den Namen der Bank.
     * @return Namen der Bank.
     */
    public String getName() {
        return bankname;
    }

    /**
     * Liefert eine String-Darstellung aller Konten der Bank.
     *
     * @return Die Konten der Bank als String
     */
    @Override
    public String toString() {
        return bankname + ": " + accounts.toString() + "";
    }

    /**
     * Liefert Konto zur Kontonummer.
     *
     * @param number Kontonummer des gesuchten Kontos
     * @return das gesuchte Konto, falls es existiert andernfalls null
     */
    private Account findAccount(int number) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == number) {
                return account;
            }
        }
        return null;
    }

}
