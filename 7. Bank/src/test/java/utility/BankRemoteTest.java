package utility;
import bank.Bank;
import bank.accounts.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
class BankRemoteTest {
    private static final String TEST_STRING1 = "DKB: [[1000, Test1, 100,00]]";
    private static final String TEST_STRING2 = "Hypo: []";
    private static final String NAME = "Test";
    private static final String BANK1 = "DKB";
    private static final String BANK2 = "Sparkasse";
    private static final String BANK3 = "Hypo";
    private static final int ACCOUNT_NR = 1000;
    private static final int TIMEOUT = 1000;
    private static final int VALUE_1 = 100;
    private static final int VALUE_2 = 200;
    private static final int VALUE_3 = 300;


    private Bank bank1;
    private Bank bank2;
    private Bank bank3;

    @BeforeEach
    void setUp() {
        bank1 = new Bank(BANK1);
        bank2 = new Bank(BANK2);
        bank3 = new Bank(BANK3);
    }


    @Test
    void createAccount() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(TIMEOUT), () -> {
            Stream.iterate(1, x -> x + 1).limit(10).forEach(x -> bank1.createAccount(NAME + x));
            Stream.iterate(1, x -> x + 1).limit(5).forEach(x -> bank2.createAccount(NAME + x));
            Assertions.assertEquals(10, bank1.getAccountCount());
            Assertions.assertEquals(5, bank2.getAccountCount());
            Assertions.assertEquals(0, bank3.getAccountCount());
            Assertions.assertEquals(TEST_STRING2, bank3.toString());
        });
    }

    @Test
    void deleteAccount() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(TIMEOUT), () -> {
            // Initialisierung der Konten in verschiedenen Banken
            int test1 = bank1.createAccount(NAME + 1);
            int test2 = bank1.createAccount(NAME + 2);

            // Löschen wenn noch Geld vorhanden ist
            bank1.deposit(test1, VALUE_2);
            Assertions.assertFalse(bank1.deleteAccount(test1));
            Assertions.assertEquals(2, bank1.getAccountCount());

            // Löschen wenn Konto leer ist
            bank1.withdraw(test1, VALUE_2);
            Assertions.assertTrue(bank1.deleteAccount(test1));
            Assertions.assertEquals(1, bank1.getAccountCount());

            // Löschen wenn Konto nicht vorhanden
            Assertions.assertFalse(bank1.deleteAccount(ACCOUNT_NR / 2));
        });
    }

    @Test
    void deposit() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(TIMEOUT), () -> {
            int test1 = bank1.createAccount(NAME + 1);
            // Konto gefunden
            Assertions.assertEquals(VALUE_2, bank1.deposit(test1, VALUE_2));
            // Konto nicht gefunden
            Assertions.assertEquals(-1, bank1.deposit(test1 + 1, VALUE_2));
            // Betrag negativ bei existierendem Konto
            Assertions.assertEquals(-1, bank1.deposit(test1, -VALUE_2));
        });
    }

    @Test
    void withdraw() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(TIMEOUT), () -> {
            int test1 = bank1.createAccount(NAME + 1);
            bank1.deposit(test1, VALUE_2);
            // Konto gefunden
            Assertions.assertEquals(VALUE_1, bank1.withdraw(test1, VALUE_1));
            Assertions.assertEquals(TEST_STRING1, bank1.toString());
            // Konto nicht gefunden
            Assertions.assertEquals(-1, bank1.withdraw(test1 + 1, VALUE_2));
            // Betrag negativ bei existierendem Konto
            Assertions.assertEquals(-1, bank1.withdraw(test1, -VALUE_2));
        });
    }

    @Test
    void inBankTransfer() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(TIMEOUT), () -> {
            int test1 = bank1.createAccount(NAME + 1);
            int test2 = bank1.createAccount(NAME + 2);

            // Überweisung, beide Konten existieren, Geld nicht vorhanden
            Assertions.assertFalse(bank1.transferMoney(test1, test2, VALUE_3));

            // Überweisung, beide Konten existieren, Geld vorhanden
            bank1.deposit(test1, VALUE_3);
            Assertions.assertTrue(bank1.transferMoney(test1, test2, VALUE_3));

            // Konten nicht vorhanden
            Assertions.assertFalse(bank1.transferMoney(test1 - 1, test2, VALUE_3));
            Assertions.assertFalse(bank1.transferMoney(test1, test2 + 2, VALUE_3));
        });
    }

    @Test
    void interBankTransfer() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(TIMEOUT), () -> {
            // Initialisierung der Konten in verschiedenen Banken
            int test1 = bank1.createAccount(NAME + 1);
            int test2 = bank2.createAccount(NAME + 2);

            bank1.deposit(test1, VALUE_3);

            // Geld transferieren
            bank2.deposit(test2, bank1.withdraw(test1, VALUE_3 / 2.0));
            Assertions.assertEquals(VALUE_3 / 2.0, bank1.getBalance(test1));
            Assertions.assertEquals(VALUE_3 / 2.0, bank2.getBalance(test2));
        });
    }

    @Test
    void bankManagement() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(TIMEOUT), () -> {
            // Initialisierung der Konten in verschiedenen Banken
            int test1 = bank1.createAccount(NAME + 1);
            int test2 = bank1.createAccount(NAME + 2);
            int test3 = bank2.createAccount(NAME + 3);

            // Konten wurden korrekt in die Banken eingefügt
            Assertions.assertEquals(2, bank1.getAccountCount());
            Assertions.assertEquals(1, bank2.getAccountCount());

            // In beiden Banken fangen die Nummern mit 1000
            Assertions.assertTrue(bank1.exists(ACCOUNT_NR));
            Assertions.assertTrue(bank2.exists(ACCOUNT_NR));

            // Löschen wenn Konto leer ist
            Assertions.assertTrue(bank1.deleteAccount(test1));
            Assertions.assertTrue(bank1.deleteAccount(test2));
            Assertions.assertTrue(bank2.deleteAccount(test3));
            Assertions.assertEquals(0, bank1.getAccountCount());
            Assertions.assertEquals(0, bank2.getAccountCount());

        });
    }

}