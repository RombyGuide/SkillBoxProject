import junit.framework.TestCase;

public class TestBank extends TestCase {
    Bank bank;
    Account account1, account2;

    @Override
    protected void setUp() {
        bank = new Bank();
        account1 = new Account();
        account1.setAccNumber("657843");
        account1.setMoney(50000);
        account2 = new Account(100000, "123465");
        bank.addAccount(account1.getAccNumber(), account1);
        bank.addAccount(account2.getAccNumber(), account2);
        bank.transfer(account1.getAccNumber(), account2.getAccNumber(), 50000);
    }

    public void testTransferSender() {
        long actual = account1.getMoney();
        long expected = 0;
        assertEquals(expected, actual);
    }

    public void testTransferGetter() {
        long actual = account2.getMoney();
        long expected = 150000;
        assertEquals(expected, actual);
    }

    public void testGetBalance() {
        long actual = bank.getBalance(account1.getAccNumber());
        long expected = 0;
        assertEquals(expected, actual);
    }

    public void testBigTransaction(){
        bank.transfer(account2.getAccNumber(), account1.getAccNumber(), 60000);
        try {
            Thread.sleep(1100);
            if(account1.isBlockingAccounts() || account2.isBlockingAccounts()){
                long actual = account2.getMoney();
                long expected = 150000;
                assertEquals(expected, actual);
            }
            else {
                long actual = account2.getMoney();
                long expected = 90000;
                assertEquals(expected, actual);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}