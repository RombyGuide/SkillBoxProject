package BankAccount;

import java.time.LocalDate;
import java.time.Month;

public class GamePaymentAccount extends PaymentAccount {

    private LocalDate lastExpensesDate;

    public GamePaymentAccount(double amount) {
        super(amount);
        lastExpensesDate = LocalDate.of(2019, Month.NOVEMBER, 15);
    }

    public LocalDate getLastExpensesDate() {
        return lastExpensesDate;
    }

    @Override
    void startMessage() {
        System.out.println("Открыт игровой расчетный " + CURRENCY + " счет № " + getAccountId() +
                ". Баланс: " + getAmount() + CURRENCY);
    }

    @Override
    public void replenish(double sum) {
        super.replenish(sum);
    }

    @Override
    public void withdraw(double sum) {
        if (sum > 0 && getAmount() >= sum) {
            setAmount(getAmount() - sum - getAmount() * 0.01);
            System.out.println("Баланс счета № " + getAccountId() + " уменьшен на " + sum + CURRENCY +
                    ". Остаток средств после операции: " + getAmount() + CURRENCY);
        } else {
            System.out.println("Неудалось уменьшить баланс на счете № " +
                    getAccountId() + ". Недействительная сумма.");
        }

    }

    @Override
    public String toString() {
        return "Остаток на счете " + getAccountId() +
                " составляет " + getAmount() + CURRENCY;
    }
}
