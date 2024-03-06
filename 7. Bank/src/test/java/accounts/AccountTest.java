package accounts;
import bank.accounts.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
public class AccountTest {

    @Test
    public void depositTest(){
        Account account1 = new Account("Dino",1234);
        account1.deposit(1000);
        Assertions.assertEquals(1000,account1.getBalance());

        Account account2 = new Account("Mina",0420);
        account2.deposit(-1);
        Assertions.assertEquals(0, account2.getBalance());
        Assertions.assertEquals(-1, account2.deposit(-1));
    }

    @Test
    public void withdrawTest(){
        Account account1 = new Account("Dino",1234);
        account1.deposit(1000);
        account1.withdraw(100);
        Assertions.assertEquals(900,account1.getBalance());

        Account account2 = new Account("Julian",0420);
        account2.deposit(1000);
        account1.withdraw(1200);
        Assertions.assertEquals(1000, account2.getBalance());
        Assertions.assertEquals(-1, account2.withdraw(1200));
    }

    @Test
    public void toStringTest(){
        Account account = new Account("Dino",1234);
        Assertions.assertEquals("[1234, Dino, 0,00]", account.toString());
    }
}
