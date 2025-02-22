import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @Test
    void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void testWithdraw() throws InsufficientFundsException {
        account.deposit(200.0);
        account.withdraw(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        account.deposit(100.0);
        Exception exception = assertThrows(InsufficientFundsException.class, () -> account.withdraw(150.0));
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void testGetBalance() {
        assertEquals(0.0, account.getBalance());
    }
}