package utility;
import bank.Bank;
import bank.accounts.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

public class BankTest {
    @Test
    public void nameTest(){
        Bank bank = new Bank("Sparkasse");
        Assertions.assertEquals("Sparkasse",bank.getName());
    }

    @Test
    public void getAccountCountTest(){
        Bank bank = new Bank("Sparkasse");
        Assertions.assertEquals(0,bank.getAccountCount());
        bank.createAccount("Dino");
        Assertions.assertEquals(1,bank.getAccountCount());
        bank.deleteAccount(1000);
        Assertions.assertEquals(0,bank.getAccountCount());

    }
    @Test
    public void existsTest() {
        Bank bank = new Bank("Sparkasse");
        bank.createAccount("Dino");
        Assertions.assertEquals(true,bank.exists(1000));
        Assertions.assertEquals(false,bank.exists(2000));
    }
    @Test
    public void deleteAccountTest(){
        Bank bank = new Bank("Sparkasse");
        bank.createAccount("Dino");
        Assertions.assertEquals(true,bank.deleteAccount(1000));

        bank.deleteAccount(1000);
        Assertions.assertEquals(0, bank.getAccountCount());
        Assertions.assertEquals(false,bank.deleteAccount(1000));

        bank.createAccount("Dino");
        bank.deposit(1000,1);
        Assertions.assertEquals(false,bank.deleteAccount(1000));
    }

    @Test
    public void depositTest() {
        Bank bank = new Bank("Sparkasse");
        bank.createAccount("Dino");
        Assertions.assertEquals(-1,bank.deposit(1000,0));
        bank.deposit(1000,1);
        Assertions.assertEquals(1,bank.getBalance(1000));

    }

    @Test
    public void withDrawTest() {
        Bank bank = new Bank("Sparkasse");
        bank.createAccount("Dino");
        Assertions.assertEquals(-1,bank.withdraw(1000,10));
        bank.deposit(1000,1);
        Assertions.assertEquals(1,bank.withdraw(1000,1));
        bank.withdraw(1000,1);
        Assertions.assertEquals(0,bank.getBalance(1000));

    }

    @Test
    public void transferTest(){
        Bank bank = new Bank("Sparkasse");
        bank.createAccount("Dino");
        Assertions.assertEquals(false,bank.transferMoney(1000,1001,10));

        bank.createAccount("Mina");
        Assertions.assertEquals(false,bank.transferMoney(1000,1001,10));

        bank.deposit(1000,1000);
        Assertions.assertEquals(true,bank.transferMoney(1000,1001,10));
        Assertions.assertEquals(990,bank.getBalance(1000));
        Assertions.assertEquals(10,bank.getBalance(1001));
        Assertions.assertEquals(false,bank.transferMoney(1001,1000,100));
    }
    @Test
    public void getAccountsTest(){
        Bank bank = new Bank("Sparkasse");
        bank.createAccount("Dino");
        List<Account> accounts = bank.getAccounts();
        Assertions.assertEquals(accounts,bank.getAccounts());
    }
    @Test
    public void testGetBalance() {
        Bank bank = new Bank("Sparkasse");
        bank.createAccount("Dino");
        bank.deposit(1000, 500);
        Assertions.assertEquals(500, bank.getBalance(1000), 0.001);
        Assertions.assertEquals(-1, bank.getBalance(2000), 0.001);
    }
    @Test
    public void toStringTest(){
        Bank bank = new Bank("Sparkasse");
        Assertions.assertEquals("Sparkasse: []",bank.toString());
        bank.createAccount("Dino");
        Assertions.assertEquals(1,bank.getAccountCount());
        Assertions.assertEquals("Sparkasse: [[1000, Dino, 0,00]]",bank.toString());
    }

}
