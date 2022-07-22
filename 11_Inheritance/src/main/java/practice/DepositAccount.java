package practice;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome = LocalDate.now().plusMonths(1);

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = LocalDate.now();
    }

    @Override
    public void take(double amountToTake) {
        if (lastIncome.isBefore(LocalDate.now())) {
            if ((amountToTake > 0) && (amountToTake < balance)) {
                balance -= amountToTake;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
