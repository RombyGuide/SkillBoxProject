import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();
    private int numberTransaction = 1;

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    private void standardTransfer(String fromAccountNum, String toAccountNum, long amount) {
        int fromAccount = Integer.parseInt(accounts.get(fromAccountNum).getAccNumber());
        int toAccount = Integer.parseInt(accounts.get(toAccountNum).getAccNumber());
        if (fromAccount < toAccount) {
            synchronized (accounts.get(fromAccountNum)) {
                synchronized (accounts.get(toAccountNum)) {
                    accounts.get(fromAccountNum).reduceMoney(amount);
                    accounts.get(toAccountNum).addMoney(amount);
                }
            }
        } else {
            synchronized (accounts.get(toAccountNum)) {
                synchronized (accounts.get(fromAccountNum)) {
                    accounts.get(fromAccountNum).reduceMoney(amount);
                    accounts.get(toAccountNum).addMoney(amount);
                }
            }
        }
        System.out.println("Транзакция №" + numberTransaction++ + " прошла успешно.\n" +
                "Баланс отправителя " + fromAccountNum + " - " + getBalance(fromAccountNum) + " руб.\n" +
                "Баланс получателя " + toAccountNum + " - " + getBalance(toAccountNum) + " руб.\n");
    }

    /**
     * Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        if (accounts.get(fromAccountNum).isBlockingAccounts()) {
            System.out.println("Транзакция №" + numberTransaction++ +  " невозможна, счет отправителя: " +
                    fromAccountNum + " заблокирован!\n");
        } else if (accounts.get(toAccountNum).isBlockingAccounts()) {
            System.out.println("Транзакция №" + numberTransaction++ +  " невозможна, счет получателя: " +
                    toAccountNum + " заблокирован!\n");
        } else if (getBalance(fromAccountNum) < amount) {
            System.out.println("Транзакция №" + numberTransaction++ + " невозможна, недостаточно средств на счету " +
                    fromAccountNum + ", остаток: " + getBalance(fromAccountNum) + " руб.\n");
        } else if (amount > 50000) {
            try {
                if (isFraud(fromAccountNum, toAccountNum, amount)) {
                    accounts.get(fromAccountNum).setBlockingAccounts();
                    accounts.get(toAccountNum).setBlockingAccounts();
                    System.out.println("Подозрительная транзакция! Транзакция № " + numberTransaction++ +
                            ", оба счета заблокированы: " + fromAccountNum + ", " + toAccountNum + "\n");
                }
                else {
                    standardTransfer(fromAccountNum, toAccountNum, amount);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            standardTransfer(fromAccountNum, toAccountNum, amount);
        }
    }

    /**
     * Метод getBalance() возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public void addAccount(String num, Account account) {
        accounts.put(num, account);
    }
}
