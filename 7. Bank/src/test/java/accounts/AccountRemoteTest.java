package accounts;
import bank.accounts.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
class AccountRemoteTest {
    private static final String TEST_STRING = "[1000, Tom, 200,00]";
    private static final String NAME = "Tom";
    private static final int TIMEOUT = 1000;
    private static final int ACCOUNT_NR = 1000;
    private static final int VALUE_1 = 100;
    private static final int VALUE_2 = 200;
    private static final int VALUE_3 = 300;
    private static final int VALUE_4 = 700;
    private static final int VALUE_5 = 50;

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(NAME, ACCOUNT_NR);
        account.deposit(VALUE_2);
    }


    public void testAccount() {
        Assertions.assertEquals(ACCOUNT_NR, account.getAccountNumber());
    }


    @Test
    void deposit() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(TIMEOUT), () -> {
            Assertions.assertEquals(VALUE_2, account.deposit(VALUE_2), 0);
            Assertions.assertEquals(-1, account.deposit(-VALUE_1), 0);
            Assertions.assertEquals(VALUE_3, account.deposit(VALUE_3), 0);
            Assertions.assertEquals(VALUE_4, account.getBalance(), 0);
        });
    }

    @Test
    void withdraw() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(TIMEOUT), () -> {
            // Korrektes abheben
            Assertions.assertEquals(VALUE_1, account.withdraw(VALUE_1), 0);
            Assertions.assertEquals(VALUE_1, account.getBalance(), 0);
            // abheben negativer Wert
            Assertions.assertEquals(-1, account.withdraw(-VALUE_2), 0);
            // abheben bis 0
            Assertions.assertEquals(VALUE_1, account.withdraw(VALUE_1), 0);
            Assertions.assertEquals(0, account.getBalance(), 0);
            // abheben bei leerem Kontostand
            Assertions.assertEquals(-1, account.withdraw(VALUE_5), 0);
            Assertions.assertEquals(0, account.getBalance(), 0);
        });
    }


    @Test
    void testToString() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(TIMEOUT), () -> {
            Assertions.assertEquals(TEST_STRING, account.toString());
        });
    }
}